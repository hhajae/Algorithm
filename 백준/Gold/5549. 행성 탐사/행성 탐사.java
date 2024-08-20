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
        
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        int accmSum[][][] = new int[M+1][N+1][3]; // jungle ocean ice
        for (int i = 1; i < M+1; i++) {
        	s = br.readLine();
        	int jg = 0, oc = 0, ice = 0;
			for (int j = 1; j < N+1; j++) {
				char c = s.charAt(j-1);
				accmSum[i][j][0] = jg;
				accmSum[i][j][1] = oc;
				accmSum[i][j][2] = ice;
				if (c == 'J') accmSum[i][j][0] = ++jg;
				else if (c == 'O') accmSum[i][j][1] = ++oc;
				else accmSum[i][j][2] = ++ice;
				accmSum[i][j][0] += accmSum[i-1][j][0];
				accmSum[i][j][1] += accmSum[i-1][j][1];
				accmSum[i][j][2] += accmSum[i-1][j][2];
			}
		}
        for (int i = 0; i < K; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int jungle = 0, ocean = 0, ice = 0;
			int startX = Integer.parseInt(st.nextToken());
			int startY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());

			jungle = accmSum[endX][endY][0] - accmSum[startX-1][endY][0] - 
					accmSum[endX][startY-1][0] + accmSum[startX-1][startY-1][0];
			ocean = accmSum[endX][endY][1] - accmSum[startX-1][endY][1] - 
					accmSum[endX][startY-1][1] + accmSum[startX-1][startY-1][1];
			ice = accmSum[endX][endY][2] - accmSum[startX-1][endY][2] - 
					accmSum[endX][startY-1][2] + accmSum[startX-1][startY-1][2];
			
			StringBuilder sb = new StringBuilder();
			sb.append(jungle).append(" ").append(ocean).append(" ").append(ice).append("\n");
			bw.write(sb.toString());
		}
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}