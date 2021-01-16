import java.util.*;
import java.io.*;
public class numberSpiral {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static Queue<int[]> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		input();
		
		Iterator itr = q.iterator();
		while(itr.hasNext()) {
//			System.out.println(Arrays.toString((int[]) itr.next()));
			solve((int[]) itr.next());
		}
	}
	
	public static void solve(int[] next) {
		// TODO Auto-generated method stub
		int row = next[0];
		int col = next[1];
		System.out.println(row + " : " + col);
		int ans;
		
		if(row == 1) {
			ans = 1;
		}
		else if(row % 2 == 1) {
			ans = 1 + (8 * (row/2 - 1)) + (4 * (row/2));
		}
		else {
			ans = 1 + (8 * (row/2 -1)) + (3 * (row/2)) + (row/2 - 1);
		}
		
		if(col <= row) {
			if(row % 2 == 1) {
				ans += col - 1;
			}
			else {
				ans -= col - 1;
			}
		}
		else {
			int colHead;
			if(col == 2) {
				colHead = 2;
			}
			else if(col % 2 == 1) {
				colHead = 2 + (8 * (col/2 - 1)) + (7 * (col/2)) + (col/2 - 1);
			}
			else {
				colHead = 2 + (8 * (col/2 - 2)) + (7 * (col/2 - 1)) + (col/2 - 1);
			}
//			System.out.println(colHead);
		}
		
		System.out.println(ans);
	}

	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < n; i++) {
			int arr[] = {in.nextInt(), in.nextInt()};
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
