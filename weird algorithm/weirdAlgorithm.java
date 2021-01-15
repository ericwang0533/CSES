import java.util.*;
import java.io.*;
public class weirdAlgorithm {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static long n = in.nextLong();
	
	public static void main(String[] args) throws IOException{
		System.out.print(n + " ");
		while(n != 1) {
			if(n%2 == 1) {
				n *= 3;
				n++;
			}
			else {
				n/=2;
			}
			System.out.print(n + " ");
			
			if(n == 0) {
				break;
			}
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
