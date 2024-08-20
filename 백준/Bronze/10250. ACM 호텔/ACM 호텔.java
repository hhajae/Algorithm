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
		
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int floor = N%H;
			if (floor == 0) floor = H;
			int room = (N-1)/H + 1;
			sb.append((floor * 100) + room + "\n");
		}
		bw.write(sb.toString().substring(0,sb.toString().length()-1));
		
		bw.flush();
		br.close();
		bw.close();
	}
}
