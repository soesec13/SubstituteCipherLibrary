/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soesec.factory;

import com.soesec.ciphers.*;


public class CipherFactory {
    public static ICipher CreateCipher(CipherEnum type)
    {
        switch (type)
        {
            case Atbash:
                return new Atbash();
            case A1Z26:
                return new A1Z26();
            case Ceaser:
                return new Ceaser();
            case Vigenere:
                return new Vigenère();
            default:
                return null;
        }
    }
}
