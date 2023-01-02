/*
ID: xiaole.1
LANG: JAVA
TASK: barn1
 */

import java.util.*;
import java.io.*;
class barn1 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("barn1.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("barn1.out"))));
        StringTokenizer st1 = new StringTokenizer(f.readLine());
        int m = Integer.parseInt(st1.nextToken());
        int s = Integer.parseInt(st1.nextToken());
        int c = Integer.parseInt(st1.nextToken());
        if(m >= c){
            out.println(c);
            out.close();
            return;
        }
        ArrayList<Integer> stalls = new ArrayList<>();
        ArrayList<Integer> gaps = new ArrayList<>();
        int count = s;
        int p = 0;
        for(int i = 0; i < c; i++){
            int t = Integer.parseInt(f.readLine());
            stalls.add(t);
            p = t;
        }
        Collections.sort(stalls);
        count = stalls.get(stalls.size() - 1) - stalls.get(0) + 1;
        for(int i = 1; i < stalls.size(); i++){
            gaps.add(stalls.get(i) - stalls.get(i - 1) - 1);
        }
        Collections.sort(gaps);
        for(int i = gaps.size() - 1; i > Math.max(gaps.size() - m, 0); i--){
            count -= gaps.get(i);
        }
        out.println(count);
        out.close();
    }
}