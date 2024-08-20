import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Buildings {
	int to;
	Buildings next;
	public Buildings(int to, Buildings next) {
		super();
		this.to = to;
		this.next = next;
	}
	public Buildings(int to) {
		super();
		this.to = to;
	}
	@Override
	public String toString() {
		return "Buildings [to=" + to + ", next=" + next + "]";
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

		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Buildings[] town = new Buildings[N+1];
		for (int i = 0; i < M; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			town[from] = new Buildings(to, town[from]);
			town[to] = new Buildings(from, town[to]);
		}
		/// input end ///
		int[] npArr = new int[N];
		npArr[N-1] = npArr[N-2] = 1;
		int minRes = Integer.MAX_VALUE;
		int minA = 0, minB = 0;
		do {
//			bw.write(Arrays.toString(npArr) + "\n");
			int A = 0, B = 0;
			for (int i = 0; i < N; i++) {
				if(npArr[i] == 1) {
					if (A == 0) A = i+1;
					else B = i+1;
				}
			}
			int[] dist = new int[N+1];
			Arrays.fill(dist, -1);
			dist[A] = dist[B] = 0;
			Queue<Integer> que = new ArrayDeque<>();
			que.offer(A); que.offer(B);
			while(!que.isEmpty()) {
				int cur = que.poll();
				for (Buildings tmp = town[cur]; tmp != null; tmp = tmp.next) {
					if(dist[tmp.to] >= 0) continue;
					dist[tmp.to] = dist[cur] + 1;
					que.offer(tmp.to);
				}
			}
			int totalDist = 0;
			for (int i = 1; i < N+1; i++) {
				totalDist += (dist[i] * 2);
			}
			if(totalDist <= minRes) {
				minRes = totalDist;
				minA = A; minB = B;
			}
			
		} while(np(npArr));
		
		bw.write(minA + " " + minB + " " + minRes);
		
		bw.flush();
		br.close();
		bw.close();
	}
}