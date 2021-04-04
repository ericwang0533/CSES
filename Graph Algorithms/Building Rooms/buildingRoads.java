import java.util.*;
import java.io.*;
public class buildingRoads{
	public static FastAF in = new FastAF();		
	public static int n, m;
	public static node[] cities;
	public static boolean[] visited;
	public static ArrayList<Integer> newRoads = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException{
		input();
		
		dfs(1);
		for(int i = 2; i <= n; i++) {
			if(!visited[i]) {
				newRoads.add(i);
				visited[i] = true;
				dfs(i);
			}
			
		}
		
		System.out.println(newRoads.size());
		newRoads.forEach(o -> System.out.println("1 " + o));
	}
	
	public static void dfs(int ind) {
		// TODO Auto-generated method stub
		for(int i = 0; i < cities[ind].roads.size(); i++) {
			if(visited[cities[ind].roads.get(i)]) {
				continue;
			}
			
			visited[cities[ind].roads.get(i)] = true;
			dfs(cities[ind].roads.get(i));
		}
	}


	public static void input() throws IOException{
		// TODO Auto-generated method stub
		n = in.nextInt(); m = in.nextInt();
		cities = new node[n+1];
		visited = new boolean[n+1];
		visited[1] = true;
		
		for(int i = 1; i <= n; i++) {
			cities[i] = new node(i);
		}
		
		for(int i = 0; i < m; i++) {
			int a = in.nextInt(), b = in.nextInt();
			cities[a].roads.add(b);
			cities[b].roads.add(a);
		}
	}

	static class node{
		public int ind;
		public ArrayList<Integer> roads;
		
		public node(int ind) {
			this.ind = ind;
			roads = new ArrayList<Integer>();
		}
		
		public String toString() {
			return ind + ": " + roads;
		}
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
		
		public String nextLine() throws IOException{
			byte[] buf = new byte[64];
			int cnt = 0, c;
			while((c = read()) != -1) {
				if(c == '\n') {
					if(cnt != 0) {
						break;
					}
					else {
						continue;
					}
				}
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}
		
		public int nextInt() throws IOException{
			int ret = 0;
			byte c = read();
			while(c <= ' ') {
				c = read();
			}
			boolean neg = (c == '-');
			if(neg) c= read();
			do {
				ret = ret * 10 + c - '0';
			} while((c = read()) >= '0' && c <= '9');
			
			if(neg) return -ret;
			return ret;
		}
		
		public double nextDouble() throws IOException{
			double ret = 0, div = 1;
			byte c = read();
			while(c <= ' ') c = read();
			boolean neg = (c == '-');
			if(neg) c = read();
			do {
				ret = ret * 10 + c - '0';
			} while((c = read()) >= '0' && c <= '9');
			
			if(c == '.') {
				while((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}
			
			if(neg) return -ret;
			return ret;
		}
		
		public long nextLong() throws IOException{
			long ret = 0;
			byte c = read();
			while(c <= ' ') c = read();
			boolean neg = ( c == '-');
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
		
		public void close() throws IOException{
			if(din == null) return;
			din.close();
		}
	}
}
