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
            case "OP_0":
            case "OP_FALSE":
                return new PushData("0");
            case "OP_1":
            case "OP_TRUE":
                return new PushData("1");
            
            case "OP_2":
                return new PushData("2");
            
            case "OP_3":
                return new PushData("3");

            case "OP_4":
                return new PushData("4");

            case "OP_5":
                return new PushData("5");

            case "OP_6":
                return new PushData("6");

            case "OP_7":
                return new PushData("7");

            case "OP_8":
                return new PushData("8");

            case "OP_9":
                return new PushData("9");

            case "OP_10":
                return new PushData("10");

            case "OP_11":
                return new PushData("11");
            
            case "OP_12":
                return new PushData("12");
            
            case "OP_13":
                return new PushData("13");

            case "OP_14":
                return new PushData("14");

            case "OP_15":
                return new PushData("15");

            case "OP_16":
                return new PushData("16");
            default:
                return new PushData(token);
        }
    }
}
