/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soesec.ciphers;

import com.soesec.factory.ICipher;
import com.soesec.factory.InfoProvider;
import com.soesec.util.Alphabet;
import com.soesec.util.StringUtils;


public class A1Z26 implements ICipher{
    private InfoProvider info;
    @Override
    public String encode(String plain) {
        String encrypted = "";
        char[] array = plain.replace(""+info.getLetterSeperator(), "").toUpperCase().toCharArray();
        for(int i = 0;i<array.length;i++)
        {
            char letter = array[i];
            int index = Alphabet.IndexOf(letter);
            if(index<0)
            {
                encrypted += letter;
                continue;
            }
            encrypted += (Alphabet.IndexOf(letter)+1) + 
                    ((i<array.length-2 && Character.isLetter(array[i+1])) ? "-":"");
        }
        return encrypted;
    }

    @Override
    public String decode(String plain) {
        String decrypted = "";
        String[] words = plain.split(info.getWordSeperator());
        for(int i = 0;i<words.length;i++)
        {
            String word = words[i];
            String decoded = decodeWord(word, ""+info.getLetterSeperator(), info.getOtherCharacters());
            decrypted += decoded + ((i<words.length-1)?" ":"");
        }
        return decrypted;
    }
    private static String decodeWord(String encoded,String letterSperator, String otherChars)
    {
        String word="";
        for(String letter : encoded.split(letterSperator))
        {
            if(StringUtils.containsAny(letter, otherChars))
            {
                String currentLetter="";
                for(char c : letter.toCharArray())
                {
                    if(Character.isDigit(c))
                    {
                        currentLetter += c;
                    }
                    else
                    {
                        word += TryGetLetterAt(currentLetter);
                        word += c;
                        currentLetter = "";
                    }
                }
                if(!currentLetter.isEmpty())
                {
                    word += Character.isDigit(currentLetter.charAt(0))?TryGetLetterAt(currentLetter):currentLetter;
                }
                continue;
            }
            word += TryGetLetterAt(letter);
        }
        return word;
    }

    private static String TryGetLetterAt(String pos) {
        try {
            return "" + Alphabet.At(Integer.parseInt("" + pos) - 1);
        } catch (Exception e) {
            return pos;
        }
    }

    @Override
    public ICipher Init(InfoProvider info) {
        this.info = info;
        return this;
    }

}
