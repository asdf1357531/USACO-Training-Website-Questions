/*
ID: xiaole.1
LANG: JAVA
TASK: namenum
 */

import java.util.*;
import java.io.*;
class namenum {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("namenum.in")));
        BufferedReader d = new BufferedReader(new FileReader(new File("dict.txt")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("namenum.out"))));
        String n1 = f.readLine();
        int[] n = new int[n1.length()];
        for(int i = 0; i < n1.length(); i++){
            n[i] = Integer.parseInt(n1.charAt(i) + "");
        }
        char[] chars = {2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 9, 9, 9, 1};
        boolean noprint = true;
        Outer:
        for(int i = 0; i < 4617; i++){
            String name = d.readLine();
            if(name.length() != n.length){
                continue Outer;
            }
            for(int j = 0; j < n.length; j++){
                if(chars[name.charAt(j) - 65] != n[j]){
                    continue Outer;
                }
            }
            out.println(name);
            noprint = false;
        }
        if(noprint){
            out.println("NONE");
        }
        out.close();
    }
}