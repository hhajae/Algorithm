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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] numbers = new int[N+1];
		s = br.readLine();
		st = new StringTokenizer(s, " ");
		for (int i = 1; i < N+1; i++) {
			int n = Integer.parseInt(st.nextToken());
			numbers[i] = numbers[i-1] + n;
		}
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			bw.write((numbers[y] - numbers[x-1]) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}