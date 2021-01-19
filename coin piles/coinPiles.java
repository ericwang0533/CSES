import java.util.*;
import java.io.*;
public class coinPiles {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
//	public static int[][] mat = new int[n][2];
	
	public static void main(String[] args) throws IOException{
		input();
	}
	
	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
//			mat[i][0] = in.nextInt();
//			mat[i][1] = in.nextInt();
			solve(in.nextInt(), in.nextInt());
		}
		
//		for(int i = 0; i < n; i++) {
//			System.out.println(Arrays.toString(mat[i]));
//		}
	}
	public static void checkEmpty(int a, int b){
		if(a>b)
		{
			int tmp=a;
			a=b;
			b=tmp;
		}
		if(2*a<b)
//			return(false);
			System.out.println("NO");
		else
		{
			a=a%3;b=b%3;
			if((a==0 && b==0)||(a==1 && b==2)||(a==2&&b==1))
//				return(true);
				System.out.println("YES");
			else
//				return(false);
				System.out.println("NO");
		}
	}
	
	public static void solve(int a, int b) {
		// TODO Auto-generated method stub
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		if(max > min * 2) {
			System.out.println("NO");
		}
		else {
			max%=3;
			min%=3;
			if((max == 0 && min == 0) || (max == 1 && min == 2) || (max == 2 && min == 1)) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
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
