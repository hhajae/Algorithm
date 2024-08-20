import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	private static int gcd(int a, int b) {
		int res = 0;
		if(a % b == 0) return b;
		else res = gcd(b%a, a);
		return res;
	}
	private static int henry(int a, int b) {
		for (int i = b/a; i < Integer.MAX_VALUE; i++) {
			int x1 = i;
			int n = b;
			int m = a * x1;
			if(n <= m) {
				int a1 = m-n;
				int b1 = x1*b;
				if(a1 == 0) return x1;
				int gcd = gcd(a1, b1);
				return henry(a1/gcd, b1/gcd);
			}
		}
		return -1;
		
	} 
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    int T = Integer.parseInt(br.readLine());
	    for (int test_case = 0; test_case < T; test_case++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int res = henry(a, b);
			bw.write(res + "\n");
		}
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}