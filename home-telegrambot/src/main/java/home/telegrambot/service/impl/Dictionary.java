package home.telegrambot.service.impl;

import home.telegrambot.bot.DictionaryInitialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Dictionary {

    private static Dictionary dictionary;

    private  List<String> dictionaryList;

    private Map<String,String> dictionaryMap;

    private static final Logger LOGGER = LoggerFactory.getLogger(Dictionary.class);

    private Dictionary(){}

    public static Dictionary getDictionary(String dictionaryFileName){

        if(dictionary == null) {
            dictionary = new Dictionary();

            dictionary.dictionaryList =  new ArrayList<>();


            File file = new File(dictionaryFileName);

            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            String st;
            try {
                while (true) {
                        assert br != null;
                        if ((st = br.readLine()).trim().equals("</xdxf>")) {
                            LOGGER.info(new Date() + ": Dictionary read break. Dictionary size is: "+dictionary.dictionaryList.size());
                            break;
                        }
                    dictionary.dictionaryList.add(st);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                assert br != null;
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return dictionary;
    }

    //todo add impl.
    public String getRandomWord(){
        return dictionaryList.get(0);
    }

    //todo add impl.
    public String getWordTranslation(String translatableWord){
        return dictionaryMap.get(translatableWord);
    }

}
