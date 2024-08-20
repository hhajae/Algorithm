import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		/// input end ///
		Arrays.sort(words);
		int maxSize = 0;
		for (int i = N-1; i >= 0; i--) {
			Set<String> set = new HashSet<>();
			set.add(words[i]);
			outer : for (int j = N-1; j >= 0; j--) {
				if(i == j) continue;
				for (String cur : set) {
					int iterLen = Math.min(cur.length(), words[j].length());
					String A = cur.substring(0, iterLen);
					String B = words[j].substring(0, iterLen);
					if(A.equals(B)) continue outer;
				}
				set.add(words[j]);
			}
			maxSize = Math.max(maxSize, set.size());
		}
		sb.append(maxSize);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
