/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soesec.ciphers;

import com.soesec.factory.ICipher;
import com.soesec.factory.InfoProvider;


public class Vigenère implements ICipher{

    @Override
    public String encode(String plain) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String decode(String plain) {
        throw new UnsupportedOperationException();
    }
    @Override
    public ICipher Init(InfoProvider info) {
        return this;
    }
}
