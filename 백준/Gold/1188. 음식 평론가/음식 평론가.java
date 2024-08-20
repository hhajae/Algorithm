import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static int find_gcd(int a, int b) {
		int res = 0;
		if(a % b == 0) return b;
		res = find_gcd(b%a, a);
		return res;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		if(N == 1) {
			bw.write((M-1) + "\n"); bw.flush(); bw.close(); br.close(); return;
		}
		if(M == 1 || N == M) {
			bw.write(0 + "\n"); bw.flush(); bw.close(); br.close(); return;
		}
		if(N > M) sb.append(M - find_gcd(N, M));
		else sb.append(M - find_gcd(M, N));
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
