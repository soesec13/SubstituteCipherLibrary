/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soesec.ciphers;

import com.soesec.factory.ICipher;
import com.soesec.factory.InfoProvider;
import com.soesec.util.Alphabet;


public class Atbash implements ICipher{
    
    @Override
    public String encode(String plain) {
        String encrypted = "";
        for(char letter : plain.toUpperCase().toCharArray())
        {
            int index =Alphabet.IndexOf(letter);
            if(index<0)
            {
                encrypted+=letter;
                continue;
            }
            int i = (26-(index+1))%26;
            encrypted += Alphabet.At(i);
        }
        return encrypted;
    }

    @Override
    public String decode(String plain) {
        return encode(plain);
    }
    
    @Override
    public ICipher Init(InfoProvider info) {
        return this;
    }

}
