/*
ID: xiaole.1
LANG: JAVA
TASK: skidesign
 */

import java.util.*;
import java.io.*;
class skidesign {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("skidesign.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("skidesign.out"))));
        int n = Integer.parseInt(f.readLine());
        int[] height = new int[101];
        for(int i = 0; i < n; i++){
            height[Integer.parseInt(f.readLine())]++;
        }
        int p = 10_000_000;
        int s = 0;
        for(int i = 0; i < 84; i++){
            for(int j = 0; j < 101; j++){
                if(j < i){
                    s += height[j] * (i - j) * (i - j);
                } else if(j > i + 17){
                    s += height[j] * (j - i - 17) * (j - i - 17);
                }
            }
            p = Math.min(p, s);
            s = 0;
        }
        out.println(p);
        out.close();
    }
}