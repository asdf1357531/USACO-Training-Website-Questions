/*
ID: xiaole.1
LANG: JAVA
TASK: friday
*/
import java.io.*;
import java.util.*;

class friday {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("friday.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("friday.out"))));
        byte[] m = new byte[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] count = new int[7];
        byte day = 0;
        int year = 1900;
        int n = Integer.parseInt(f.readLine());
        for(int i = year; i < year + n; i++){
            for(int j = 0; j < 12; j++){
                count[day]++;
                if(j == 1 && i % 4 == 0) {
                    if(i % 400 == 0 || i % 100 != 0){
                        day = (byte)((day + 1) % 7);
                    }
                }
                day = (byte)((day + m[j]) % 7);
            }
        }
        out.println(count[0] + " " + count[1] + " " + count[2] + " " + count[3] + " " + count[4] + " " + count[5] + " " + count[6]);
        out.close();
    }
}