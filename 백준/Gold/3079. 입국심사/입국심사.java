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
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] Times = new int[N];
		for (int i = 0; i < N; i++) {
			Times[i] = Integer.parseInt(br.readLine());
		}
		/// input end ///
		if(N == 1) {
			bw.write((long)Times[0] * M + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		Arrays.sort(Times);
		long friends = 0;
		long minTime = 0;
		long start = 0;
		long end = (long)Times[0] * M;
		long mid = 0;
		while(start < end - 1) {
			mid = (start + end) / 2;
			minTime = mid;
			friends = 0;
			for (int i = 0; i < N; i++) {
				if(Times[i] > minTime) break;
				friends += minTime / Times[i];
			}
			if(friends < M) {
				start = mid;
			}
			else if(friends >= M) {
				end = mid;
			}
		}
		bw.write(end + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}