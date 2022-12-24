/*
ID: xiaole.1
LANG: JAVA
TASK: ride
*/
import java.io.*;
import java.util.*;

public class ride {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("ride.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("ride.out"))));

        String comet = f.readLine();
        String group = f.readLine();

        int cVal = 1;
        int gVal = 1;

        for(int i = 0; i < comet.length(); i++){
            cVal *= comet.charAt(i) - 64;
        }

        for(int i = 0; i < group.length(); i++){
            gVal *= group.charAt(i) - 64;
        }

        if(cVal % 47 == gVal % 47){
            out.println("GO");
        } else {
            out.println("STAY");
        }

        out.close();
    }
}