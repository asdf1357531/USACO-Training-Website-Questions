/*
ID: xiaole.1
LANG: JAVA
TASK: beads
*/
import java.io.*;

class beads {
    public static void main (String [] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader("beads.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
        int n = Integer.parseInt(f.readLine());
        String bead = f.readLine();
        bead += bead;
        int a = 0;
        int b = 0;
        int d = 0;
        for(int i = 0; i < bead.length(); i++){
            if(bead.charAt(i) != 'w' && bead.charAt(i) != bead.charAt(a)){
                b = a;
                while(b > 0){
                    if(bead.charAt(b) == 'w' || bead.charAt(b) == bead.charAt(a)) {
                        b--;
                    } else {
                        break;
                    }
                }
                a = i;
            }
            d = Math.max(d, i - b);
        }
        out.println(Math.min(d, n));
        out.close();
    }
}