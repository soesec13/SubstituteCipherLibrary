/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import com.soesec.util.WordListAccess;


public class WordAccessDemo1 {

    public static void main(String[] args) {
        WordListAccess access = WordListAccess.getInstance();
        String word = "hello";
        System.out.println("Word: "+word);
        if(access.isAWord(word))
        {
            System.out.println("Is a word");
        }
        else
        {
            System.out.println("Not a word");
        }
        String notWord = "asdfadsfasdf";
        System.out.println("Word: "+notWord);
        if(access.isAWord(notWord))
        {
            System.out.println("Is a word");
        }
        else
        {
            System.out.println("Not a word");
        }
        String sentence = "Hello dear World! I love you";
        System.out.println("Sentence: "+sentence);
        if(access.isASentence(sentence))
        {
            System.out.println("Is a sentence");
        }
        else
        {
            System.out.println("Is not a sentence");
        }
        
        String partlySentence = "Hello dear World! I aslödkf you";
        System.out.format("Sentence: %s\n is to %.2f%s a sentence", partlySentence,access.percentageOfWords(partlySentence),'%');
        
        
    }

}
