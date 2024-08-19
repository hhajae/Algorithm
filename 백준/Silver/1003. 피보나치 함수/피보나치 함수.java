import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int[][] fibo = new int[41][2];
		fibo[0][0] = 1; fibo[0][1] = 0;
		fibo[1][0] = 0; fibo[1][1] = 1;
		for (int i = 2; i <= 40; i++) {
			fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
			fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
		}
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(fibo[N][0]).append(" ").append(fibo[N][1]).append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		br.close();
		bw.close();
	}
}