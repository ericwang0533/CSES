import java.util.*;
import java.io.*;
public class numberSpiral3 {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static Queue<long[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		input();
		
		Iterator itr = q.iterator();
		while(itr.hasNext()) {
//			System.out.println(Arrays.toString((int[]) itr.next()));
			solve((long[]) itr.next());
		}
	}
	
	public static void solve(long[] next) {
		// TODO Auto-generated method stub
		long output;
		long x = next[0];
		long y = next[1];
		if (x > y) {
			if (x % 2 == 1)
				output = x * x - y + 1;
			else
				output = (x - 1) * (x - 1) + y;
		} else {
			if (y % 2 == 0)
				output = y * y - x + 1;
			else
				output = (y - 1) * (y - 1) + x;
		}
		System.out.println(output);
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			long arr[] = {in.nextLong(), in.nextLong()};
			q.add(arr);
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
