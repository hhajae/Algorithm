import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int[] cards = new int[N+1];
        for (int i = 1; i < N+1; i++) {
			cards[i] = Integer.parseInt(st.nextToken());
		}
        /// input end ///
        int[] D = new int[N+1];
        for (int i = 1; i < N+1; i++) {
			for (int j = 1; j <= i; j++) {
				D[i] = Math.max(D[i], D[i-j] + cards[j]);
			}
		}
        sb.append(D[N]);
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
