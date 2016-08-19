/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soesec.advanced;

import com.soesec.factory.ICipher;
import com.soesec.factory.InfoProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class MultiCipher implements ICipher{
    private List<ICipher> ciphers;
    private boolean reverse = false;
    public MultiCipher()
    {
        ciphers = new ArrayList<>();
    }
    public MultiCipher(boolean reverse)
    {
        ciphers = new ArrayList<>();
        this.reverse = reverse;
    }
    public MultiCipher(List<ICipher> ciphers)
    {
        this.ciphers = ciphers;
    }
    public MultiCipher(ICipher... args)
    {
        this.ciphers = Arrays.asList(args);
    }
    public MultiCipher(List<ICipher> ciphers,boolean reverse)
    {
        this.ciphers = ciphers;
        this.reverse = reverse;
    }
    @Override
    public ICipher Init(InfoProvider info) {
        return this;
    }

    @Override
    public String encode(String plain) {
        List<ICipher> ciphs = ciphers;
        if(reverse)
        {
            Collections.reverse(ciphs);
        }
        String enciphered = plain;
        for(ICipher cipher : ciphs)
        {
            enciphered = cipher.encode(enciphered);
        }
        return enciphered;
    }

    @Override
    public String decode(String plain) {
        List<ICipher> ciphs = ciphers;
        if(reverse)
        {
            Collections.reverse(ciphs);
        }
        String deciphered = plain;
        for(ICipher cipher : ciphs)
        {
            deciphered = cipher.decode(deciphered);
        }
        return deciphered;
    }
    
    
}
