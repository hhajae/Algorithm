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
		long M = Integer.parseInt(st.nextToken());
		long[] trees = new long[N];
		s = br.readLine();
		st = new StringTokenizer(s, " ");
		long maxH = 0;
		for (int i = 0; i < N; i++) {
			trees[i] = Long.parseLong(st.nextToken());
			if (trees[i] > maxH) maxH = trees[i];
		}
		/// input end ///
		long Msum = 0;
		boolean swc = true;
		long cutH = maxH / 2;
		long mulCnt = 2;
		long resH = 0;
		int cnt = 0;
		while(swc) {
			Msum = 0;
			mulCnt *= 2;
			for (int i = 0; i < N; i++) {
				if (trees[i] > cutH) {
					Msum += trees[i] - cutH;
				}
			}
			long div = maxH / mulCnt;
			if (div == 0) {
				mulCnt /= 2;
				div = 1;	
			}
			if (cnt++ > 50) {
				if (Msum > M)
					resH = cutH;
				else
					resH = cutH - 1;
				break;
			}
			if (Msum == M) {
				resH = cutH;
				break;
			}
			else if (Msum > M) {
				cutH = cutH + div;
			}
			else if (Msum < M) {
				cutH = cutH - div;
			}

		}
		bw.write(resH + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}