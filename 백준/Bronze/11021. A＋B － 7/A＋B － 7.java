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
		int a, b;
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			bw.write("Case #" + (i+1) + ": ");
			bw.write((a+b) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}