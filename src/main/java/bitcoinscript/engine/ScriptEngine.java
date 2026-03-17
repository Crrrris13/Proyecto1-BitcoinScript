package bitcoinscript.engine;

import bitcoinscript.opcodes.OpCode;
import bitcoinscript.opcodes.OpCodeFactory;
import bitcoinscript.opcodes.OpElse;
import bitcoinscript.opcodes.OpEndIf;
import bitcoinscript.opcodes.OpIf;
import bitcoinscript.opcodes.OpNotIf;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Motor principal de ejecucion del interprete.
 * Es responsable de: Parsear scripts (scriptSig y scriptPubKey), convertir tokens en instrucciones (OpCode) ejecutar 
 * instrucciones en orden secuencial, gestionar la pila principal y controlar estructuras de flujo (OP_IF, OP_ELSE, OP_ENDIF)
 * Su resultado final se determina evaluando el elemento superior de la pila. Si es distinto de 0, el script es valido.
 */
public class ScriptEngine {
    private BitcoinStack mainStack;
    private List<OpCode> instructions;
    private boolean traceMode;
    private Stack<Boolean> executionStack;
    private Stack<Boolean> elseStateStack;

    /**
     * Constructor del motor de ejecucion. Inicializa la pila, las instrucciones y las estructuras de control de flujo.
     */
    public ScriptEngine() {
        this.mainStack = new BitcoinStack();
        this.instructions = new ArrayList<>();
        this.traceMode = false;
        this.executionStack = new Stack<>();
        this.elseStateStack = new Stack<>();
    }
    
    /**
     * Activa o desactiva el TraceMode. Cuando esta activo, se imprime el estado de la pila y cada instruccion ejecutada.
     * @param enabled true para activar el modo trace
     */
    public void setTraceMode(boolean enabled) {
        this.traceMode = enabled;
    }

    /**
     * Ejecuta un script compuesto por scriptSig y scriptPubKey.
     * @param scriptSig datos de entrada (firma, clave publica, etc.)
     * @param scriptPubKey condiciones de validacion
     * @return true si el script es valido, false en caso contrario
     */
    public boolean executeScript(String scriptSig, String scriptPubKey) {
        try {
            mainStack = new BitcoinStack();
            executionStack.clear();
            elseStateStack.clear();
            instructions.clear();
            
            parseScript(scriptSig);
            parseScript(scriptPubKey);
            
            System.out.println("Iniciando ejecucion");
            System.out.println("Total de instrucciones: " + instructions.size());
            if (traceMode) {
                System.out.println("Modo TRACE activado\n");
            }

            for (int i = 0; i < instructions.size(); i++) {
                OpCode instruction = instructions.get(i);
                if (traceMode) {
                    System.out.println("Stack: " + mainStack);
                }
                
                if (traceMode) {
                    System.out.println("Paso " + (i + 1) + ": " + instruction.getName());
                }

                boolean isControlFlow = instruction instanceof OpIf || instruction instanceof OpNotIf || instruction instanceof OpElse || instruction instanceof OpEndIf;
                if (!isControlFlow && !shouldExecute()) {
                    if (traceMode) {
                        System.out.println("  Instrucción saltada debido a condición de control de flujo");
                        System.out.println();
                    }
                    continue;
                }
                
                instruction.execute(mainStack, this);
                
                if (traceMode) {
                    System.out.println("  Pila: " + mainStack.toString());
                    System.out.println();
                }
            }
            if (mainStack.isEmpty()) {
                System.out.println("Pila vacía al final");
                return false;
            }
            
            String topElement = mainStack.peek();
            boolean isValid = !topElement.equals("0");
            
            if (isValid) {
                System.out.println("Script validado correctamente");
                System.out.println("Elemento final en pila: " + topElement);
            } else {
                System.out.println("Elemento final es falso");
            }
            
            return isValid;
            
        } catch (Exception e) {
            System.out.println("Error durante ejecución: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Parsea un script en tokens y los convierte en instrucciones. Cada token se transforma en un objeto OpCode 
     * mediante la OpCodeFactory.
     * @param script script a parsear
     * @throws RuntimeException si se encuentra un token invalido
     */
    private void parseScript(String script) {
        if (script == null || script.trim().isEmpty()) {
            return;
        }

        String[] tokens = script.trim().split("\\s+");
        
        for (String token : tokens) {
            OpCode instruction = OpCodeFactory.getInstruction(token);
            
            if (instruction == null) {
                throw new RuntimeException("Token inválido: " + token);
            }
            
            instructions.add(instruction);
        }
    }
    
    /**
     * Devuelve el estado actual de la pila.
     * @return lista con la representacion de la pila
     */
    public List<String> getStackState() {
        List<String> state = new ArrayList<>();
        state.add(mainStack.toString());
        return state;
    }

    /**
     * Determina si las instrucciones deben ejecutarse.
     * @return true si se deben ejecutar, false si deben omitirse
     */

    public boolean shouldExecute() {
        if (executionStack.isEmpty()) {
            return true;
        }
        
        for (boolean condition : executionStack) {
            if (!condition) {
                return false;
            }
        }

        return true;
    }

    /**
     * Entra en un bloque condicional IF.
     * @param condition resultado de la evaluacion de la condicion
     */
    public void enterIf(boolean condition) {
        executionStack.push(condition);
        elseStateStack.push(false);
    }

    /**
     * Maneja la transicion a un bloque ELSE.
     * @throws RuntimeException si no existe un IF previo o si ya se ejecuto un ELSE
     */
    public void enterElse() {
        if (executionStack.isEmpty()) {
            throw new RuntimeException("OP_ELSE sin OP_IF correspondiente");
        }

        if (elseStateStack.peek()) {
            throw new RuntimeException("OP_ELSE duplicado");
        }

        boolean wasExecuted = executionStack.pop();
        executionStack.push(!wasExecuted);

        elseStateStack.pop();
        elseStateStack.push(true);
    }

    /**
     * Finaliza un bloque condicional IF/ELSE.
     * @throws RuntimeException si no existe un IF correspondiente
     */
    public void exitIf() {
        if (executionStack.isEmpty()) {
            throw new RuntimeException("OP_ENDIF sin OP_IF correspondiente");
        }
        executionStack.pop();
        if (!elseStateStack.isEmpty()) {
            elseStateStack.pop();
        }
    }

    /**
     * Evalua si un valor es considerado verdadero en Bitcoin Script.
     * @param value valor a evaluar
     * @return true si es verdadero, false si es falso
     */
    public static boolean isTrue(String value) {
        if (value == null || value.isEmpty()) {
            return false;
        }

        if (value.equals("0")) {
            return false;
        }

        if(value.matches("0+")) {
            return false;
        }
        return true;
    }


}
