/*
ID: xiaole.1
LANG: JAVA
TASK: sprime
 */

import java.util.*;
import java.io.*;
class sprime {
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
    public static void nextPrime(int n, int l){
        if(l == 0) res.add(n);
        for(int i = 0; i < 4; i++){
            if(isPrime(10 * n + d2[i])) nextPrime(10 * n + d2[i], l - 1);
        }
    }
    public static int[] d2 = {1, 3, 7, 9};
    public static ArrayList<Integer> res = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("sprime.out"))));
        BufferedReader f = new BufferedReader(new FileReader(new File("sprime.in")));
        int n = Integer.parseInt(f.readLine());
        int[] d1 = {2, 3, 5, 7};
        for(int i = 0; i < 4; i++){
            nextPrime(d1[i], n - 1);
        }
        for(int i = 0; i < res.size(); i++){
            out.println(res.get(i));
        }
        out.close();
    }
}




