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
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		
		for (int i = 0; i < N; i++) {
			int n = s.charAt(i) - '0';
			sum += n;
		}
		
		bw.write(sum + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
