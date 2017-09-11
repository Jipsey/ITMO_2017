package Coursera;

import java.io.File;

public class Test {

    public static void main(String[] args) {

        File f = new File("C:\\Users\\Екатерина\\Pictures\\Фото\\IMG_9165.JPG");

        System.out.println("name:"+f.getAbsolutePath());
    }
}
