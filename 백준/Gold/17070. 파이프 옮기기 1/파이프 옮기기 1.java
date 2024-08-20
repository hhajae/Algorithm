import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int resCnt, N;
	static int[][] home;
	static boolean[][][] isvisited;
	private static void dfs(int nx, int ny, int type) {
		// type = 내 현재상태
		if (nx == N-1 && ny == N-1) {
			if (home[nx][ny] == 1) return;
			if (type == 3) {
				if (home[nx-1][ny] == 1 || home[nx][ny-1] == 1) return;
			}
			resCnt++;
			return;
		}
		if (nx >= N || ny >= N) return; // 밖에 나가는거
		if (isvisited[nx][ny][type]) return; // 이미 이 방향으로 들어왔던거
		if (home[nx][ny] == 1) return; // 대각으로 왔을 땐 더 체크 해야한다 밑에서. 기억해라
		//isvisited[nx][ny][type] = true;
		if (type == 1) { // 가로다
			dfs(nx, ny+1, 1); // 가로로 보냄
			dfs(nx+1, ny+1, 3); // 대각으로 보냄
		}
		else if (type == 2) { // 세로다
			dfs(nx+1, ny, 2); // 세로로 보냄
			dfs(nx+1, ny+1, 3); // 대각으로 보냄
		}
		else if (type == 3) {
			if (home[nx-1][ny] == 1 || home[nx][ny-1] == 1) return;
			dfs(nx, ny+1, 1); // 가로로 보냄
			dfs(nx+1, ny, 2); // 세로로 보냄
			dfs(nx+1, ny+1, 3); // 대각으로 보냄
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        home = new int[N][N];
        for (int i = 0; i < N; i++) {
        	String s = br.readLine();
        	st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				home[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        /// input end ///
        resCnt = 0;
        isvisited = new boolean[N][N][4];
        isvisited[0][0][1] = true; isvisited[0][0][2] = true; isvisited[0][0][3] = true;
        // isvisited[0][1][1] = true; isvisited[0][1][2] = true; isvisited[0][1][3] = true;
        dfs(0, 1, 1); /// 1 가로, 2 세로, 3 대각
        bw.write(resCnt + "\n");
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}