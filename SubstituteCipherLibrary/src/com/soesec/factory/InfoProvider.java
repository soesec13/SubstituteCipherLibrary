/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soesec.factory;


public class InfoProvider {
    private CipherEnum type;
    private int rightShift;
    private char letterSeperator;
    private String wordSeperator;
    private String otherCharacters;
    private String key;
    public static InfoProvider ceaserInfo()
    {
        InfoProvider ceaser = new InfoProvider();
        ceaser.rightShift = 3;
        ceaser.type = CipherEnum.Ceaser;
        return ceaser;
    }
    public static InfoProvider atbashInfo()
    {
        InfoProvider atbash = new InfoProvider();
        atbash.type = CipherEnum.Atbash;
        return atbash;
    }
    public static InfoProvider a1z26Info()
    {
        InfoProvider a1z26 = new InfoProvider();
        a1z26.type = CipherEnum.A1Z26;
        a1z26.letterSeperator = '-';
        a1z26.wordSeperator = "[ :\n]";
        a1z26.otherCharacters = "'";
        return a1z26;
    }
    
    public static InfoProvider vigenéreInfo(String key)
    {
        InfoProvider vigenére = new InfoProvider();
        vigenére.type = CipherEnum.Vigenere;
        vigenére.key = key;
        return vigenére;
    }
    
    public CipherEnum getType() {
        return type;
    }

    public int getRightShift() {
        return rightShift;
    }
    public char getLetterSeperator()
    {
        return letterSeperator;
    }

    public String getOtherCharacters() {
        return otherCharacters;
    }

    public String getWordSeperator() {
        return wordSeperator;
    }

    public String getKey() {
        return key;
    }
    
    
}
