import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int A = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		/// end input ///

		List<Integer> list = new ArrayList<>();
		Set<Integer> set = new HashSet<>();
		list.add(A);
		set.add(A);
		int dup = -1;
		while(true) {
			String str = Integer.toString(list.get(list.size() - 1));
			int num = 0;
			for (int i = 0; i < str.length(); i++) {
				int n = Integer.parseInt(str.substring(i, i + 1));
				n = (int) Math.pow(n, P);
				num += n;
			}
			if (set.contains(num)) {
				dup = num;
				break;
			}
			set.add(num);
			list.add(num);
		}
		int cnt = 0;
		for (Integer val : list) {
			if(val == dup) break;
			cnt++;
		}
		sb.append(cnt);

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
