/*
ID: xiaole.1
LANG: JAVA
TASK: milk
 */

import java.util.*;
import java.io.*;
class milk {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("milk.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("milk.out"))));
        StringTokenizer st1 = new StringTokenizer(f.readLine());
        int m = Integer.parseInt(st1.nextToken());
        int n = Integer.parseInt(st1.nextToken());
        int[] prices = new int[n];
        int[] limits = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            prices[i] = p;
            limits[i] = l;
            int j = i - 1;
            while(j >= 0 && prices[j] > p){
                prices[j] = prices[j] + prices[j + 1];
                prices[j + 1] = prices[j] - prices[j + 1];
                prices[j] = prices[j] - prices[j + 1];
                limits[j] = limits[j] + limits[j + 1];
                limits[j + 1] = limits[j] - limits[j + 1];
                limits[j] = limits[j] - limits[j + 1];
                j--;
            }
        }
        int c = 0;
        for(int i = 0; i < n; i++){
            c += prices[i] * Math.min(m, limits[i]);
            m -= Math.min(m, limits[i]);
            if(m <= 0){
                break;
            }
        }
        out.println(c);
        out.close();
    }
}
//test
//
