import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static boolean[] isselected;
	static int[] numbers;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	private static void nm(int cnt) {
		if (cnt == M) {
			for (int i = 0; i < M-1; i++) {
				sb.append(numbers[i]).append(" ");
			}
			sb.append(numbers[M-1]).append("\n");
			return;
		}
		for (int i = 0; i < N; i++) {
			if (isselected[i]) continue;
			isselected[i] = true;
			numbers[cnt] = arr[i];
			nm(cnt+1);
			isselected[i] = false;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isselected = new boolean[N+1];
		numbers = new int[M];
		arr = new int[N];
		s = br.readLine();
		st = new StringTokenizer(s, " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		nm(0);
		
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}