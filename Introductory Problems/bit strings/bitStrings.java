import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class bitStrings {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	
	public static void main(String[] args) throws IOException{
//		System.out.println((long) Math.pow(2, n) % ((long) Math.pow(10, 9) + 7));
//		System.out.println((long) Math.pow(2, n));
		BigInteger pow = new BigInteger("2").pow(n);
		BigInteger mod = pow.mod(new BigInteger("1000000007"));
		System.out.println(mod);
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
