/*
ID: xiaole.1
LANG: JAVA
TASK: ariprog
 */

import java.util.*;
import java.io.*;
class ariprog {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("ariprog.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("ariprog.out"))));
        int n = Integer.parseInt(f.readLine());
        int m = Integer.parseInt(f.readLine());
        boolean noPrint = true;
        byte[] bisquares = new byte[2 * m * m + 1];
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= m; j++){
                bisquares[i * i + j * j] = 1;
            }
        }
        for(int b = 1; b < (2 * m * m + 1)/(n - 1) + 1; b++){
            Outer:
            for(int a = 0; a < 2 * m * m + 1 - b * (n - 1); a++){
                for(int i = 0; i < n; i++){
                    if(bisquares[a + i * b] == 0)
                        continue Outer;
                }
                noPrint = false;
                out.println(a + " " + b);
            }
        }
        if(noPrint)
            out.println("NONE");
        out.close();
    }
}