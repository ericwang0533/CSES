import java.util.*;
import java.io.*;
public class buildingTeams {
	static void dbg(Object obj) {
		if(testing) {
			System.out.println(obj);
		}
	}
	public static boolean testing = false;
	public static FastAF in = new FastAF();
	public static int n, m;
	public static ArrayList<Integer>[] edges;
	public static int[] teams;
	
	public static void main(String[] args) throws IOException{
		input();
		solve();
		
//		System.out.println(1 ^ 1);
//		System.out.println(0 ^ 1);
//		System.out.println(2 ^ 1);
//		System.out.println(3 ^ 1);
		
		for(int i = 1; i < teams.length; i++) {
			System.out.print(((teams[i] == -1) ? 2 : 1) + " ");
		}
	}
	
	public static void solve() {
		// TODO Auto-generated method stub
		Queue<Integer> q = new LinkedList<Integer>();		
		teams[1] = 1;
		q.add(1);
		for(int i = 2; i < n+1; i++) {
			while(!q.isEmpty()) {
				int v = q.poll();
//				int team = teams[v];
				if(teams[v] == 0) {
					teams[v] = 1;
				}
				for(int x : edges[v]) {
					if(teams[x] == teams[v]) {
						System.out.println("IMPOSSIBLE");
						System.exit(0);
					}
					
					if(teams[x] == 0) {
						teams[x] = -teams[v];
						q.add(x);
					}
				}
			}
			if(teams[i] == 0) {
				q.add(i);
			}
//			dbg(i + ": " + Arrays.toString(teams));
		}		
	}

	public static void input() throws IOException{
		// TODO Auto-generated method stub
		n = in.nextInt(); m = in.nextInt();
//		dbg(n);
//		dbg(m);
		teams = new int[n+1];
		edges = new ArrayList[n+1];
		for(int i = 1; i < n+1; i++) {
			edges[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			int a = in.nextInt(), b = in.nextInt();
			edges[a].add(b);
			edges[b].add(a);
		}
		
//		dbg(Arrays.toString(edges));
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
