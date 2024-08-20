import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
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
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			set.add(s);
		}
		StringBuilder sb = new StringBuilder();
		List<String> lst = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			if (set.contains(s)) {
				lst.add(s);
			}
		}
		Collections.sort(lst);
		sb.append(lst.size()).append("\n");
		for (int i = 0; i < lst.size(); i++) {
			sb.append(lst.get(i)).append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		br.close();
		bw.close();
	}
}