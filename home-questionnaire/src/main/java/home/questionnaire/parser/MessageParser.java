package home.questionnaire.parser;


import home.questionnaire.parser.persistent.Persistable;

public interface MessageParser {

    Persistable parse(String message);

}
