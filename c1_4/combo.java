/*
ID: xiaole.1
LANG: JAVA
TASK: combo
 */

import java.util.*;
import java.io.*;
class combo {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("combo.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("combo.out"))));
        int n = Integer.parseInt(f.readLine());
        StringTokenizer lock1 = new StringTokenizer(f.readLine());
        int a = Integer.parseInt(lock1.nextToken());
        int b = Integer.parseInt(lock1.nextToken());
        int c = Integer.parseInt(lock1.nextToken());
        StringTokenizer lock2 = new StringTokenizer(f.readLine());
        int x = Integer.parseInt(lock2.nextToken());
        int y = Integer.parseInt(lock2.nextToken());
        int z = Integer.parseInt(lock2.nextToken());
        HashSet<Integer> locks = new HashSet<>();
        for(int i = a - 2; i < a + 3; i++){
            for(int j = b - 2; j < b + 3; j++){
                for(int k = c - 2; k < c + 3; k++){
                    locks.add(((i + n) % n) * 1000000 + ((j + n) % n) * 1000 + ((k + n) % n));
                }
            }
        }

        for(int i = x - 2; i < x + 3; i++){
            for(int j = y - 2; j < y + 3; j++){
                for(int k = z - 2; k < z + 3; k++){
                    locks.add(((i + n) % n) * 1000000 + ((j + n) % n) * 1000 + ((k + n) % n));
                }
            }
        }
        out.println(locks.size());
        out.close();
    }
}