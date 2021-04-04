import java.util.*;
import java.io.*;
public class messageRoute {
	public static boolean testing = false;
	public static FastAF in = new FastAF();
	public static int n, m;
	public static Node[] computers;
//	public static TreeSet<Node> computers = new TreeSet<Node>(new nodeSort());
	public static ArrayList<Integer> list = new ArrayList<Integer>();
	
	
	public static void main(String[] args) throws IOException{
		input();
		
//		computers[1].visited = true;
		computers[1].cost = 0;
		
//		for(int i = 1; i < n+1; i++) {
//			if(!computers[i].visited) {
//				dijstrka(i);				
//			}
//		}
		
		while(true) {
			int minCost = Integer.MAX_VALUE;
			int minInd = -1;
			int ii = -1;
			for(int i = 0; i < list.size(); i++) {
				if(!computers[list.get(i)].visited && computers[list.get(i)].cost < minCost) {
					minCost = computers[list.get(i)].cost;
					minInd = list.get(i);
					ii = i;
				}
			}
			if(minInd == -1) {
				break;
			}
			dijstrka(minInd);
			list.remove(ii);
		}
		
//		dbg(computers);
		
		if(Math.abs(computers[n].cost) < Integer.MAX_VALUE) {
			System.out.println(computers[n].cost+1);
//			StringBuilder ans = new StringBuilder(String.valueOf(n));
//			System.out.print(n);
//			System.out.print(ans.toString());
			int[] ans = new int[computers[n].cost];
			int j = n;
			for(int i = 0; i < computers[n].cost; i++) {
//				System.out.print(" " + computers[j].path);
				ans[i] = computers[j].path;
				j = computers[j].path;
			}
			
//			dbg(ans);
			
			for(int i = ans.length-1; i >= 0; i--) {
				System.out.print(ans[i] + " ");
			}
			System.out.println(n);
//			System.out.println(ans.reverse());
		}
		else {
			System.out.println("IMPOSSIBLE");
		}
	}
	
	public static void dijstrka(int ind) {
		// TODO Auto-generated method stub
		for(int i = 0; i < computers[ind].connections.size(); i++) {
			Node curr = computers[computers[ind].connections.get(i)];
			if(curr.visited) {
				continue;
			}
			
			if(computers[ind].cost+1 < curr.cost) {
				curr.cost = computers[ind].cost+1;
				curr.path = ind;
			}
//			curr.cost = Math.min(curr.cost, computers[ind].cost + 1);
		}
		
		// need it!!! // or not?
		computers[ind].visited = true;
	}

	public static void input() throws IOException{
		// TODO Auto-generated method stub
		n = in.nextInt(); m = in.nextInt();
		computers = new Node[n+1];
		
		for(int i = 1; i < n+1; i++) {
			computers[i] = new Node(i);
			list.add(i);
		}
		
		for(int i = 0; i < m; i++) {
			int a = in.nextInt(), b = in.nextInt();
			computers[a].connections.add(b);
			computers[b].connections.add(a);
		}
	
//		dbg(computers);
	}
	
	static class Node{
		public int ind;
		public boolean visited;
		public ArrayList<Integer> connections; 
//		public ArrayList<Integer> path; 
		public int path; 
		public int cost;
		
		public Node(int ind) {
			this.ind = ind;
			visited = false;
			connections = new ArrayList<Integer>();
//			path = new ArrayList<Integer>();
			path = -1; //new ArrayList<Integer>();
			cost = Integer.MAX_VALUE;
		}
		
		public String toString() {
			return ind + ": " + visited + " | " + cost + " | " + connections + " | " + path;
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
			if(obj instanceof Object[]) {
				Object[] test = (Object[]) obj;
				for(int i = 0; i < test.length; i++) {
					System.out.println(test[i]);
				}
				return;
			}
			System.out.println(obj);
		}
	}
}
