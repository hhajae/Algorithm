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
	    int L = Integer.parseInt(st.nextToken());
	    s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int[] pipes = new int[N];
	    for (int i = 0; i < N; i++) {
			pipes[i] = Integer.parseInt(st.nextToken());
		}
	    Arrays.sort(pipes);
	    boolean[] istaped = new boolean[1001];
	    int cnt = 0;
	    for (int i = 0; i < N; i++) {
			int n = pipes[i];
			if(istaped[n]) continue;
			cnt++;
			for (int j = n; j < n+L; j++) {
				if(j > 1000) continue;
				istaped[j] = true;
			}
		}
	    sb.append(cnt);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
