import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author prem_cse
 */
public class labyrinth {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        Labyrinth solver = new Labyrinth();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class Labyrinth {
        public void solve(int testNumber, FastReader sc, PrintWriter out) {
 
            int n = sc.nextInt();
            int m = sc.nextInt();
            // apparently this is possible :|
            char[][] s = new char[n][];
            // src is A pt, des is B pt (compressed into 1d)
            int src = 0, des = 0;
 
            for (int i = 0; i < n; ++i) {
                s[i] = sc.next().toCharArray();
                for (int j = 0; j < s[i].length; ++j) {
                    if (s[i][j] == 'A') {
                        src = i * m + j; // compress to 1d
//                        System.out.println("A: " + i + " | " + m + " | " + j);
                    } else if (s[i][j] == 'B') {
                        des = i * m + j; // compress to 1d
//                        System.out.println("B: " + i + " | " + m + " | " + j);
                    }
                }
            }
            
//            System.out.println(Arrays.deepToString(s));
            System.out.println("src A: " + src);
            System.out.println("des B: " + des);
            
            int[] par = new int[n * m]; // par = parents (traks parents)
            char[] dir = new char[n * m]; // tracks directions
            Queue<Integer> q = new ArrayDeque<>();
            Arrays.fill(par, -1); // used to track visited or not (if its not -1 its been visited)
            par[src] = src;
            q.add(src); // start at A
            int[] dx = {0, 0, -1, 1};
            int[] dy = {1, -1, 0, 0};
            char[] c = {'R', 'L', 'U', 'D'};
            while (q.size() > 0) {
                int v = q.poll();
                if (v == des) break; // when you reach B
                int i = v / m; // decompress to 2d
                int j = v % m; // decompress to 2d
                
//                System.out.println(q);
                System.out.println();
                System.out.println("v: " + v + ": (" + i + "," + j + ")");
                
                for (int k = 0; k < 4; ++k) {
                    int x = i + dx[k];
                    int y = j + dy[k];
                    if (x < 0 || y < 0 || x >= n || y >= m || par[x * m + y] != -1 || s[x][y] == '#') continue;
                    q.add(x * m + y);
                    par[x * m + y] = v;
                    dir[x * m + y] = c[k];
                    System.out.println("x: " + x + " | y: " + y);
                    for(int a = 0; a < par.length; a++) {
                    	System.out.println(a + ": " + par[a] + " | " + dir[a]);
                    }
                    System.out.println();
                }
            }
 
            if (par[des] == -1) out.println("NO");
            else {
                out.println("YES");
                StringBuilder path = new StringBuilder();
                int node = des;
                while (par[node] != node) { // the only time this is true is at par[src] b/c we set par[src] = src earlier
                    path.append(dir[node]);
                    node = par[node];
                }
                path.reverse();
                out.println(path.length());
                out.println(path);
            }
            out.close();
 
        }
 
    }
 
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader(InputStream stream) {
            br = new BufferedReader(new
                    InputStreamReader(stream), 32768);
        }
 
        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
    }
}