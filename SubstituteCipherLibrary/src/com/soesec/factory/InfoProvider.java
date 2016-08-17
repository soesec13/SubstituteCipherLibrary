/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soesec.factory;


public class InfoProvider {
    private CipherEnum type;
    private int rightShift;
    private char seperator;
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
        a1z26.seperator = '-';
        return a1z26;
    }

    public CipherEnum getType() {
        return type;
    }

    public int getRightShift() {
        return rightShift;
    }
    public char getSperator()
    {
        return seperator;
    }
    
    
}
