import java.io.*;
import java.util.*;

class Virus {
	int x, y;

	public Virus(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
}
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
	    StringBuilder sb = new StringBuilder();
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    int[][] board = new int[N][N];
	    int emptySize = 0;
	    List<Virus> virus = new ArrayList<>();
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
	    	st = new StringTokenizer(s, " ");
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if(board[i][j] == 0) {
					emptySize++;
				} else if (board[i][j] == 2) {
					virus.add(new Virus(i, j));
				}
			}
		}
	    int[] dx = {-1, 1, 0, 0};
	    int[] dy = {0, 0, -1, 1};
	    
	    int virusSize = virus.size();
	    int[] npArr = new int[virusSize];
	    for (int i = 0; i < M; i++) {
			npArr[virusSize - i - 1] = 1;
		}
	    int minRes = Integer.MAX_VALUE;
	    outer: do {
	    	Queue<Integer> que_x = new ArrayDeque<>();
	    	Queue<Integer> que_y = new ArrayDeque<>();
	    	int[][] dist = new int[N][N];
	    	for (int i = 0; i < N; i++) {
	    		Arrays.fill(dist[i], -1);
	    	}
	    	for (int i = 0; i < virusSize; i++) {
				if(npArr[i] == 1) {
					int x = virus.get(i).x;
					int y = virus.get(i).y;
					que_x.offer(x);
					que_y.offer(y);
					dist[x][y] = 0;
				}
			}
	    	int emptyCnt = 0;
	    	while(!que_x.isEmpty()) {
	    		int cur_x = que_x.poll();
	    		int cur_y = que_y.poll();
	    		for (int i = 0; i < 4; i++) {
					int nx = cur_x + dx[i];
					int ny = cur_y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					if(board[nx][ny] == 1) continue;
					if(dist[nx][ny] >= 0) continue;
					if(board[nx][ny] == 0) emptyCnt++;
					if(emptyCnt == emptySize) {
						minRes = Math.min(minRes, dist[cur_x][cur_y] + 1);
						continue outer;
					}
					dist[nx][ny] = dist[cur_x][cur_y] + 1;
					if(dist[nx][ny] > minRes) continue outer;
					que_x.offer(nx); que_y.offer(ny);
				}
	    	}
		} while (np(npArr));
	    if(emptySize == 0) sb.append(0);
	    else if(minRes == Integer.MAX_VALUE) sb.append(-1);
	    else sb.append(minRes);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
