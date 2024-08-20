import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] aCnt = new int[31];
		int[] bCnt = new int[31];
		aCnt[3] = 1; aCnt[4] = 1;
		bCnt[3] = 1; bCnt[4] = 2;
		for (int i = 5; i < 31; i++) {
			aCnt[i] = aCnt[i-2] + aCnt[i-1];
			bCnt[i] = bCnt[i-2] + bCnt[i-1];
		}
		int[] res = new int[2];
		for (int i = 1; i < K; i++) {
			int remain = K - (aCnt[D] * i);
			if(remain % bCnt[D] == 0) {
				res[0] = i;
				res[1] = remain / bCnt[D];
				break;
			}
		}
		sb.append(res[0]).append("\n").append(res[1]);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}