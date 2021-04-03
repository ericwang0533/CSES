import java.util.*;
import java.io.*;
public class grayCode {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static int n = in.nextInt();
	public static Deque<StringBuilder> deck = new ArrayDeque<StringBuilder>();
	public static int i, counter = 0;
	
	public static void main(String[] args) throws IOException{
		deck.add(new StringBuilder("0"));
		deck.add(new StringBuilder("1"));
		for(i = 2; i <= n; i++) {
//			recurse();
//			counter = 0;
			ArrayList<StringBuilder> strs = new ArrayList<StringBuilder>((int) Math.pow(2, i-1));
			for(int j = 0; j < (int) Math.pow(2, i-1); j++) {
				StringBuilder curr = deck.pollLast();
				strs.add(new StringBuilder(curr).append("1"));
				deck.addFirst(curr.append("0"));
//				deck.addLast(str);
//				System.out.println(Arrays.toString(deck.toArray()));//.replaceAll("\\[|\\]", "").replace(", ", "\n"));
			}
			
			strs.forEach(o -> deck.addLast(o));
//			System.out.println(Arrays.toString(deck.toArray()));//.replaceAll("\\[|\\]", "").replace(", ", "\n"));
//			System.out.println();
		}
		
		deck.forEach(o -> System.out.println(o.reverse()));
//		System.out.println(Arrays.toString(deck.toArray()).replaceAll("\\[|\\]", "").replace(", ", "\n"));
	}
	
	public static void recurse() {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(deck.toArray()));//.replaceAll("\\[|\\]", "").replace(", ", "\n"));
		if(counter == (int) Math.pow(2, i-1)) {
			return;
		}
		
		counter++;
		StringBuilder curr = deck.pollLast();
		StringBuilder str = new StringBuilder(curr).append("1");
		deck.addFirst(curr.append("0"));
		deck.addLast(str);
		System.out.println(Arrays.toString(deck.toArray()));//.replaceAll("\\[|\\]", "").replace(", ", "\n"));
		recurse();
		
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
