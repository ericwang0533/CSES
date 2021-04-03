import java.util.*;
import java.io.*;
public class numberSpiral2 {
	public static BufferedReader br;
	public static StringTokenizer st;
	public static FastReader in = new FastReader();
//	public static int n = in.nextInt();
//	public static Queue<int[]> q = new LinkedList<>();
//	public static int maxX = 0, maxY = 0;
//	public static int[][] mat;
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
	    int t = Integer.parseInt(sc.nextLine());
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < t; i++) {
	      String[] line = sc.nextLine().split(" ");
	      long[] a = Arrays.stream(line).mapToLong(Long::parseLong).toArray();
	      sb.append(algorithm(a));
	      if(i < t-1) {
	        sb.append(System.lineSeparator());
	      }
	    }
	    System.out.println(sb.toString());
	    sc.close();
	  }

	  public static long algorithm(long[] a) {
	    long res;
	    long x = a[1]; // column
	    long y = a[0]; // row
	    if(x >= y) {
	      if(x%2 == 0) {
	        x--;
	        res = (x*x + y);
	      } else {
	        res = x*x - y + 1;
	      }
	    } else {
	      if(y%2 == 0) {
	        res = y*y - x + 1;
	      } else {
	        y--;
	        res = y*y + x;
	      }
	    }
	    return res;
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
