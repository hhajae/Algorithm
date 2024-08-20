import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    int T = Integer.parseInt(br.readLine());
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < T; i++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> map = new HashMap<>();
			int ind = -1;
			int[] wears = new int[30];
			for (int j = 0; j < n; j++) {
				String s = br.readLine();
				st = new StringTokenizer(s, " ");
				String name = st.nextToken();
				String type = st.nextToken();
				if(map.containsKey(type)) {
					wears[map.get(type)]++;
				}
				else {
					map.put(type, ++ind);
					wears[ind] = 1;
				}
			}
			int resCnt = wears[0] + 1;
			for (int j = 1; j < 30; j++) {
				if(wears[j] == 0) break;
				resCnt *= (wears[j] + 1);
			}
			sb.append(resCnt-1).append("\n");
		}
	    bw.write(sb.toString());
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}