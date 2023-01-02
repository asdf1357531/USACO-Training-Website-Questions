/*
ID: xiaole.1
LANG: JAVA
TASK: crypt1
 */

import java.util.*;
import java.io.*;
class crypt1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("crypt1.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("crypt1.out"))));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer st = new StringTokenizer(f.readLine());
        int[] nums = new int[n];
        int[] ns = new int[10];
        for(int i = 0; i < n; i++){
            nums[i] = Integer.parseInt(st.nextToken());
            ns[nums[i]] = 1;
        }
        Arrays.sort(nums);
        int count = 0;
        for(int a = 0; a < n; a++){
            if(nums[a] == 0) continue;
            for(int b = 0; b < n; b++){
                for(int c = 0; c < n; c++){
                    for(int d = 0; d < n; d++){
                        if(nums[d] == 0) continue;
                        for(int e = 0; e < n; e++){
                            int i = (nums[a] * 100 + nums[b] * 10 + nums[c]) * nums[d];
                            int j = (nums[a] * 100 + nums[b] * 10 + nums[c]) * nums[e];
                            int k = i * 10 + j;
                            if(i < 1000 && j < 1000 && k < 10000){
                                if(ns[i/100] == 1 && ns[i/10 % 10] == 1 && ns[i % 10] == 1 && ns[j/100] == 1 && ns[j/10 % 10] == 1 && ns[j % 10] == 1){
                                    if(ns[k/1000] == 1 && ns[k/100 % 10] == 1 && ns[k/10 % 10] == 1 && ns[k % 10] == 1)count++;
                                }
                            }
                        }
                    }
                }
            }
        }
        out.println(count);
        out.close();
    }
}