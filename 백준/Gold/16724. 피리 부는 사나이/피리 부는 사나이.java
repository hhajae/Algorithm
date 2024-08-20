import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N, M;
	static char[][] board;
	static int[] parents;
	private static int getDirect(char c) {
		if(c == 'U') return 0;
		if(c == 'D') return 1;
		if(c == 'L') return 2;
		if(c == 'R') return 3;
		return -1;
	}
	
	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return;
		if(a < b) parents[b] = a;
		else parents[a] = b;
	}
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	private static void dfs(int x, int y) {
		int d = getDirect(board[x][y]);
		int nx = x + dx[d];
		int ny = y + dy[d];
		int cur = M*x + y;
		int next = M*nx + ny;
		if(find(cur) != find(next)) {
			union(cur, next);
			dfs(nx, ny);
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
        	s = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
			}
		}
        /// input end ///
        parents = new int[N*M];
        for (int i = 0; i < N*M; i++) {
			parents[i] = i;
		}
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(parents[M*i+j] != M*i+j) continue;
				dfs(i, j);
			}
		}
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < N*M; i++) {
			set.add(find(parents[i]));
		}
        sb.append(set.size());
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
