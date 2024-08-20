import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static long pow(long a, long b, long m) {
		if (b == 1) return a % m;
		long val = pow(a, b/2, m);
		val = val * val % m;
		if (b % 2 == 0) return val;
		return val * a % m;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		long C = Long.parseLong(st.nextToken());
		long value = pow(A, B, C);
		
		bw.write(value + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}