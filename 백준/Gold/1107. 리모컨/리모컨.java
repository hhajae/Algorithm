import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static boolean[] button = {true, true, true, true, true, true, true, true, true, true};
	static int N;
	static int Nlen;
	static int minRes = Integer.MAX_VALUE;
	private static void dfs(int cnt, String channel) {
		if(Integer.parseInt(channel) > 1000000) return;
		if(channel.length() > 7) return;
		if(cnt > minRes) return;
		if(Integer.parseInt(channel) == N) {
			minRes = Math.min(minRes, cnt);
			return;
		}
		int n = Integer.parseInt(channel);
		for (int i = 9; i >= 0; i--) {
			if(!button[i]) continue;
			if(cnt == 0) {
				dfs(cnt+1, i + "");
			}
			else {
				dfs(cnt+1, channel + i);
			}
		}
		if(n < N) dfs(cnt+(N-n), N + "");
		if(n > 0 && n > N) dfs(cnt+(n-N), N + "");
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    N = Integer.parseInt(br.readLine());
	    Nlen = (N+"").length();
	    int M = Integer.parseInt(br.readLine());
	    if (M != 0) {
		    String s = br.readLine();
		    st = new StringTokenizer(s, " ");
		    for (int i = 0; i < M; i++) {
				int n = Integer.parseInt(st.nextToken());
				button[n] = false;
			}
	    }
	    dfs(0, "100");
	    bw.write(minRes + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}