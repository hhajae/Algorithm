import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static final int R = 0;
	static final int G = 1;
	static final int B = 2;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int[][] homes = new int[N+1][3];
        for (int i = 1; i < N+1; i++) {
        	String s = br.readLine();
        	st = new StringTokenizer(s, " ");
			for (int j = 0; j < 3; j++) {
				homes[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        /// input end ///
        
        // 빨강으로 칠했다
        int[][] RD = new int[N+1][3];
        for (int i = 1; i < N+1; i++) {
			Arrays.fill(RD[i], Integer.MAX_VALUE);
		}
        RD[1][R] = homes[1][R];
        RD[2][G] = homes[1][R] + homes[2][G];
        RD[2][B] = homes[1][R] + homes[2][B];
        for (int i = 3; i < N+1; i++) {
			RD[i][R] = Math.min(RD[i-1][G], RD[i-1][B]) + homes[i][R];
			RD[i][G] = Math.min(RD[i-1][R], RD[i-1][B]) + homes[i][G];
			RD[i][B] = Math.min(RD[i-1][R], RD[i-1][G]) + homes[i][B];
		}
        
        // 초록으로 칠했다
        int[][] GD = new int[N+1][3];
        for (int i = 1; i < N+1; i++) {
			Arrays.fill(GD[i], Integer.MAX_VALUE);
		}
        GD[1][G] = homes[1][G];
        GD[2][R] = homes[1][G] + homes[2][R];
        GD[2][B] = homes[1][G] + homes[2][B];
        for (int i = 3; i < N+1; i++) {
			GD[i][R] = Math.min(GD[i-1][G], GD[i-1][B]) + homes[i][R];
			GD[i][G] = Math.min(GD[i-1][R], GD[i-1][B]) + homes[i][G];
			GD[i][B] = Math.min(GD[i-1][R], GD[i-1][G]) + homes[i][B];
		}
        
        // 파랑으로 칠했다
        int[][] BD = new int[N+1][3];
        for (int i = 1; i < N+1; i++) {
			Arrays.fill(BD[i], Integer.MAX_VALUE);
		}
        BD[1][B] = homes[1][B];
        BD[2][G] = homes[1][B] + homes[2][G];
        BD[2][R] = homes[1][B] + homes[2][R];
        for (int i = 3; i < N+1; i++) {
			BD[i][R] = Math.min(BD[i-1][G], BD[i-1][B]) + homes[i][R];
			BD[i][G] = Math.min(BD[i-1][R], BD[i-1][B]) + homes[i][G];
			BD[i][B] = Math.min(BD[i-1][R], BD[i-1][G]) + homes[i][B];
		}
        int res = Math.min(RD[N][G], RD[N][B]);
        res = Math.min(res, Math.min(GD[N][R], GD[N][B]));
        res = Math.min(res, Math.min(BD[N][R], BD[N][G]));
        sb.append(res);
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
