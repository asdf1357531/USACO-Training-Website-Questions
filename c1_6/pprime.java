/*
ID: xiaole.1
LANG: JAVA
TASK: pprime
 */

import java.util.*;
import java.io.*;
class pprime {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n) + 1; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static String reverse(String s){
        String nstr="";
        char ch;
        for (int i = 0; i < s.length(); i++) {
            ch= s.charAt(i);
            nstr= ch + nstr;
        }
        return nstr;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("pprime.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("pprime.out"))));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if(a <= 5 && b >= 5) out.println(5);
        if(a <= 7 && b >= 7) out.println(7);
        if(a <= 11 && b >= 11) out.println(11);
        int i = 1;
        int n = 101;
        Outer:
        while(true){
            for(int j = 0; j < 10; j++){
                n = Integer.parseInt("" + i + j + reverse(i + ""));
                if(n > b) break Outer;
                if(n >= a && isPrime(n)) out.println(n);
            }
            i++;
        }
        out.close();
    }
}




