import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, L;
	static int[] closetSeq;
	static int minRes = Integer.MAX_VALUE;
	private static void dfs(int line, boolean[] closet, int a, int b, int num) {
		if(line == L) {
			minRes = Math.min(minRes, num);
			return;
		}
		if(num >= minRes) return;
		int cur = closetSeq[line];
		if(closet[cur]) {
			dfs(line+1, closet, a, b, num);
		}
		else {
			boolean[] tmpCloset1 = new boolean[N+1];
			boolean[] tmpCloset2 = new boolean[N+1];
			for (int i = 1; i < N+1; i++) {
				tmpCloset1[i] = closet[i];
				tmpCloset2[i] = closet[i];
			}
			if(a < cur) {
				for (int i = a; i < cur; i++) {
					tmpCloset1[i] = false;
				}
				tmpCloset1[cur] = true;
				dfs(line+1, tmpCloset1, cur, b, num+(cur-a));
			}
			else if(a > cur) {
				for (int i = cur+1; i <= a; i++) {
					tmpCloset1[i] = false;
				}
				tmpCloset1[cur] = true;
				dfs(line+1, tmpCloset1, cur, b, num+(a-cur));
			}
			if(b < cur) {
				for (int i = b; i < cur; i++) {
					tmpCloset2[i] = false;
				}
				tmpCloset2[cur] = true;
				dfs(line+1, tmpCloset2, a, cur, num+(cur-b));
			}
			else if(b > cur) {
				for (int i = cur+1; i <= b; i++) {
					tmpCloset2[i] = false;
				}
				tmpCloset2[cur] = true;
				dfs(line+1, tmpCloset2, a, cur, num+(b-cur));
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(br.readLine());
		closetSeq = new int[L];
		for (int i = 0; i < L; i++) {
			closetSeq[i] = Integer.parseInt(br.readLine());
		}
		/// input end ///
		boolean[] closets = new boolean[N+1];
		closets[a] = true; closets[b] = true;
		dfs(0, closets, a, b, 0);
		bw.write(minRes + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
