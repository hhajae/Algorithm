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
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] soldiers = new int[N];
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		for (int i = 0; i < N; i++) {
			soldiers[i] = Integer.parseInt(st.nextToken());
		}
		int[] D = new int[N];
		for (int i = 0; i < N; i++) {
			D[i] = 1;
			for (int j = 0; j < i; j++) {
				if(soldiers[j] <= soldiers[i]) continue;
				D[i] = Math.max(D[i], D[j] + 1);
			}
		}
		Arrays.sort(D);
		sb.append(N - D[N-1]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
