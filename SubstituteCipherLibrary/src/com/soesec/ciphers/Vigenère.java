/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soesec.ciphers;

import com.soesec.factory.ICipher;
import com.soesec.factory.InfoProvider;
import com.soesec.util.Alphabet;


public class Vigenère implements ICipher{
    private InfoProvider info;
    @Override
    public String encode(String plain) {
        String res = "";
        plain = plain.toUpperCase();
        String key = info.getKey();
        for(int i = 0,j=0;i<plain.length();i++)
        {
            char letter = plain.charAt(i);
            char keyChar = key.charAt(j);
            
            if(!Character.isAlphabetic(letter))
            {
                res+=letter;
                continue;
            }
            int letterIndex = Alphabet.IndexOf(letter);
            int keyIndex = Alphabet.IndexOf(keyChar);
            res += Alphabet.At((letterIndex+keyIndex)%26);
            j = ++j % key.length();
        }
        return res;
    }

    @Override
    public String decode(String plain) {
        String res = "";
        plain = plain.toUpperCase();
        String key = info.getKey();
        for(int i = 0,j=0;i<plain.length();i++)
        {
            char letter = plain.charAt(i);
            char keyChar = key.charAt(j);
            
            if(!Character.isAlphabetic(letter))
            {
                res+=letter;
                continue;
            }
            int letterIndex = Alphabet.IndexOf(letter);
            int keyIndex = Alphabet.IndexOf(keyChar);
            
            int pos = letterIndex-keyIndex;
            
            res += Alphabet.At((pos+26)%26);
            j = ++j % key.length();
        }
        return res;
    }
    @Override
    public ICipher Init(InfoProvider info) {
        this.info = info;
        return this;
    }
}
