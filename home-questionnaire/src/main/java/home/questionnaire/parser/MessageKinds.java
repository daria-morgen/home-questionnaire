package home.questionnaire.parser;

public enum MessageKinds {

    WORD(
            "word"
    ),

    THEME(
            "theme"
    ),

    SAVE(
        "save"
    ),

    RUN_TEST(
        "run test"
    ),

    NONE(
        "unknown type"
    );

    private final String msg;

    MessageKinds(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    static public MessageKinds getType(String pType) {
        for (MessageKinds type: MessageKinds.values()) {
            if (type.getMsg().equals(pType)) {
                System.out.println("in block");
                return type;
            }
        }
//        throw new RuntimeException("unknown type");
        return MessageKinds.NONE;
    }
}
