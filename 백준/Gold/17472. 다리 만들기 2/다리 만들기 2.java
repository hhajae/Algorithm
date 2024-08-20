import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int from, to, weight;

	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	

	@Override
	public String toString() {
		return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
	}


	@Override
	public int compareTo(Edge o) {
		return Integer.compare(this.weight, o.weight);
	}
	
}
public class Main {
	static int[] parents;
	static List<Edge> edgeLst;
	static int island_cnt;
	private static void make() {
		parents = new int[island_cnt+1];
		for (int i = 1; i < island_cnt+1; i++) {
			parents[i] = i;
		}
	}
	private static int findSet(int a) {
		if (a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	private static boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		parents[aRoot] = bRoot;
		return true;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] island = new int[N][M];
        for (int i = 0; i < N; i++) {
        	s = br.readLine();
        	st = new StringTokenizer(s, " ");
			for (int j = 0; j < M; j++) {
				island[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        /// input end ///
        island_cnt = 0;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<Integer> que_x = new ArrayDeque<>();
        Queue<Integer> que_y = new ArrayDeque<>();
        boolean[][] isvisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(island[i][j] == 0 || isvisited[i][j]) continue;
				island_cnt++;
				que_x.offer(i); que_y.offer(j);
				isvisited[i][j] = true;
				while(!que_x.isEmpty()) {
					int cur_x = que_x.poll();
					int cur_y = que_y.poll();
					island[cur_x][cur_y] = island_cnt;
					for (int k = 0; k < 4; k++) {
						int nx = cur_x + dx[k];
						int ny = cur_y + dy[k];
						if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
						if(isvisited[nx][ny] || island[nx][ny] == 0) continue;
						que_x.offer(nx); que_y.offer(ny);
						isvisited[nx][ny] = true;
					}
				}
			}
		}
//        for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				bw.write(island[i][j] + " ");
//			}
//			bw.newLine();
//		}
        edgeLst = new ArrayList<Edge>();
        for (int pos = 0; pos < N*M; pos++) { // 간선 추가
			if(island[pos/M][pos%M] == 0) continue;
			int cur_land = island[pos/M][pos%M];
			for (int i = 0; i < 4; i++) {
				int mulCnt = 0;
				int to_land = -1;
				boolean swc = false;
				while(true) {
					int nx = pos/M + dx[i] * ++mulCnt;
					int ny = pos%M + dy[i] * mulCnt;
					if(nx < 0 || nx >= N || ny < 0 || ny >= M)	break;
					if(island[nx][ny] == cur_land) break;
					if(island[nx][ny] == 0) continue;
					swc = true;
					to_land = island[nx][ny];
					break;
				}
				if (swc && mulCnt > 2) {
					edgeLst.add(new Edge(cur_land, to_land, --mulCnt));
				}
			}
			
		}
        Collections.sort(edgeLst);
//        for (int i = 0; i < edgeLst.size(); i++) {
//			bw.write(edgeLst.get(i) + "\n");
//		}

        make();
        int cnt = 0;
        int weight = 0;
        for (int i = 0; i < edgeLst.size(); i++) {
        	int from = edgeLst.get(i).from; 
        	int to = edgeLst.get(i).to;
        	int w = edgeLst.get(i).weight;
        	if(!unionSet(from, to)) continue;
//        	bw.write("from, to = " + from + ", " + to + "\n");
        	weight += w;
			if(++cnt == island_cnt-1) break;
		}
        if(cnt == island_cnt-1) bw.write(weight + "\n");
        else bw.write("-1\n");
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}