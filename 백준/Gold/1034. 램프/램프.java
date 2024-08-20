import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;
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
        boolean[][] lamp = new boolean[N][M];
        for (int i = 0; i < N; i++) {
        	s = br.readLine();
			for (int j = 0; j < M; j++) {
				if(s.charAt(j) - '0' == 1) lamp[i][j] = true; 
			}
		}
        int K = Integer.parseInt(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
			int offCnt = 0;
			for (int j = 0; j < M; j++) {
				if(!lamp[i][j]) offCnt++;
			}
			if(offCnt <= K && ((K - offCnt) % 2 == 0)) {
				String lampStr = Arrays.toString(lamp[i]);
				if(map.containsKey(lampStr)) {
					map.replace(lampStr, map.get(lampStr) + 1);
				}
				else {
					map.put(lampStr, 1);
				}
			}
		}
        Set<String> set = map.keySet();
        int maxOnRow = 0;
        for (String str : set) {
			if(map.get(str) > maxOnRow) {
				maxOnRow = map.get(str);
			}
		}
        sb.append(maxOnRow);
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
