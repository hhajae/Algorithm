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
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] stock = new int[N];
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int i = 0; i < N; i++) {
				stock[i] = Integer.parseInt(st.nextToken());
			}
			/// input end ///
			long profit = 0;
			int maxStock = stock[N-1];
			for (int i = N-2; i >= 0; i--) {
				if(stock[i] < maxStock) {
					profit += maxStock - stock[i];
					continue;
				}
				if(stock[i] > maxStock) {
					maxStock = stock[i];
					continue;
				}
			}
			sb.append(profit).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
