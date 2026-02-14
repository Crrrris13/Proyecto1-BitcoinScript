package bitcoinscript.engine;

import bitcoinscript.opcodes.OpCode;
import bitcoinscript.opcodes.OpCodeFactory;
import java.util.ArrayList;
import java.util.List;

public class ScriptEngine {
    private BitcoinStack mainStack;
    private List<OpCode> instructions;
    private boolean traceMode;

    public ScriptEngine() {
        this.mainStack = new BitcoinStack();
        this.instructions = new ArrayList<>();
        this.traceMode = false;
    }
    
    public void setTraceMode(boolean enabled) {
        this.traceMode = enabled;
    }

    public boolean executeScript(String scriptSig, String scriptPubKey) {
        try {
            mainStack = new BitcoinStack();
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
                
                instruction.execute(mainStack);
                
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
}
