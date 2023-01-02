/*
ID: xiaole.1
LANG: JAVA
TASK: palsquare
 */

import java.util.*;
import java.io.*;
class palsquare {
    static String convert(String str, int fromBase, int toBase) {
        return Integer.toString(Integer.parseInt(str, fromBase), toBase);
    }
    static boolean isP(String str){
        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("palsquare.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("palsquare.out"))));
        int n = Integer.parseInt(f.readLine());
        for(int i = 1; i < 300; i++){
            if(isP(convert(i * i + "", 10, n))){
                out.println(convert(i + "", 10, n).toUpperCase() + " " + convert(i * i + "", 10, n).toUpperCase());
            }
        }
        out.close();
    }
}