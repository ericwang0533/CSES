import java.util.*;
import java.io.*;
public class twoKnights {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static long n = in.nextInt();
	
	public static void main(String[] args) throws IOException{
		for(long i = 1; i <= n; i++) {
			if(i == 1) {
				System.out.println(0);
				continue;
			}
			else if(i == 2) {
				System.out.println(6);
				continue;
			}
			
			System.out.println(i * i * (i * i - 1) / 2 - (4 * (i-1) * (i-2)));
		}
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
}
