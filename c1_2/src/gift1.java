/*
ID: xiaole.1
LANG: JAVA
TASK: gift1
*/
import java.io.*;
import java.util.*;

class gift1 {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("section1.2/src/gift1.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("section1.2/src/gift1.out")));
        int n = Integer.parseInt(f.readLine());
        HashMap<String, Integer> names = new HashMap<>();
        String[] names2 = new String[n];
        for(int i = 0; i < n; i++){
            String name = f.readLine();
            names.put(name, i);
            names2[i] = name;
        }

        int[] money = new int[n];
        for(int i = 0; i < n; i++){
            String giver = f.readLine();
            StringTokenizer m = new StringTokenizer(f.readLine());
            int gVal = Integer.parseInt(m.nextToken());
            int r = Integer.parseInt(m.nextToken());
            for(int j = 0; j < r; j++){
                money[names.get(f.readLine())] += gVal/r;
                money[names.get(giver)] -= gVal/r;
            }
        }

        for(int i = 0; i < n; i++){
            out.println(names2[i] + " " + money[i]);
        }

        out.close();
    }
}