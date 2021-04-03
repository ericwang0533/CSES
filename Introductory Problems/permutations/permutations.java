import java.util.*;
import java.io.*;
public class permutations {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static StringBuffer ans = new StringBuffer();
	
	public static void main(String[] args) throws IOException{
		if(n == 1) {
			System.out.println(1);
			System.exit(0);
		}
		if(n <= 3) {
			System.out.println("NO SOLUTION");
			System.exit(0);
		}
		
		int temp = 2;
		while(temp <= n) {
			ans.append(temp);
			ans.append(" ");
			temp += 2;
		}
		
		temp = 1;
		while(temp <= n) {
			ans.append(temp);
			ans.append(" ");
			temp += 2;
		}
		
		System.out.println(ans);
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
