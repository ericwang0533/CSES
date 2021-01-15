import java.util.*;
import java.io.*;
public class repetitions {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static String s = in.nextLine();
	public static int ans = 1;
	public static int counter = 1;
	
	public static void main(String[] args) throws IOException{
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == s.charAt(i-1)) {
				counter++;
				continue;
			}
			ans = Math.max(counter, ans);
			counter = 1;
		}
		ans = Math.max(counter, ans);
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
