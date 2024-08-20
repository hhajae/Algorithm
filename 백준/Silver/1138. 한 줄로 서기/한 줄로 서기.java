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
		int[] persons = new int[N];
		for (int i = 0; i < N; i++) {
			persons[i] = Integer.parseInt(st.nextToken());
		}
		/// input end ///
		int[] lines = new int[N];
		for (int i = 0; i < N; i++) {
			int cnt = 0;
			int leftPersons = persons[i];
			for (int j = 0; j < N; j++) {
				if(lines[j] > 0) continue;
				if(cnt == leftPersons) {
					lines[j] = i+1;
					break;
				}
				cnt++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(lines[i]).append(" ");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}
