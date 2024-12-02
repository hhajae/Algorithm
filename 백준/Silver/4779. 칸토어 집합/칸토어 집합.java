import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		while(true) {
			String s = br.readLine();
			if(s == null || s.isEmpty()) break;
			int N = Integer.parseInt(s);
			if(N == 0) {
				sb.append("-\n");
				continue;
			}
			int total = (int)Math.pow(3, N);
			List<String> list = new ArrayList<>();
			for (int i = 0; i < total; i++) {
				list.add("-");
			}
			dfs(list, 0, total);
			for (String str : list) {
				sb.append(str);
			}
			sb.append("\n");
		}

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

	private static void dfs(List<String> list, int start, int end) {
		if(end - start == 1) return;
		int cutNum = (end - start) / 3;
		for(int i = start + cutNum; i < end - cutNum; i++) {
			list.set(i, " ");
		}

		dfs(list, start, start+cutNum);
		dfs(list, end - cutNum, end);
	}

}
