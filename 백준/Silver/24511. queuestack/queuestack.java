import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringTokenizer st1 = null;
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		s = br.readLine();
		st1 = new StringTokenizer(s, " ");
		Deque<Integer> B_que = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			int nn = Integer.parseInt(st1.nextToken());
			if (n == 0) B_que.add(nn);
		}

		int M = Integer.parseInt(br.readLine());
		s = br.readLine();
		st = new StringTokenizer(s, " ");
		int[] C = new int[M];
		for (int i = 0; i < M; i++) {
			C[i] = Integer.parseInt(st.nextToken()); // 삽입할 원소
		}
		StringBuilder sb = new StringBuilder();
		if (B_que.size() == 0) {
			for (int i = 0; i < M; i++) {
				sb.append(C[i]).append(" ");
			}
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		// input end //

		for (int i = 0; i < M; i++) {
			sb.append(B_que.pollLast()).append(" ");
			B_que.addFirst(C[i]);
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}