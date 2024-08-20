import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Robot {
	int x, y, d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
	public Robot(int x, int y, int d) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
	}
	
	public void rear() {
		int tmpD = (this.d + 2) % 4;
		int nx = this.x + dx[tmpD];
		int ny = this.y + dy[tmpD];
		this.x = nx; this.y = ny;
	}
	public void rotate() {
		int tmpD = this.d - 1;
		if(tmpD < 0) tmpD = 3;
		this.d = tmpD;
	}
}
public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    Robot robot = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
	    int[][] room = new int[N][M];
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
	    	st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	    /// input end ///
	    boolean endSwc = false;
	    int cleanSpace = 0;
	    int[] dx = {-1, 0, 1, 0};
	    int[] dy = {0, 1, 0, -1};
	    while(!endSwc) {
	    	int cur_x = robot.x;
	    	int cur_y = robot.y;
	    	int cur_d = robot.d;
	    	// 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
	    	if(room[cur_x][cur_y] == 0) {
	    		room[cur_x][cur_y] = 2;
	    		cleanSpace++;
	    	}
	    	
	    	// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우,
	    	boolean swc = false;
	    	for (int i = 0; i < 4; i++) {
				int nx = cur_x + dx[i];
				int ny = cur_y + dy[i];
				if(room[nx][ny] == 0) {
					swc = true;
					break;
				}
			}
	    	if(!swc) {
	    		int nx = cur_x + dx[(cur_d + 2) % 4];
	    		int ny = cur_y + dy[(cur_d + 2) % 4];
	    		if(room[nx][ny] == 0 || room[nx][ny] == 2) robot.rear();
	    		else {
	    			break;
	    		}
	    	}
	    	// 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우,
	    	else {
	    		robot.rotate();
	    		cur_d = robot.d;
	    		int nx = cur_x + dx[cur_d];
	    		int ny = cur_y + dy[cur_d];
	    		if(room[nx][ny] == 0) {
	    			robot.x = nx;
	    			robot.y = ny;
	    		}
	    	}
	    }
	    bw.write(cleanSpace + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}
