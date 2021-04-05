import java.util.*;
import java.io.*;
public class roundTrip {
	static void dbg(Object obj) {
		if(testing) {
			System.out.println(obj);
		}
	}
	public static boolean testing = true;
	public static FastAF in = new FastAF();
	public static int n, m;
	public static ArrayList<Integer>[] cities;
	public static boolean[] vis;
	public static ArrayList<Integer> path;
	
	public static void main(String[] args) throws IOException{
		input();
		solve();
	}
	
	public static void solve() {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isCycle(int ind) {
		if(cities[ind].size() == 0) {
			return false;
		}
		
		
		return true;
	}

	public static void input() throws IOException{
		// TODO Auto-generated method stub
		n = in.nextInt(); m = in.nextInt();
		cities = new ArrayList[n+1];
		vis = new boolean[n+1];
		for(int i = 1; i < n+1; i++) {
			cities[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			int a = in.nextInt(), b = in.nextInt();
			cities[a].add(b);
			cities[b].add(a);
		}
		
		dbg(Arrays.toString(cities));
		
		for(int i=1;i<=n;++i) {
			dbg("");
			dbg("i: " + i);
            if(!vis[i]) {
                path = new ArrayList<>();
                if(dfs(i,0)) {
                    int st = path.get(path.size()-1);
                    int ptr = 0;
                    while(path.get(ptr) != st) ++ptr;
                    System.out.println(path.size()-ptr);

                    for(;ptr<path.size();++ptr) System.out.print(path.get(ptr)+" ");
                    return;
                }
            }
        }
        System.out.print("IMPOSSIBLE");
    }
	
	public static boolean dfs(int v, int par) {
		dbg("");
		dbg("(v,p): (" + v + ","+ par + ")");
		dbg(" path: " + path);
		vis[v] = true;
        path.add(v);
        dbg("       " + cities[v]);
        for(int node : cities[v]) {
        	dbg("        " + node);
            if(node == par) continue;
            if(vis[node] && node != v) {
                path.add(node);
                return true; // cycle found
            }
            if(!vis[node] && dfs(node,v)) return true; // cycle found
        }
        path.remove(path.size()-1);
        return false;
	}

	static class FastAF{
		final private int bufferSize = 1 << 16;
		public DataInputStream din;
		public byte[] buffer;
		public int bufferPointer, bytesRead;
		
		public FastAF() {
			din = new DataInputStream(System.in);
			buffer = new byte[bufferSize];
			bufferPointer = bytesRead = 0;
		}
		
		public int nextInt() throws IOException{
			int ret = 0;
			byte c = read();
			while(c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			do {
				ret = ret * 10 + c - '0';
			} while((c = read()) <= '9' && c >= '0');
			
			if(neg) return -ret;
			return ret;
		}
		
		public byte read() throws IOException{
			if(bufferPointer == bytesRead) fillBuffer();
			return buffer[bufferPointer++];
		}
		
		public void fillBuffer() throws IOException{
			bytesRead = din.read(buffer, bufferPointer = 0, bufferSize);
			if(bytesRead == -1) buffer[0] = -1;
		}
	}
}
