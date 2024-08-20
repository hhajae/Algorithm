import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		boolean[][] classes = new boolean[N][51];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < k; j++) {
				int ti = Integer.parseInt(st.nextToken());
				classes[i][ti] = true;
			}
		}
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int p = Integer.parseInt(st.nextToken());
			HashSet<Integer> studentSet = new HashSet<>();
			for (int j = 0; j < p; j++) {
				studentSet.add(Integer.parseInt(st.nextToken()));
			}
			int cnt = 0;
			for (int j = 0; j < N; j++) {
				boolean swc =false;
				for (int k = 0; k < 51; k++) {
					if(studentSet.contains(k)) continue;
					if(classes[j][k]) {
						swc = true;
						break;
					}
				}
				if(!swc) cnt++;
			}
			sb.append(cnt).append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}