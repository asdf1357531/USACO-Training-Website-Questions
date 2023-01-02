/*
ID: xiaole.1
LANG: JAVA
TASK: milk3
 */

import java.util.*;
import java.io.*;
class milk3 {
    public static void search(int x, int y, int z){
        if(previouslyReachedValues[x][y][z] == 1){
            return;
        }
        previouslyReachedValues[x][y][z] = 1;

        if(x == 0)
            valuesOfC[z] = 1;
        search(x - Math.min(b - y, x), y + Math.min(b - y, x), z);
        search(x + Math.min(a - x, y), y - Math.min(a - x, y), z);
        search(x - Math.min(c - z, x), y, z + Math.min(c - z, x));
        search(x + Math.min(a - x, z), y, z - Math.min(a - x, z));
        search(x, y - Math.min(c - z, y), z + Math.min(c - z, y));
        search(x, y + Math.min(b - y, z), z - Math.min(b - y, z));
    }
    public static byte[][][] previouslyReachedValues = new byte[21][21][21];
    public static byte[] valuesOfC = new byte[21];
    public static int a;
    public static int b;
    public static int c;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("milk3.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("milk3.out"))));
        StringTokenizer st = new StringTokenizer(f.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        search(0, 0, c);
        String result = "";
        for(int i = 0; i < 21; i++){
            if(valuesOfC[i] == 1){
                result += i + " ";
            }
        }
        out.println(result.substring(0, result.length() - 1));
        out.close();
    }
//just a comment
}




