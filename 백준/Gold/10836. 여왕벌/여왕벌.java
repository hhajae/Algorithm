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
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] firstCol = new int[M];
		int[] cols = new int[M-1];
		Arrays.fill(cols, 1);
		Arrays.fill(firstCol, 1);
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int zeros = Integer.parseInt(st.nextToken());
			int ones = Integer.parseInt(st.nextToken());
			int twos = Integer.parseInt(st.nextToken());
			// 첫 칼럼 처리
			if(zeros < M) {
				for (int j = zeros; j < zeros+ones; j++) {
					if(j >= M) break;
					firstCol[j]++;
				}
				for (int j = zeros+ones; j < ones+twos; j++) {
					if(j >= M) break;
					firstCol[j] += 2;
				}	
			}
			
			// 나머지 칼럼 처리
			int ind = M-2;
			while(twos-- > 0 && ind >= 0) {
				cols[ind--] += 2;
			}
			while(ones-- > 0 && ind >= 0) {
				cols[ind--] += 1;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M; i++) {
			sb.append(firstCol[M-i-1]).append(" ");
			for (int j = 0; j < M-1; j++) {
				sb.append(cols[j]).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}