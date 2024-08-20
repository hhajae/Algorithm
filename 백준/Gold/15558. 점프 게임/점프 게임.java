import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, k;
	static int[][] map;
	private static void dfs(int cnt, int row, int delete, boolean[][] isvisited) {
		if(cnt > N) {
			System.out.println("1");
			System.exit(0);
		}
		if(map[row][cnt] == 0) return;
		if(cnt < delete) return;
		if(isvisited[row][cnt]) return;
		isvisited[row][cnt] = true;
		
		if(row == 1) dfs(cnt+k, 0, delete + 1, isvisited);
		else dfs(cnt+k, 1, delete + 1, isvisited);
		if(cnt > 1) dfs(cnt-1, row, delete + 1, isvisited);
		dfs(cnt+1, row, delete + 1, isvisited);
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		N = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[2][N+1];
		for (int i = 0; i < 2; i++) {
			s = br.readLine();
			for (int j = 1; j < N+1; j++) {
				map[i][j] = s.charAt(j-1) - '0';
			}
		}
		/// input end ///
		dfs(1, 0, 1, new boolean[2][N+1]);
		bw.write("0");
				
		bw.flush();
		bw.close();
		br.close();
	}
}