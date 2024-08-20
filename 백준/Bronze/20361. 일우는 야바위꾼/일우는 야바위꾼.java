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
		
		for (int test_case = 1; test_case < 2; test_case++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			for (int i = 0; i < K; i++) {
				s = br.readLine();
				st = new StringTokenizer(s, " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if (a != X && b != X) continue;
				if (a == X) X = b;
				else if (b == X) X = a;
			}
			StringBuilder sb = new StringBuilder();
			bw.write(X + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}