/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CipherDemo;

import com.soesec.factory.CipherFactory;
import com.soesec.factory.ICipher;
import com.soesec.factory.InfoProvider;


public class Demo2 {

    public static void main(String[] args) {
        ICipher a1z26 = CipherFactory.CreateCipher(InfoProvider.a1z26Info());
        ICipher ceaser = CipherFactory.CreateCipher(InfoProvider.ceaserInfo());
        String encoding = ceaser.encode("twelve");
        System.out.println(encoding);
        System.out.println(a1z26.encode(encoding));
    }

}
