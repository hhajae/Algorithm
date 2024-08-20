import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		List<Integer> lst = new ArrayList<>();
		lst.add(0);
		long allSum = 0;
		long allXor = 0;
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		outer: for (int i = 0; i < M; i++) {
			String s = br.readLine();
			if(s.length() == 1) {
				int query = Integer.parseInt(s);
				if(query == 3) {
					sb.append(allSum).append("\n");
				}
				else { // 4
					sb.append(allXor).append("\n");
				}
				continue;
			}
			st = new StringTokenizer(s, " ");
			int query = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			if(query == 1) {
				lst.add(x);
				allSum += x;
				allXor = allXor ^ x;
				continue;
			}
			allSum -= x;
			allXor = allXor ^ x;
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}