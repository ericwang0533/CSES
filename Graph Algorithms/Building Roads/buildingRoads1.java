import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author prem_cse
 */
public class buildingRoads1 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader in = new FastReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        BuildingRoads solver = new BuildingRoads();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class BuildingRoads {
        public void solve(int testNumber, FastReader sc, PrintWriter out) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            BuildingRoads.DSU dsu = new BuildingRoads.DSU(n + 1);
            for (int i = 0; i < m; ++i) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                dsu.unite(u, v);
            }
            TreeSet<Integer> set = new TreeSet<>();
            for (int i = 1; i < dsu.n; ++i) set.add(dsu.findRoot(i));
            out.println(set.size() - 1);
            if (set.size() > 1) {
                int node = set.first();
                set.remove(node);
                for (int x : set) {
                    out.println(node + " " + x);
                    node = x;
                }
            }
 
        }
 
        static class DSU {
            int n;
            int[] parent;
            int[] size;
 
            public DSU(int v) {
                n = v;
                parent = new int[n];
                size = new int[n];
                for (int i = 0; i < n; i++) {
                    parent[i] = i;
                    size[i] = 1;
                }
            }
 
            public int findRoot(int curr) {
                if (curr == parent[curr]) return curr;
                return parent[curr] = findRoot(parent[curr]);
            }
 
            public boolean unite(int a, int b) {
                int rootA = findRoot(a);
                int rootB = findRoot(b);
                if (rootA == rootB) return true;
                if (size[rootA] > size[rootB]) {
                    parent[rootB] = rootA;
                    size[rootA] += size[rootB];
                } else {
                    parent[rootA] = rootB;
                    size[rootB] += size[rootA];
                }
                return false;
            }
 
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