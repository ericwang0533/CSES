import java.util.*;
import java.io.*;
public class messageRoute1 {
	public static boolean testing = true;
	public static FastAF in = new FastAF();
	public static int n, m;
	public static int[] par;
	public static ArrayList<Integer>[] connections;
	
	public static void main(String[] args) throws IOException{
		input();
		solve();
	}
	
	public static void solve() {
		// TODO Auto-generated method stub
//		System.exit(0);
		
		Queue<Integer> q = new LinkedList<Integer>();
		par[1] = 1;
		q.add(1);

		while(!q.isEmpty()) {
//			dbg(q);
			int v = q.poll();
//			for(int i = 0; i < connections[v].size(); i++) {
//				if(par[connections[v].get(i)] == 0) {
//					q.add(connections[v].get(i));
//					par[connections[v].get(i)] = v;					
//				}
//			}
			
			for(int x : connections[v]) {
				if(par[x] == 0) {
					q.add(x);
					par[x] = v;
				}
			}
		}
		
//		dbg(Arrays.toString(par));
		
		if(par[n] == 0) {
			System.out.println("IMPOSSIBLE");
		}
		else {
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(n);
			int v = par[n];
			while(v != 1) {
				path.add(v);
				v = par[v];
			}
			path.add(1);
			
//			dbg(path);
			System.out.println(path.size());
			Collections.reverse(path);
			path.forEach(o -> System.out.print(o + " "));
		}
	}

	public static void input() throws IOException {
		// TODO Auto-generated method stub
		n = in.nextInt(); m = in.nextInt();
		par = new int[n+1];
		connections = new ArrayList[n+1];
		for(int i = 1; i < n+1; i++) {
			connections[i] = new ArrayList<Integer>();
		}
		
		for(int j = 0; j < m; j++) {
			int a = in.nextInt(), b = in.nextInt();
			connections[a].add(b);
			connections[b].add(a);
		}
//		dbg(Arrays.toString(connections));
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
			if(neg) c = read();
			do {
				ret = ret * 10 + c - '0';
			} while((c = read()) >= '0' && c <= '9');
			
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
	
	static void dbg(Object obj) {
		if(testing) {
			System.out.println(obj);
		}
	}
}
