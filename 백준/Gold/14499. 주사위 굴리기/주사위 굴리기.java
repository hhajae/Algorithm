import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Dice {
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	int x, y;
	int[] squares;
	public Dice(int x, int y) {
		this.x = x;
		this.y = y;
		squares = new int[7];
	}
	public int getUnder() {
		return squares[1];
	}
	public int getOver() {
		return squares[6];
	}
	public void move(int k) {
		this.x = this.x + dx[k];
		this.y = this.y + dy[k];
		if(k == 1) { // 동쪽 -> 2, 5는 그대로 3 -> 1, 1 -> 4, 4 -> 6, 6 -> 3
			int tmp = squares[3];
			squares[3] = squares[6];
			squares[6] = squares[4];
			squares[4] = squares[1];
			squares[1] = tmp;
		}
		else if(k == 2) { // 서쪽 -> 2, 5는 그대로 4 -> 1, 1 -> 3, 3 -> 6, 6 -> 4 
			int tmp = squares[4];
			squares[4] = squares[6];
			squares[6] = squares[3];
			squares[3] = squares[1];
			squares[1] = tmp;
		}
		else if(k == 3) { // 북쪽 -> 3, 4는 그대로 2 -> 1, 1 -> 5, 5 -> 6 -> 6 -> 2
			int tmp = squares[2];
			squares[2] = squares[6];
			squares[6] = squares[5];
			squares[5] = squares[1];
			squares[1] = tmp;
		}
		else if(k == 4) { // 남쪽 -> 3, 4는 그대로 5 -> 1, 1 -> 2, 2 -> 6 -> 6 -> 5
			int tmp = squares[5];
			squares[5] = squares[6];
			squares[6] = squares[2];
			squares[2] = squares[1];
			squares[1] = tmp;
		}
	}
	
}
public class Main {
	static int[] dx = {0, 0, 0, -1, 1};
	static int[] dy = {0, 1, -1, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
        	s = br.readLine();
        	st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        int[] commands = new int[K];
        s = br.readLine();
        st = new StringTokenizer(s, " ");
        for (int i = 0; i < K; i++) {
			commands[i] = Integer.parseInt(st.nextToken());
		}
        /// input end ///
        Dice dice = new Dice(x, y);
        for (int i = 0; i < K; i++) {
			int command = commands[i];
			int cur_x = dice.x;
			int cur_y = dice.y;
			int nx = cur_x + dx[command];
			int ny = cur_y + dy[command];
			if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
			dice.move(command);
			if(board[nx][ny] == 0) {
				board[nx][ny] = dice.getUnder();
			}
			else if(board[nx][ny] != 0) {
				dice.squares[1] = board[nx][ny];
				board[nx][ny] = 0;
			}
			sb.append(dice.getOver()).append("\n");
		}
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
