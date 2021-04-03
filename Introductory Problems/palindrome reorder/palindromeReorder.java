import java.util.*;
import java.io.*;
public class palindromeReorder {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
	public static String s = in.nextLine();
	public static int sLen = s.length();
	public static int[] count = new int[26];
	public static ArrayDeque<Character> deck = new ArrayDeque<>();
	public static Queue<Integer> q = new LinkedList<>();
	public static StringBuffer ans = new StringBuffer();
	
	public static void main(String[] args) throws IOException{
		input();
		odd();
		deck();
		ans();
	}
	
	
	public static void ans() {
		// TODO Auto-generated method stub
		deck.forEach((n) -> ans.append(n));
		System.out.println(ans);
	}


	public static void deck() {
		// TODO Auto-generated method stub
		for(int i = 0; i < 26; i++) {
			if(count[i]%2 == 1) {
				for(int j = 0; j < count[i]; j++) {
					deck.addFirst((char) (65 + i));
				}
			}
			else {
				for(int j = 0; j < count[i]/2; j++) {
					deck.addLast((char) (65 + i));
					if(j == 0) {
						q.add(i);						
					}
				}
			}
		}
//		ans();
		
		Iterator itr = q.iterator();
		while(itr.hasNext()) {
//			System.out.println((int) itr.next());
			int a = (int) itr.next();
//			System.out.println(a);
			for(int j = 0; j < count[a]/2; j++) {
				deck.addFirst((char) (65 + a));
			}
		}
	}


	public static void odd() {
		// TODO Auto-generated method stub
		int odd = 0;
		for(int i = 0 ; i < 26 ; i++) {
			if(count[i] % 2 == 1) {
				odd++;
			}
			
			if(odd > 1 ) {
				System.out.println("NO SOLUTION");
				System.exit(0);
			}
		}
	}


	public static void input() {
		// TODO Auto-generated method stub
		for(int i = 0; i < sLen; i++) {
			count[s.charAt(i)-65]++;
		}
		
//		System.out.println(Arrays.toString(count));
	}


	static class FastReader {
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
