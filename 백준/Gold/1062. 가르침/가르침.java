import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
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
		StringBuilder sb = new StringBuilder();
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine();
		}
		if(K < 5) {
			bw.write("0"); bw.flush(); bw.close(); br.close(); return;
		}
		// b, d, e, f, g, h, j, k, l, m, o, p, q, r, s, u, v, w, x, y, z
		int[] match = {-1, 0, -1, 1, 2, 3, 4, 5, -1, 6, 7, 8, 9, -1, 10, 11,
				12, 13, 14, -1, 15, 16, 17, 18, 19, 20};
		int[] npArr = new int[21];
		int tmpInd = 20;
		for (int i = 0; i < K - 5; i++) {
			npArr[tmpInd--] = 1;
		}
		int maxRes = 0;
		do {
			int cnt = 0;
			outer : for (int i = 0; i < N; i++) {
				s = words[i];
				if(s.length() == 8) {
					cnt++;
					continue;
				}
				for (int j = 4; j < s.length() - 4; j++) {
					int n = match[s.charAt(j) - 'a'];
					if(n == -1) continue;
					if(npArr[n] == 0) continue outer;
				}
				cnt++;
			}
			maxRes = Math.max(maxRes, cnt);
		} while (np(npArr));
		sb.append(maxRes);
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
