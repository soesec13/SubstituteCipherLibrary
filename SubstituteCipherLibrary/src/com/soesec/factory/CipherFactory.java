/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soesec.factory;

import com.soesec.ciphers.*;


public class CipherFactory {
    public static ICipher CreateCipher(InfoProvider info)
    {
        switch (info.getType())
        {
            case Atbash:
                return new Atbash().Init(info);
            case A1Z26:
                return new A1Z26().Init(info);
            case Ceaser:
                return new Ceaser().Init(info);
            case Vigenere:
                return new Vigenère().Init(info);
            default:
                return null;
        }
    }
    
}
