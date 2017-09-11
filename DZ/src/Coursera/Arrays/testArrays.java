package Coursera.Arrays;


import edu.duke.FileResource;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static Coursera.Read.readWords;

public class testArrays {
    public static void main(String[] args) throws IOException {

        WordPlay wp = new WordPlay();
        CaesarCipher cc = new CaesarCipher(15);
        CaesarCiperTwoKeys cctk = new CaesarCiperTwoKeys(21,2);

        CaesarBreaker cb = new CaesarBreaker(14,24);

//       System.out.println( wp.isVowel('A'));
//       System.out.println( wp.replaceVowels("Hello world!",'*'));
//       System.out.println(wp.emphrasize("Mary Bella Abracadabra",'a'));
//       System.out.println(cc.encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!\n" +
//                "\n",15));
//        System.out.println(cc.encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!",
//                8,21));

        WordLengths wl = new WordLengths();


//        cb.decryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko");
//          System.out.println(cc.encryptTwoKeys("Akag tjw Xibhr awoa aoee xakex znxag xwko",4,23));
//
//
//
//          String s3 = readWords("http://www.dukelearntoprogram.com/java/mysteryTwoKeysPractice.txt");
//
//          cb.decrypWithoutTwoKeys(s3);
//
//          System.out.println(cc.encryptTwoKeys(s3,17,4));
//
//
//          System.out.println(cc.encryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx",2,20));
//          FileResource res = new FileResource("C:\\Coursera\\Coursera\\SourceCode\\SmallHamlet.txt");
//

          String s = readWords("http://www.dukelearntoprogram.com/java/mysteryTwoKeysQuiz.txt");
          cb.decrypWithoutTwoKeys(s);

//          File f = new File("C:\\Coursera\\Coursera\\SourceCode\\errors2.txt");
//
//
//          FileWriter writer =new FileWriter(f,true);
//          writer.write(s);
//          writer.close();
//
//
//         FileResource res2 = new FileResource(f);
//
//        System.out.println(wl.indexOfMax(wl.countWordLengths(res2, new int[256])));
//
//        cb.decryptTwoKeys("Hfs cpwewloj loks cd Hoto kyg Cyy.");


//          String s2 = readWords("http://www.dukelearntoprogram.com/java/mysteryTwoKeysQuiz.txt");

//       System.out.println(cc.encrypt("Can you imagine life WITHOUT the internet AND computers in your pocket?"));
//       System.out.println(cctk.encryptTwoKeys("Can you imagine life WITHOUT the internet AND computers in your pocket?"));

    }
}
