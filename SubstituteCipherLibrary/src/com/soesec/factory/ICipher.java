/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soesec.factory;

/**
 *
 * @author sebi
 */
public interface ICipher {
    
    public ICipher Init(InfoProvider info);
    public String encode(String plain);
    public String decode(String plain);
}
