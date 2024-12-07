import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			map.put(Integer.parseInt(st.nextToken()), i);
		}
		/// input end ///
		int cur = 0;
		int clapCnt = 0;
		for (int i = 1; i <= N; i++) {
			int ind = map.get(i);
			if(cur < ind) {
				cur = ind;
				continue;
			}
			cur = ind;
			clapCnt++;
		}
		sb.append(clapCnt);

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
