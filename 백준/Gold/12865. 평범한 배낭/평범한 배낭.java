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
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    int[][] things = new int[N+1][2];
	    for (int i = 1; i < N+1; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int W = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			things[i][0] = W; things[i][1] = V;
		}
	    int[][] D = new int[N+1][K+1];
	    for (int i = 1; i <= N; i++) { // 물건
			for (int j = 1; j < K+1; j++) { // 무게
				if(things[i][0] > j) D[i][j] = D[i-1][j];
				else D[i][j] = Math.max(things[i][1] + D[i-1][j - things[i][0]], D[i-1][j]);
			}
		}
	    sb.append(D[N][K]);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
