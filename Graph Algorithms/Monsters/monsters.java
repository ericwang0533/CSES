import java.util.*;
import java.io.*;
public class monsters {
	static void dbg(Object obj) {
		if(testing) {
			System.out.println(obj);
		}
	}
	
	public static boolean testing = true;
	public static FastAF in = new FastAF();
	public static int n, m;
	public static int A;
	public static ArrayList<Integer> monsters;
	public static char[][] mat;
	public static int[] par;
	public static char[] path;
	public static char[] direct = {'D', 'U', 'L', 'R'};
	public static int[] moves;
	public static int[] dx = {1, -1, 0, 0}; // moves x val up/dowm
	public static int[] dy = {0, 0, -1, 1}; // moves y val left/right
	public static int finalx = -1, finaly = -1;
	
	public static void main(String[] args) throws IOException{
		input();
		bfs();
	}
	
	public static void bfs() throws IOException {
		// TODO Auto-generated method stub
		path = new char[n*m];
		par = new int[n*m];
		moves = new int[n*m];
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(A);
		par[A] = A;
		moves[A] = 0;
		while(!q.isEmpty()) {
			int v = q.poll(); int x = v/m; int y = v%m;
			if(x == 0 || x == n-1 || y == 0 || y == m-1) {
				finalx = x; finaly = y;
				break;
			}
			
			for(int i = 0; i < 4; i++) {
				int newx = x + dx[i]; int newy = y + dy[i];
				if(newx < 0 || newx >= n || newy < 0 || newy >= m || par[newx * m + newy] != 0 || mat[newx][newy] != '.') {
					continue;
				}
				q.add(newx * m + newy);
				par[newx * m + newy] = v;
				path[newx * m + newy] = direct[i];
				moves[newx * m + newy] = moves[v]+1;
				dbg(newx + " | " + newy);
			}
			dbg(Arrays.toString(par));
			dbg(Arrays.toString(moves));
		}
		
		dbg(Arrays.toString(par));
		dbg(Arrays.toString(moves));
		
//		int x = A/m; int y = A%m;
//		dbg(x + " | " + y);
//		for(int i = 0; i < 4; i++) {
//			dbg((x + dx[i]) + " | " + (y + dy[i]) + " | " + direct[i]);
//		}
		
		if(finalx != -1 || finaly != -1) {
			StringBuilder finalPath = new StringBuilder();
			int v = finalx * m + finaly;
			while(par[v] != v) {
				finalPath.append(path[v]);
				v = par[v];
			}
//			System.out.println(finalPath);
			
			System.out.println(finalPath.length());
			System.out.println(finalPath.reverse());
		}
	}

	public static void input() throws IOException{
		// TODO Auto-generated method stub
		n = in.nextInt(); m = in.nextInt();
		mat = new char[n][m];
		monsters = new ArrayList<Integer>();
//		dbg(in.nextLine());
//		dbg(in.nextLine());
//		dbg(in.nextLine());
		for(int i = 0; i < n; i++) {
//			break;
			mat[i] = in.nextLine().toCharArray();
//			dbg(Arrays.toString(mat[i]));
			for(int j = 0; j < m; j++) {
//				dbg(mat[i][j]);
				if(mat[i][j] == 'A') {
					A = i * m + j;
				}
				else if(mat[i][j] == 'M') {
					monsters.add(i * m + j);
				}
			}
		}
//		
//		dbg(Arrays.deepToString(mat));
		dbg(A);
		dbg(monsters);
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
			return new String(buf, 0, cnt-1);
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
}
