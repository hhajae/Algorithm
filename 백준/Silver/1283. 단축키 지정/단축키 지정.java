import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		String[] options = new String[N];
		int[][] primes = new int[N][2];
		StringBuilder sb = new StringBuilder();
		boolean[] isused = new boolean[123];
		outer: for (int i = 0; i < N; i++) {
			options[i] = br.readLine();
			st = new StringTokenizer(options[i], " ");
			int primeCnt = 0;
			while(st.hasMoreTokens()) {
				primeCnt++;
				String tmp = st.nextToken();
				int firstChar = (int)tmp.charAt(0);
				if(isused[firstChar]) continue;
				isused[firstChar] = true;
				if(firstChar >= 'A' && firstChar <= 'Z') {
					isused[firstChar + 32] = true;
				}
				else if(firstChar >= 'a' && firstChar <= 'z') {
					isused[firstChar - 32] = true;
				}
				primes[i][0] = primeCnt;
				continue outer;
			}
			/// 모든 단어의 첫 글자가 이미 지정되었으면
			for (int j = 0; j < options[i].length(); j++) {
				if(options[i].charAt(j) == ' ') continue;
				if(isused[options[i].charAt(j)]) continue;
				int primeChar = options[i].charAt(j);
				isused[primeChar] = true;
				if(primeChar >= 'A' && primeChar <= 'Z') {
					isused[primeChar + 32] = true;
				}
				else if(primeChar >= 'a' && primeChar <= 'z') {
					isused[primeChar - 32] = true;
				}
				primes[i][1] = j+1;
				continue outer;
			}
		}
//		for (int[] n : primes) {
//			bw.write(Arrays.toString(n) + "\n");
//		}
		for (int i = 0; i < N; i++) {
			if(primes[i][0] != 0) {
				int pos = primes[i][0] - 1;
				st = new StringTokenizer(options[i], " ");
				int posCnt = 0;
				while(st.hasMoreTokens()) {
					String tmp = st.nextToken();
					if(posCnt == pos) {
						sb.append("[").append(tmp.charAt(0)).append("]");
						for (int j = 1; j < tmp.length(); j++) {
							sb.append(tmp.charAt(j));
						}
						sb.append(" ");
					}
					else {
						sb.append(tmp).append(" ");
					}
					posCnt++;
				}
				sb.append("\n");
				continue;
			}
			int pos = primes[i][1] - 1;
			int posCnt = 0;
			for (int j = 0; j < options[i].length(); j++) {
				if(pos == posCnt++) {
					sb.append("[").append(options[i].charAt(j)).append("]");
					continue;
				}
				sb.append(options[i].charAt(j));
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();
	}
}