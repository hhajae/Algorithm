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
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if(n == 1) continue;
			if(n == 2) {
				cnt++;
				continue;
			}
			boolean swc = false;
			for (int j = 2; j < n; j++) {
				if(n % j == 0) {
					swc = true;
					break;
				}
			}
			if(!swc) cnt++;
		}
		bw.write(cnt + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}