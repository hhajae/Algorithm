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
		int cnt = 0;
		if (N % 5 == 3 || N % 5 == 0) {
			if (N % 5 == 0) {
				cnt = N / 5;
				bw.write(cnt + "\n");
				bw.flush();
				bw.close();
				br.close();
				return;
			}
			cnt = N / 5 + (N % 5) / 3;
			bw.write(cnt + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		else {
			int div = N / 5 - 1;
			while(div >= 0) {
				if ((N - (div * 5)) % 3 == 0) {
					cnt = div + ((N - (div * 5)) / 3);
					bw.write(cnt + "\n");
					bw.flush();
					bw.close();
					br.close();
					return;
				}
				div--;
			}
		}
		bw.write("-1\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}