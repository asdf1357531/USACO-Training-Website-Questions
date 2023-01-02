/*
ID: xiaole.1
LANG: JAVA
TASK: milk2
 */

import java.util.*;
import java.io.*;
class milk2 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("milk2.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("milk2.out"))));
        int n = Integer.parseInt(f.readLine());
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            starts[i] = s;
            ends[i] = e;
            int j = i - 1;
            while(j >= 0 && starts[j] > s){
                starts[j] = starts[j] + starts[j + 1];
                starts[j + 1] = starts[j] - starts[j + 1];
                starts[j] = starts[j] - starts[j + 1];
                ends[j] = ends[j] + ends[j + 1];
                ends[j + 1] = ends[j] - ends[j + 1];
                ends[j] = ends[j] - ends[j + 1];
                j--;
            }
        }
        int mIdle = 0;
        int m = 0;
        int s = starts[0];
        int last = ends[0];
        for(int i = 0; i < n; i++){
            mIdle = Math.max(mIdle, starts[i] - last);
            if(i > 0 && last < starts[i]){
                s = starts[i];
            }
            m = Math.max(m, ends[i] - s);
            last = Math.max(last, ends[i]);
        }

        out.println(m + " " + mIdle);
        out.close();
    }
}