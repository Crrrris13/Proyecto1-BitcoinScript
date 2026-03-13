package bitcoinscript.opcodes;

public class OpCodeFactory {

    public static OpCode getInstruction(String token) {
        switch (token) {
            case "OP_DUP":
                return new OpDup();
            case "OP_DROP":
                return new OpDrop();
            case "OP_HASH160":
                return new OpHash160();
            case "OP_EQUAL":
                return new OpEqual();   
            case "OP_EQUALVERIFY":
                return new OpEqualVerify();
            case "OP_CHECKSIG":
                return new OpCheckSig();
            case "OP_ADD":
                return new OpAdd();
            case "OP_SUB":
                return new OpSub();
            case "OP_BOOLAND":
                return new OpBooland();
            case "OP_NOT":
                return new OpNot(); 
            case "OP_IF":
                return new OpIf();
            case "OP_ELSE":
                return new OpElse();
            case "OP_ENDIF":
                return new OpEndIf();
            case "OP_BOOLOR":
                return new OpBoolOr();
            case "OP_RETURN":
                return new OpReturn();
            case "OP_VERIFY":
                return new OpVerify();
            case "OP_0": 
            case "OP_FALSE": 
                return new OpLiteral("0", "OP_0");
            case "OP_1": 
                return new OpLiteral("1", "OP_1");
            case "OP_2": 
                return new OpLiteral("2", "OP_2");
            case "OP_3": 
                return new OpLiteral("3", "OP_3");
            case "OP_4": 
                return new OpLiteral("4", "OP_4");
            case "OP_5": 
                return new OpLiteral("5", "OP_5");
            case "OP_6": 
                return new OpLiteral("6", "OP_6");
            case "OP_7": 
                return new OpLiteral("7", "OP_7");
            case "OP_8": 
                return new OpLiteral("8", "OP_8");
            case "OP_9": 
                return new OpLiteral("9", "OP_9");
            case "OP_10": 
                return new OpLiteral("10", "OP_10");
            case "OP_11": 
                return new OpLiteral("11", "OP_11");
            case "OP_12": 
                return new OpLiteral("12", "OP_12");
            case "OP_13": 
                return new OpLiteral("13", "OP_13");
            case "OP_14": 
                return new OpLiteral("14", "OP_14");
            case "OP_15": 
                return new OpLiteral("15", "OP_15");
            case "OP_16": 
                return new OpLiteral("16", "OP_16");
            default:
                return new PushData(token);
        }
    }
}
