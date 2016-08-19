/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.soesec.util;


public class StringUtils {
    public static boolean containsAny(String str, char[] searchChars) {
      if (str == null || str.length() == 0 || searchChars == null || searchChars.length == 0) {
          return false;
      }
      for (int i = 0; i < str.length(); i++) {
          char ch = str.charAt(i);
          for (int j = 0; j < searchChars.length; j++) {
              if (searchChars[j] == ch) {
                  return true;
              }
          }
      }
      return false;
  }
    public static boolean containsAny(String str, String searchChars) {
      if (searchChars == null) {
          return false;
      }
      return containsAny(str, searchChars.toCharArray());
  }
}
