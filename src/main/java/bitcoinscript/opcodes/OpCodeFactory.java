public class OpCodeFactory {

    public OpCode getInstruction(String instruction) {
        switch (instruction) {
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

            case "OP_0":
            case "OP_FALSE":
                return new LiteralData("0");
            case "OP_1":
            case "OP_TRUE":
                return new LiteralData("1");
            
            case "OP_2":
                return new LiteralData("2");
            
            case "OP_3":
                return new LiteralData("3");

            case "OP_4":
                return new LiteralData("4");

            case "OP_5":
                return new LiteralData("5");

            case "OP_6":
                return new LiteralData("6");

            case "OP_7":
                return new LiteralData("7");

            case "OP_8":
                return new LiteralData("8");

            case "OP_9":
                return new LiteralData("9");

            case "OP_10":
                return new LiteralData("10");

            case "OP_11":
                return new LiteralData("11");
            
            case "OP_12":
                return new LiteralData("12");
            
            case "OP_13":
                return new LiteralData("13");

            case "OP_14":
                return new LiteralData("14");

            case "OP_15":
                return new LiteralData("15");

            case "OP_16":
                return new LiteralData("16");
            default:
                return new LiteralData(instruction);
        }
    }
}
