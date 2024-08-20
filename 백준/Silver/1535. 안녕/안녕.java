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
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] health = new int[N+1];
		int[] pleasure = new int[N+1];
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		for (int i = 1; i < N+1; i++) {
			health[i] = Integer.parseInt(st.nextToken());
		}
		s = br.readLine();
		st = new StringTokenizer(s, " ");
		for (int i = 1; i < N+1; i++) {
			pleasure[i] = Integer.parseInt(st.nextToken());
		}
		int[][] D = new int[N+1][100];
		for (int i = 1; i < N+1; i++) { // 만나는 사람
			for (int j = 0; j < 100; j++) { // 체력
				if(health[i] > j) {
					D[i][j] = D[i-1][j];
					continue;
				}
				D[i][j] = Math.max(D[i-1][j], D[i-1][j-health[i]] + pleasure[i]);
			}
		}
		sb.append(D[N][99]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
