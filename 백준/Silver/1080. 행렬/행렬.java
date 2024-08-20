import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static void change(int[][] board, int r, int c) {
		for (int i = r; i < r+3; i++) {
			for (int j = c; j < c+3; j++) {
				if(board[i][j] == 0) board[i][j] = 1;
				else board[i][j] = 0;
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] prev = new int[N][M];
        for (int i = 0; i < N; i++) {
        	s = br.readLine();
			for (int j = 0; j < M; j++) {
				prev[i][j] = s.charAt(j) - '0';
			}
		}
        int[][] next = new int[N][M];
        for (int i = 0; i < N; i++) {
        	s = br.readLine();
			for (int j = 0; j < M; j++) {
				next[i][j] = s.charAt(j) - '0';
			}
		}
        if(N < 3 || M < 3) {
        	for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(prev[i][j] != next[i][j]) {
						bw.write("-1"); bw.flush(); bw.close(); br.close(); return;			
					}
				}
			}
        	bw.write("0"); bw.flush(); bw.close(); br.close(); return;
        }
        int operCnt = 0;
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(prev[i][j] == next[i][j]) continue;
				if(i + 3 > N || j + 3 > M) {
					bw.write("-1"); bw.flush(); bw.close(); br.close(); return;
				}
				change(prev, i, j);
				operCnt++;
			}
		}
        sb.append(operCnt);
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
