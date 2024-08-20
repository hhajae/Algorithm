import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[][] bat;
	static int resCnt = 0;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	private static void Jdfs(int Jpos, int Hpos, boolean[][] isvisited) {
		if(Jpos == Hpos) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if(!isvisited[i][j]) return;
				}
			}
			resCnt++;
		}
		int Jcur_x = Jpos / 5;
		int Jcur_y = Jpos % 5;
		int Hcur_x = Hpos / 5;
		int Hcur_y = Hpos % 5;
		isvisited[Jcur_x][Jcur_y] = true;
		if(isvisited[Hcur_x][Hcur_y]) return;
		isvisited[Hcur_x][Hcur_y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = (Jpos/5) + dx[i];
			int ny = (Jpos%5) + dy[i];
			if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
			if(isvisited[nx][ny]) {
				int Hnx = Hpos/5;
				int Hny = Hpos%5;
				if(nx != Hnx || ny != Hny) continue;	
			}
			int tmpJpos = (nx*5) + ny;
			Hdfs(tmpJpos, Hpos, isvisited);
			isvisited[nx][ny] = false;
		}
	}
	private static void Hdfs(int Jpos, int Hpos, boolean[][] isvisited) {
		if(Jpos == Hpos) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if(!isvisited[i][j]) return;
				}
			}
			resCnt++;
		}
		int Jcur_x = Jpos / 5;
		int Jcur_y = Jpos % 5;
		int Hcur_x = Hpos / 5;
		int Hcur_y = Hpos % 5;
		isvisited[Hcur_x][Hcur_y] = true;
		if(isvisited[Jcur_x][Jcur_y]) return;
		isvisited[Jcur_x][Jcur_y] = true;

        for (int i = 0; i < 4; i++) {
			int nx = (Hpos/5) + dx[i];
			int ny = (Hpos%5) + dy[i];
			if(nx < 0 || nx >= 5 || ny < 0 || ny >= 5) continue;
			if(isvisited[nx][ny]) {
				int Jnx = Jpos/5;
				int Jny = Jpos%5;
				if(nx != Jnx || ny != Jny) continue;	
			}
			int tmpHpos = (nx*5) + ny;
			Jdfs(Jpos, tmpHpos, isvisited);
			isvisited[nx][ny] = false;
		}
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    int K = Integer.parseInt(br.readLine());
	    bat = new int[5][5];
	    boolean[][] isvisited = new boolean[5][5];
	    for (int i = 0; i < K; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			bat[x-1][y-1] = -1;
			isvisited[x-1][y-1] = true;
		}
	    /// input end ///

        Jdfs(0, 24, isvisited);
	    bw.write(resCnt + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}