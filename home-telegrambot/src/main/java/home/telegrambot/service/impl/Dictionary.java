package home.telegrambot.service.impl;

import home.telegrambot.bot.DictionaryInitialization;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Dictionary {

    public static List<String> dictionary;

    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryInitialization.class);

    private Dictionary(){}

    public static List<String> getDictionary(String dictionaryFileName){
        if(dictionary == null) {
            dictionary = new ArrayList<>();


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
                            LOGGER.info(new Date() + ": Dictionary read break. Dictionary size is: "+dictionary.size());
                            break;
                        }
                        dictionary.add(st);
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


}
