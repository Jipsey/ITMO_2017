package Coursera;
import edu.duke.*;

import java.io.File;

public class Read {

    public static void main(String[] args) {
        readWords("http://www.dukelearntoprogram.com/java/somefile.txt");
    }

    public static String readWords(String s){
            StringBuilder sb = new StringBuilder();
            URLResource res = new URLResource(s);
            for(String word:res.lines()){
                sb.append(word);
                sb.append("\n");

            }
           return sb.toString();
        }
    }
