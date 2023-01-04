/*
ID: xiaole.1
LANG: JAVA
TASK: castle
 */

import java.util.*;
import java.io.*;
class castle {
    public static void getTile(int x, int y){
        int a = castle[x][y];
        if(a % 2 == 1) paths[x][y][0] = 1;
        if(a/2 == 1 || a/2 == 3 || a/2 == 5 || a/2 == 7) paths[x][y][1] = 1;
        if(a/4 == 1 || a/4 == 3) paths[x][y][2] = 1;
        if(a >= 8) paths[x][y][3] = 1;
        castle[x][y] = 0;
    }
    public static void getRoom(int x, int y, int a){
        castle[x][y] = a;
        for(int i = 0; i < 4; i++){
            if(paths[x][y][i] == 0){
                if(x > 0 && i == 1 && castle[x - 1][y] == 0) getRoom(x - 1, y, a);
                if(y > 0 && i == 0 && castle[x][y - 1] == 0) getRoom(x, y - 1, a);
                if(x + 1 < castle.length && i == 3 && castle[x + 1][y] == 0) getRoom(x + 1, y, a);
                if(y + 1 < castle[x].length && i == 2 && castle[x][y + 1] == 0) getRoom(x, y + 1, a);
            }
        }
    }
    public static byte[][][] paths;
    public static int[][] castle;
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new FileReader(new File("castle.in")));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(new File("castle.out"))));
        StringTokenizer st = new StringTokenizer(f.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        paths = new byte[n][m][4];
        castle = new int[n][m];
        for(int i = 0; i < n; i++){
            StringTokenizer row = new StringTokenizer(f.readLine());
            for(int j = 0; j < m; j++){
                castle[i][j] = Integer.parseInt(row.nextToken());
                getTile(i, j);
            }
        }
        int a = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(castle[i][j] == 0){
                    getRoom(i, j, a);
                    a++;
                }
            }
        }
        int[] size = new int[a];
        int largestRoom = 0;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                size[castle[i][j]]++;
                largestRoom = Math.max(largestRoom, size[castle[i][j]]);
            }
        }
        out.println(a - 1);
        out.println(largestRoom);
        ArrayList<int[]> roomPairs = new ArrayList<>();
        ArrayList<int[]> pairPos = new ArrayList<>();
        ArrayList<Character> dir = new ArrayList<>();
        for(int j = 0; j < m; j++){
            for(int i = n - 1; i >= 0; i--) {
                if (i > 0 && castle[i][j] != castle[i - 1][j]){
                    roomPairs.add(new int[]{castle[i][j], castle[i - 1][j]});
                    pairPos.add(new int[]{i + 1, j + 1});
                    dir.add('N');
                }
                if (j < m - 1 && castle[i][j] != castle[i][j + 1]){
                    roomPairs.add(new int[]{castle[i][j], castle[i][j + 1]});
                    pairPos.add(new int[]{i + 1, j + 1});
                    dir.add('E');
                }
            }
        }
        int lpi = 0;//largestPairIndex
        for(int i = 0; i < roomPairs.size(); i++){
            if(size[roomPairs.get(i)[0]] + size[roomPairs.get(i)[1]] > size[roomPairs.get(lpi)[0]] + size[roomPairs.get(lpi)[1]]){
                lpi = i;
            }
        }
        out.println(size[roomPairs.get(lpi)[0]] + size[roomPairs.get(lpi)[1]]);
        out.println(pairPos.get(lpi)[0] + " " + pairPos.get(lpi)[1] + " " + dir.get(lpi));
        out.close();
    }
}