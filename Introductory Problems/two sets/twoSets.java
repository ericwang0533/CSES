import java.util.*;
import java.io.*;
public class twoSets {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static long n = in.nextLong();
	public static long target = n * (n+1) / 4;
	public static ArrayList<Long> master = new ArrayList<Long>((int) n);
	public static Queue<obj> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		if(n * (n+1) % 4 != 0) {
			System.out.println("NO");
			System.exit(0);
		}
		for(long i = 1; i <= n; i++) {
			master.add(i);
		}
		ArrayList<Long> arr = new ArrayList<Long>((int) n);
		arr.add((long) 1);
		q.add(new obj(1, arr));
		solve();
		System.out.println("NO");
	}
	
	public static void solve() {
		// TODO Auto-generated method stub
//		System.out.println(sum + " " + last);
//		System.out.println(Arrays.toString(arr.toArray()));
		while(!q.isEmpty()) {
			obj curr = q.poll();
//			System.out.println(curr.sum + " " + Arrays.toString(curr.arr.toArray()));
			if(curr.sum == target) {
//				System.out.println(curr.sum + " " + target);
				System.out.println("YES");
				System.out.println(curr.arr.size());
				System.out.println(Arrays.toString(curr.arr.toArray()).replaceAll("\\[|\\]|,", ""));
				System.out.println(n - curr.arr.size());
				master.removeAll(curr.arr);
				System.out.println(Arrays.toString(master.toArray()).replaceAll("\\[|\\]|,", ""));
				System.exit(0);
			}
			
			for(long i = curr.arr.get(curr.arr.size()-1)+1; i <= n; i++) {
				ArrayList<Long> arr = (ArrayList<Long>) curr.arr.clone();
				arr.add(i);
				q.add(new obj(curr.sum+i, arr));
//				arr.remove(arr.size() - 1);
//				curr.sum -= i;
			}
		}
		
		
	}
	
	static class obj{
		public long sum;
		public ArrayList<Long> arr;
		public obj(long sum, ArrayList<Long> arr) {
			this.sum = sum;
			this.arr = arr;
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
