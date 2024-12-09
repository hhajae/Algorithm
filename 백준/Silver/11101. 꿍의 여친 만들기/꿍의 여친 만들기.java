import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, ",");
			Map<String, Integer> map = new HashMap<>();
			int res = Integer.MAX_VALUE;
			while (st.hasMoreTokens()) {
				String tmp = st.nextToken();
				StringTokenizer tmpSt = new StringTokenizer(tmp, ":");
				String key = tmpSt.nextToken();
				int value = Integer.parseInt(tmpSt.nextToken());
				map.put(key, value);
			}
			s = br.readLine();
			st = new StringTokenizer(s, "|");
			while (st.hasMoreTokens()) {
				int max = 0;
				String tmp = st.nextToken();
				StringTokenizer tmpSt = new StringTokenizer(tmp, "&");
				while (tmpSt.hasMoreTokens()) {
					String key = tmpSt.nextToken();
					max = Math.max(max, map.get(key));
				}
				res = Math.min(res, max);
			}
			sb.append(res).append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
