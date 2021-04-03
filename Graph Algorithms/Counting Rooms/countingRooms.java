import java.util.*;
import java.io.*;
public class countingRooms {
	public static boolean testing = false;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt(), m = in.nextInt();
	public static char[][] mat = new char[n][m];
	public static int rooms = 0;
	
	public static void main(String[] args) throws IOException{
		input();
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(mat[i][j] == '.') {
					ff(i, j);					
					rooms++;
				}
			}
		}
		
		System.out.println(rooms);
	}
	
	public static void ff(int l, int r) {
		// TODO Auto-generated method stub
		if(mat[l][r] != '.') {
			return;
		}
		
		mat[l][r] = '?';
		if(l-1 >= 0) {
			ff(l-1, r);
		}
		if(l+1 < n) {
			ff(l+1, r);
		}
		if(r-1 >= 0) {
			ff(l, r-1);
		}
		if(r+1 < m) {
			ff(l, r+1);
		}
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			mat[i] = in.nextLine().toCharArray();
		}
		
//		dbg(Arrays.deepToString(mat));
	}

	static class FastReader{
		public FastReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				}
				catch(IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
	
	static void dbg(Object obj) {
		if(testing) {
			System.out.println(obj);
		}
	}
}
