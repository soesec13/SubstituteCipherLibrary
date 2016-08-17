/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soesec.util;

import java.util.List;
import java.util.stream.Collectors;


public class Alphabet {
    private static List<Character> alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".chars().mapToObj(e->(char)e).collect(Collectors.toList());
    public static char At(int index)
    {
        return alphabet.get(index);
    }
    public static int IndexOf(char c)
    {
        return alphabet.indexOf(c);
    }
    
}
