/*
ID: xiaole.1
LANG: JAVA
TASK: transform
 */

import java.util.*;
import java.io.*;
class transform {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("transform.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("transform.out"))));
        int n = Integer.parseInt(f.readLine());
        char[][] s = new char[n][];
        char[][] e = new char[n][];
        for(int i = 0; i < n; i++){
            s[i] = f.readLine().toCharArray();
        }
        for(int i = 0; i < n; i++){
            e[i] = f.readLine().toCharArray();
        }
        boolean[] p = new boolean[7];
        Arrays.fill(p, true);
        boolean c1 = true;
        boolean c2 = true;
        boolean c3 = true;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(p[0] && e[j][n - i - 1] != s[i][j]){
                    p[0] = false;
                }
                if(p[1] && e[n - i - 1][n - j - 1] != s[i][j]){
                    p[1] = false;
                }
                if(p[2] && e[n - j - 1][i] != s[i][j]){
                    p[2] = false;
                }
                if(p[3] && e[n - i - 1][j] != s[i][j]){
                    p[3] = false;
                }
                if(p[4]){
                    if(c1 && e[j][i] != s[i][j]){
                        c1 = false;
                    }
                    if(c2 && e[n - i - 1][j] != s[i][j]){
                            c2 = false;
                    }
                    if(c3 && e[n - j - 1][n - i - 1] != s[i][j]){
                        c3 = false;
                    }
                    if(!c1 && !c2 && !c3){
                        p[4] = false;
                    }
                }
                if(p[5]){
                    if(e[i][j] != s[i][j]){
                        p[5] = false;
                    }
                }
            }
        }
        for(int i = 0; i < 7; i++){
            if(p[i]){
                out.println(i + 1);
                out.close();
                return;
            }
        }
    }
}
