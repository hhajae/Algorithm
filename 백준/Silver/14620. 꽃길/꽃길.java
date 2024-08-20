import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static boolean np(int[] p) {
		int N = p.length;
		
		int x = N-1;
		while(x > 0 && p[x-1] >= p[x]) x--;
		if(x == 0) return false;
		
		int y = N-1;
		while(p[x-1] >= p[y]) y--;
		
		int tmp = p[x-1];
		p[x-1] = p[y];
		p[y] = tmp;
		
		int z = N-1;
		while(x < z) {
			tmp = p[x];
			p[x++] = p[z];
			p[z--] = tmp;
		}
		return true;
	}
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    int N = Integer.parseInt(br.readLine());
	    int[][] park = new int[N][N];
	    for (int i = 0; i < N; i++) {
	    	String s = br.readLine();
	    	st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				park[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	    /// input end ///
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};
	    int[] npArr = new int[N*N];
	    npArr[N*N-1] = 1; npArr[N*N-2] = 1; npArr[N*N-3] = 1; // 뒤에 세칸 1로 채우기
	    int minCost = Integer.MAX_VALUE;
	    do {
	    	boolean[][] isvisited = new boolean[N][N];
	    	int cost = 0;
	    	int eachFlowerCost = 0;
	    	int flowerCnt = 0;
	    	for (int i = 0; i < N*N; i++) {
				if(npArr[i] == 0) continue;
				int cur_x = i/N, cur_y = i%N;
				if(isvisited[cur_x][cur_y]) break;
				int flowerLeafCnt = 1;
				eachFlowerCost += park[cur_x][cur_y];
				isvisited[cur_x][cur_y] = true;
				for (int j = 0; j < 4; j++) {
					int nx = cur_x + dx[j];
					int ny = cur_y + dy[j];
					if(nx < 0 || nx >= N || ny < 0 || ny >= N) break;
					if(isvisited[nx][ny]) break;
					isvisited[nx][ny] = true;
					flowerLeafCnt++;
					eachFlowerCost += park[nx][ny];
				}
				if(flowerLeafCnt == 5) {
					flowerCnt++;
					cost += eachFlowerCost;
				}
				eachFlowerCost = 0;
			}
	    	if(flowerCnt == 3) {
	    		minCost = Math.min(minCost, cost);
	    	}
	    	
	    } while(np(npArr));
	    bw.write(minCost + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}