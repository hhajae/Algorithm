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
		int[][] pos = new int[N][2];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			pos[i][0] = Integer.parseInt(st.nextToken());
			pos[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pos, (o1, o2) -> {
			if (o1[0] == o2[0]) return o1[1] - o2[1];
			return o1[0] - o2[0];
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(pos[i][0]).append(" ").append(pos[i][1]).append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		br.close();
		bw.close();
	}
}