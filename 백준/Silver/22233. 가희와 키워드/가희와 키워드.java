import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
        	map.put(br.readLine(), i);
		}
        boolean[] isused = new boolean[N];
        int cnt = 0;
        for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, ",");
			while(st.hasMoreTokens()) {
				s = st.nextToken();
				if(!map.containsKey(s)) continue;
				if(isused[map.get(s)]) {
					continue;
				}
				isused[map.get(s)] = true;
				cnt++;
			}
			sb.append(N-cnt).append("\n");
		}
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
