package Coursera;

public class Part3 {

    public boolean twoOccurances(String searchFor, String searchWhere) {
        int cnt = 0;
        int stringCounter = 0;
        while (cnt <= searchWhere.length()) {
            String temp = searchWhere.toLowerCase().substring(cnt);
            if (temp.startsWith(searchFor.toLowerCase())) {
                stringCounter++;
            }
            cnt++;
        }
        if (stringCounter == 2) return true;
        return false;
    }


    public String lastPart(String searchFor, String searchWhere) {
        int cnt = 0;
        while (cnt <= searchWhere.length()) {
            String temp = searchWhere.substring(cnt);
            if (temp.toLowerCase().startsWith(searchFor.toLowerCase())) {
                return temp;
            }
            cnt++;
        }
        return "";
    }
}
