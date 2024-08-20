import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int[] bridge = new int[N];
		for (int i = 0; i < N; i++) {
			bridge[i] = Integer.parseInt(st.nextToken());
		}
		s = br.readLine();
		st = new StringTokenizer(s, " ");
		int start = Integer.parseInt(st.nextToken()) - 1;
		int end = Integer.parseInt(st.nextToken()) - 1;
		if(bridge[start] == 1) {
			bw.write("1\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		if(start == end) {
			bw.write("0\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		int minRes = Integer.MAX_VALUE;
		Queue<Integer> que = new ArrayDeque<>();
		int[] dist = new int[N];
		dist[start] = 1;
		int startJump = bridge[start];
		for (int i = start + startJump; i < N; i += startJump) {
			que.offer(i);
			dist[i] = dist[start] + 1;
			if(i == end) {
				bw.write("1\n");
				bw.flush();
				bw.close();
				br.close();
				return;
			}
		}
		for (int i = start - startJump; i >= 0; i -= startJump) {
			que.offer(i);
			dist[i] = dist[start] + 1;
			if(i == end) {
				bw.write("1\n");
				bw.flush();
				bw.close();
				br.close();
				return;
			}
		}
		outer : while(!que.isEmpty()) {
			int cur = que.poll();
			int jump = bridge[cur];
			if(jump == 1) {
				minRes = dist[cur];
				que.clear();
				break;
			}
			for (int i = cur + jump; i < N; i += jump) {
				if(dist[i] > 0)	{
					dist[i] = Math.min(dist[cur] + 1, dist[i]);
					continue;
				}
				else dist[i] = dist[cur] + 1;
				if(i == end) {
					que.clear();
					minRes = dist[cur];
					break outer;
				}
				que.offer(i);
			}
			for (int i = cur - jump; i >= 0; i -= jump) {
				if(dist[i] > 0)	{
					dist[i] = Math.min(dist[cur] + 1, dist[i]);
					continue;
				}
				else dist[i] = dist[cur] + 1;
				if(i == end) {
					que.clear();
					minRes = dist[cur];
					break outer;
				}
				que.offer(i);
			}
		}
		if(minRes == Integer.MAX_VALUE) sb.append(-1);
		else sb.append(minRes);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
