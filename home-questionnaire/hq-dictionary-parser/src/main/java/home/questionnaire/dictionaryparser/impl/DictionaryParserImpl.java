package home.questionnaire.dictionaryparser.impl;

import home.questionnaire.dictionaryparser.DictionaryParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.*;

public class DictionaryParserImpl implements DictionaryParser {

    private static final Logger LOGGER = LoggerFactory.getLogger(DictionaryParserImpl.class);

    private Map<String, String> dictionaryMap;
    //todo think about initialisation
    private boolean isHeadTag;
    private StringBuilder currentLine;
    private List<StringBuilder> dictionaryList;

    @Override
    public Map<String, String> parsXDXFDictionary(File file) {

        dictionaryList = new ArrayList<>();

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
                if (!(st = br.readLine()).trim().equals("</xdxf>")) {
                    parseLine(st);
                } else {
                    break;
                }
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

        prepareDictionaryMap();

        return dictionaryMap;
    }

    private void parseLine(String line) {

        if (isHeadTag) {
            currentLine.append(line.trim());
        }
        if (line.contains("<ar>")) {
            currentLine = new StringBuilder();
            isHeadTag = true;
            currentLine.append(line.trim());

        }
        if (line.contains("</ar>")) {
            isHeadTag = false;
            currentLine.append(line.trim());
            try {
                dictionaryList.add(currentLine.replace(currentLine.indexOf("&quot;"), currentLine.indexOf("&quot;") + 5, "").replace(currentLine.indexOf("&quot;"), currentLine.indexOf("&quot;") + 5, "")
                );
            } catch (IndexOutOfBoundsException e) {
                dictionaryList.add(currentLine);
            }

        }
    }

    private void prepareDictionaryMap() {
        dictionaryMap = new HashMap<>();
        dictionaryList.forEach(e -> {
                    String value = e.substring(e.indexOf("<k>") + 3, e.indexOf("</k>"));
                    String key = e
                            .replace(e.indexOf("<ar>"), e.indexOf("</ar>"), "")
                            .replace(0, 5, "")
                            .substring(0, e.indexOf("</ar>"));


                    if (!key.equals("") && !value.equals("")) {
                        dictionaryMap.put(
                                key,
                                value
                        );
                    }
                }
        );
    }
}
