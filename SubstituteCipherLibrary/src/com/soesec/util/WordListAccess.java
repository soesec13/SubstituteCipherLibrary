/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soesec.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author sebi
 */
public class WordListAccess {
    private String[] words;
    private final String path = "src\\com\\soesec\\data\\words.txt";
    public static final String wordSeperators = "[\n:,. !']";
    private WordListAccess() {
        try 
        {
            File f = new File(path);
            BufferedReader bufferedReader = new BufferedReader(new FileReader(f));
            List<String> lines = new ArrayList<String>();
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
            bufferedReader.close();
            words = lines.toArray(new String[lines.size()]);
        } 
        catch (Exception e) 
        {
            System.out.println(e.getLocalizedMessage());
        }
    }
    
    public boolean isAWord(String word)
    {
        word = word.toUpperCase();
        int index=Arrays.binarySearch(words,word);
        return index >= 0;
    }
    
    public boolean containsAWord(String sentence)
    {
        String[] words = sentence.split(wordSeperators);
        for(String word : words)
        {
           if(isAWord(word))
           {
               return true;
           }
        }
        return false;
    }
    public double percentageOfWords(String sentence)
    {
        String[] words = sentence.split(wordSeperators);
        int emptyWords= 0;
        int wordCount=0;
        for(String word : words)
        {
            if(word.isEmpty())
            {
                emptyWords++;
                continue;
            }
            if(isAWord(word))
            {
                wordCount++;
            }
        }
        return (wordCount / (double) (words.length - emptyWords)) * 100.0;
    }
    public boolean isASentence(String sentence)
    {
        return percentageOfWords(sentence) == 100;
    }
    
    public static WordListAccess getInstance() {
        return WordListAccessHolder.INSTANCE;
    }
    
    private static class WordListAccessHolder {

        private static final WordListAccess INSTANCE = new WordListAccess();
    }
}
