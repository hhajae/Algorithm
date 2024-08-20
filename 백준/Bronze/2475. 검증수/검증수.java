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
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int b = 0;
		for (int i = 0; i < 5; i++) {
			int a = Integer.parseInt(st.nextToken());
			a = (a*a) % 10;
			b += a;
		}
		bw.write((b % 10) + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}