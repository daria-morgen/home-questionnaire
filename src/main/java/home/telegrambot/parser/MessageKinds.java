package home.telegrambot.parser;

public enum MessageKinds {


    SAVE(
        "save"
    ),

    RUN_TEST(
        "run test"
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
                return type;
            }
        }
        throw new RuntimeException("unknown type");
    }
}
