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
			int N = Integer.parseInt(br.readLine());
			List<String> first = new ArrayList<>();
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				first.add(st.nextToken());
			}
			List<String> second = new ArrayList<>();
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				second.add(st.nextToken());
			}
			List<String> encrypt = new ArrayList<>();
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				encrypt.add(st.nextToken());
			}
			/// input end ///
			List<Integer> where = new ArrayList<>();
			outer: for (String sec : second) {
				for (int j = 0; j < first.size(); j++) {
					if(sec.equals(first.get(j))){
						where.add(j);
						continue outer;
					}
				}
			}

			String[] result = new String[N];
			int cnt = 0;
			for (Integer ind : where) {
				result[ind] = encrypt.get(cnt++);
			}

			for (String str : result) {
				sb.append(str).append(" ");
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
