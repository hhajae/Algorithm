import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
        int K = Integer.parseInt(st.nextToken());
        int[] levels = new int[N];
        for (int i = 0; i < N; i++) {
			levels[i] = Integer.parseInt(br.readLine());
		}
        /// input end ///
        int start = 1;
        int end = Integer.MAX_VALUE;
        outer: while(start <= end) {
        	long mid = ((long)start + (long)end) / 2l;
        	long need = 0;
        	for (int i = 0; i < N; i++) {
				if(levels[i] >= mid) continue;
				need += mid - levels[i];
				if(need > K) {
					end = (int)(mid - 1);
					continue outer;
				}
			}
        	if(need <= K) {
        		start = (int)(mid + 1);
        	}
        }
        sb.append(end);
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
