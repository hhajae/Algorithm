import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int[] numbers = new int[N];
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		int[] Dp = new int[N];
		for (int i = 0; i < N; i++) {
			Dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if(numbers[j] >= numbers[i]) continue;
				Dp[i] = Math.max(Dp[i], Dp[j]+1);
			}
		}
		Arrays.sort(Dp);
		bw.write(Dp[N-1] + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}