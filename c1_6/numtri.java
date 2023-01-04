/*
ID: xiaole.1
LANG: JAVA
TASK: numtri
 */

import java.util.*;
import java.io.*;
class numtri {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("numtri.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("numtri.out"))));
        int n = Integer.parseInt(f.readLine());
        int[][] tri = new int[n][];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            tri[i] = new int[i + 1];
            for(int j = 0; j <= i; j++){
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = n - 1; i > 0; i--){
            for(int j = 0; j < i; j++){
                tri[i - 1][j] += Math.max(tri[i][j], tri[i][j + 1]);
            }
        }
        out.println(tri[0][0]);
        out.close();
    }
}




