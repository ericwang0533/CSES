import java.util.*;
import java.io.*;
public class diceCombinations {
	public static boolean testing = true;
	public static BufferedReader br; public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	
	public static void main(String[] args) throws IOException{
		dbg(n);
		
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
		
		String nextLint() {
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
