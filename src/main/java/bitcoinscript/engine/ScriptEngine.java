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

public class ScriptEngine {
    private BitcoinStack mainStack;
    private List<OpCode> instructions;
    private boolean traceMode;
    private Stack<Boolean> executionStack;
    private Stack<Boolean> elseStack;

    public ScriptEngine() {
        this.mainStack = new BitcoinStack();
        this.instructions = new ArrayList<>();
        this.traceMode = false;
        this.executionStack = new Stack<>();
        this.elseStack = new Stack<>();
    }
    
    public void setTraceMode(boolean enabled) {
        this.traceMode = enabled;
    }

    public boolean executeScript(String scriptSig, String scriptPubKey) {
        try {
            mainStack = new BitcoinStack();
            executionStack.clear();
            elseStack.clear();
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
    
    private void parseScript(String script) {
        if (script == null || script.trim().isEmpty()) {
            return;
        }

        String[] tokens = script.trim().split("\\s+");
        
        for (String token : tokens) {
            OpCode instruction = OpCodeFactory.getInstruction(token);
            if (traceMode) {
                System.out.println("Stack: " + mainStack);
            }
            
            if (instruction == null) {
                throw new RuntimeException("Token inválido: " + token);
            }
            
            instructions.add(instruction);
        }
    }
    
    public List<String> getStackState() {
        List<String> state = new ArrayList<>();
        state.add(mainStack.toString());
        return state;
    }

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

    public void enterIf(boolean condition) {
        executionStack.push(condition);
        elseStack.push(false);
    }

    public void enterElse() {
        if (executionStack.isEmpty()) {
            throw new RuntimeException("OP_ELSE sin OP_IF correspondiente");
        }

        if (elseStack.isEmpty()) {
            throw new RuntimeException("OP_ELSE duplicado");
        }

        boolean wasExecuted = executionStack.pop();
        executionStack.push(!wasExecuted);

        elseStack.pop();
        elseStack.push(true);
    }

    public void exitIf() {
        if (executionStack.isEmpty()) {
            throw new RuntimeException("OP_ENDIF sin OP_IF correspondiente");
        }
        executionStack.pop();
        if (!elseStack.isEmpty()) {
            elseStack.pop();
        }
    }


}
