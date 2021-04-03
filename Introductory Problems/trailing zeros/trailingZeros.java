import java.util.*;
import java.io.*;
import java.math.BigInteger;
public class trailingZeros {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static long n = in.nextLong();
//	public static BigInteger big = BigInteger.valueOf((long) 1);
	
	public static void main(String[] args) throws IOException{
		
		int count = 0;
	    for (int i = 5; n / i >= 1; i *= 5) {
	    	count += n / i; 
	    	System.out.println(count);
	    }
	        

	    System.out.println(count); 
		
//		if(n == 1) {
//			System.out.println(0);
//			System.exit(0);
//		}
//		
//		for(long i = n-(n%5); i >=1; i-=5) {
//			big = big.multiply(BigInteger.valueOf(i));
//		}
		
		
//		for(long i = n-1; i > 1; i--) {
//			big = big.multiply(BigInteger.valueOf(i));
//		}
//		
//		String str = big.toString();
//		String[] arr = str.split("[1-9]");
//		System.out.println(arr[arr.length-1].length());
//		
//		System.out.println(big);
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
