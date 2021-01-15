import java.util.*;
import java.io.*;
public class missingNumber {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static long n = in.nextLong();
	public static long sum = n * (n + 1) / 2;
	
	public static void main(String[] args) throws IOException{
		for(int i = 1; i < n; i++) {
			sum -= in.nextLong();
		}
		System.out.println(sum);
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
			return st.nextToken();
		}
	}
}
