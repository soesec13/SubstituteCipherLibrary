/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soesec.ciphers;

import com.soesec.factory.ICipher;
import com.soesec.factory.InfoProvider;
import com.soesec.util.Alphabet;


public class A1Z26 implements ICipher{
    private InfoProvider info;
    @Override
    public String encode(String plain) {
        String encrypted = "";
        char[] array = plain.replace(""+info.getSperator(), "").toUpperCase().toCharArray();
        for(int i = 0;i<array.length-1;i++)
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
        String[] words = plain.split(" ");
        for(int i = 0;i<words.length;i++)
        {
            String word = words[i];
            String decoded = decodeWord(word, ""+info.getSperator());
            decrypted += decoded + ((i<words.length-1)?" ":"");
        }
        return decrypted;
    }
    private String decodeWord(String encoded,String seperator)
    {
        String word="";
        for(String letter : encoded.split(seperator))
        {
            try
            {
                word+=Alphabet.At(Integer.parseInt(""+letter)-1);
            }catch(Exception e)
            {
                word += letter;
            }
        }
        return word;
    }

    @Override
    public ICipher Init(InfoProvider info) {
        this.info = info;
        return this;
    }

}
