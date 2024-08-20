import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int to;
	Node next;
	public Node(int to, Node next) {
		super();
		this.to = to;
		this.next = next;
	}
	public Node(int to) {
		super();
		this.to = to;
	}
	@Override
	public String toString() {
		return "Node [to=" + to + ", next=" + next + "]";
	}
}
public class Main {
	private static boolean np(int[] p) {
		int N = p.length;
		
		/// 꼭대기 찾자
		int x = N-1;
		while(x>0 && p[x-1] >= p[x]) x--;
		if(x == 0) return false;
		
		/// 바꿀 얘 찾기
		int y = N-1;
		while(p[x-1] >= p[y]) y--;
		
		/// 바꾸기
		
		int tmp = p[x-1];
		p[x-1] = p[y];
		p[y] = tmp;
		
		/// 꼭대기부터 오름차순
		
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
		int[] population = new int[N];
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		for (int i = 0; i < N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		Node[] gu = new Node[N];
		boolean swc = false;
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				swc = true;
				int to = Integer.parseInt(st.nextToken()) - 1;
				gu[i] = new Node(to, gu[i]);
			}
		}
//		if(!swc) {
//			bw.write("-1\n");
//			bw.flush();
//			bw.close();
//			br.close();
//			return;
//		}
//		bw.write("---Node---\n");
//		for (Node node : gu) {
//			bw.write(node + "\n");
//		}
//		bw.newLine();
//		
		int minPop = Integer.MAX_VALUE;
		Queue<Integer> que = new ArrayDeque<>();
		for (int i = 1; i <= N/2; i++) {
			int[] combArr = new int[N];
			for (int j = 0; j < i; j++)	combArr[N-1-j] = 1;
			do {
				int A = 0, B = 0;
				boolean zerodistrictSwc = false;
				boolean[] zeroisvisited = new boolean[N];
//				bw.write(Arrays.toString(combArr) + "\n");
				
				///////// 0 구역 /////////////
				int zerocnt = 0; boolean zeroswc = false;
				for (int j = 0; j < N; j++) { /// 0 개수 세기 및 스타트 큐에 넣기
					if (combArr[j] == 0 && zeroswc) zerocnt++;
					else if (combArr[j] == 0) {
						que.add(j);
						zeroisvisited[j] = true;
						zerocnt++;
						zeroswc = true;
					}
				}
//				bw.write("zerocnt = " + zerocnt + "\n");
				int tmpcnt = 0; /// tmpCnt == zerocnt -> 탈출
				while(!que.isEmpty()) { // 같은 구역인지 확인
					int cur = que.poll();
					tmpcnt++;
					if(tmpcnt == zerocnt) {
						zerodistrictSwc = true;
						break;
					}
					for (Node tmp = gu[cur]; tmp != null; tmp = tmp.next) {
						if(combArr[tmp.to] == 1) continue;
						if(zeroisvisited[tmp.to]) continue;
						que.add(tmp.to);
						zeroisvisited[tmp.to] = true;
					}
				}
				que.clear();
				if(!zerodistrictSwc) continue;
				////////////////////////////////////
				
				/////////////// 1 구역 ///////////////
				boolean onedistrictSwc = false;
				boolean[] oneisvisited = new boolean[N];
				
				int onecnt = 0; boolean oneswc = false;
				for (int j = 0; j < N; j++) { /// 1 개수 세기 및 스타트 큐에 넣기
					if (combArr[j] == 1 && oneswc) onecnt++;
					else if (combArr[j] == 1) {
						que.add(j);
						oneisvisited[j] = true;
						onecnt++;
						oneswc = true;
					}
				}
//				bw.write("onecnt = " + onecnt + "\n");
				int onetmpcnt = 0; /// onetmpCnt == onecnt -> 탈출
				while(!que.isEmpty()) { // 같은 구역인지 확인
					int cur = que.poll();
//					bw.write("cur = " + cur + "\n");
					onetmpcnt++;
					if(onetmpcnt == onecnt) {
						onedistrictSwc = true;
						break;
					}
					for (Node tmp = gu[cur]; tmp != null; tmp = tmp.next) {
						if(combArr[tmp.to] == 0) continue;
						if(oneisvisited[tmp.to]) continue;
						que.add(tmp.to);
						oneisvisited[tmp.to] = true;
					}
				}
				que.clear();
				//////////////////////////////////////////
				
				////// 같은 구역 이면 //////////
				if(onedistrictSwc) {
					for (int j = 0; j < N; j++) {
						if (combArr[j] == 0) A += population[j];
						else B += population[j];
					}
					minPop = Math.min(minPop, Math.abs(A-B));
				}
				
			} while(np(combArr));
//			bw.newLine();
		}
		if (minPop == Integer.MAX_VALUE) bw.write("-1\n");
		else bw.write(minPop + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}