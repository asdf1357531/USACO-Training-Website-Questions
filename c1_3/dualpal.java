/*
ID: xiaole.1
LANG: JAVA
TASK: dualpal
 */

import java.util.*;
import java.io.*;
class dualpal {
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
        BufferedReader f = new BufferedReader(new FileReader(new File("dualpal.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("dualpal.out"))));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int c = 0;
        int cc = 0;
        while(c < n){
            s++;
            for(int i = 2; i < 11; i++) {
                if (isP(convert(s + "", 10, i))) {
                    cc++;
                }
            }
            if(cc >= 2){
                out.println(s);
                c++;
            }
            cc = 0;
        }
        out.close();
    }
}