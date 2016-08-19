/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo;

import com.soesec.factory.CipherFactory;
import com.soesec.factory.ICipher;
import com.soesec.factory.InfoProvider;


public class Demo {

    public static void main(String[] args) {
        InfoProvider p = InfoProvider.ceaserInfo();
        ICipher cipher = CipherFactory.CreateCipher(p);
        String basic = "STAN IS NOT WHAT HE SEEMS";
        Do(cipher,basic);
        
        p = InfoProvider.atbashInfo();
        cipher = CipherFactory.CreateCipher(p);
        basic = "PAPER JAM DIPPER SAYS";
        Do(cipher, basic);
        
        p = InfoProvider.a1z26Info();
        cipher = CipherFactory.CreateCipher(p);
        basic = "VIVAN LOS PATOS DE LA PISCINA.";
        Do(cipher, basic);
        
        p = InfoProvider.vigenéreInfo("WIDDLE");
        cipher = CipherFactory.CreateCipher(p);
        basic = "WELCOME BACK";
        Do(cipher, basic);
    }
    
    public static void Do(ICipher cipher, String basic)
    {
        String encoded = cipher.encode(basic);
        String decode = cipher.decode(encoded);
        System.out.println("Algorithm: "+cipher.getClass());
        System.out.println("Basic: "+basic);
        System.out.println("Encoded: " +encoded);
        System.out.println("Decoded: " +decode);
    }

}
