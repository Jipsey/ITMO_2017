package Coursera;

import edu.duke.URLResource;

public class Part4 {

    public void findURL(String s) {

        URLResource urlResource = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
        String quatation = "\"";
        for (String line :
                urlResource.lines()) {
            String tempLine = line.toLowerCase();
            if (tempLine.contains(quatation)) {
                while (line.contains(quatation)) {
                    line = line.substring(line.indexOf(quatation) + 1, line.lastIndexOf(quatation));

                   if (!line.toLowerCase().contains(quatation) && line.toLowerCase().contains(s.toLowerCase())){
                       System.out.println(line);
                       break;
                   }
                }
            }
        }
    }
}
