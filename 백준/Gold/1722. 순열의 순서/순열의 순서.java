import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static long factorial(int n) {
		long tmp = 1;
		for (int i = 2; i <= n; i++) {
			tmp *= i;
		}
		return tmp;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int problemType = Integer.parseInt(st.nextToken());
		if(problemType == 1) {
			int[] numbers = new int[N];
			for (int i = 0; i < N; i++) {
				numbers[i] = i+1;
			}
			long seq = Long.parseLong(st.nextToken());
			if(N == 1) {
				bw.write("1\n");
				bw.flush();
				br.close();
				bw.close();
				return;
			}
			List<Integer> lst = new ArrayList<>();
			boolean[] isused = new boolean[N+1];
			long cnt = 1;
			boolean endSwc = false;
			int tmpN = N;
			outer : while(!endSwc) {
				long interval = factorial(--tmpN);
				for (int i = 0; i < N; i++) {
					if(isused[numbers[i]]) continue;
					int n = numbers[i];
					cnt += interval;
					if(seq == cnt) {
						for (int j = i+1; j < N; j++) {
							if(isused[numbers[j]]) continue;
							lst.add(numbers[j]);
							isused[numbers[j]] = true;
							break;
						}
						endSwc = true;
						for (int j = 0; j < N; j++) {
							if(isused[numbers[j]]) continue;
							lst.add(numbers[j]);
							isused[numbers[j]] = true;
							if(lst.size() == N) break outer;
						}
					} 
					else if(seq < cnt) {
						cnt -= interval;
						lst.add(n);
						isused[n] = true;
						break;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				sb.append(lst.get(i)).append(" ");
			}
		}
		else if(problemType == 2) {
			int[] numbers = new int[N];
			for (int i = 0; i < N; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
			boolean[] isused = new boolean[N+1];
			long cnt = 0;
			int tmpN = N;
			for (int i = 0; i < N; i++) {
				int num = numbers[i];
				int useCnt = 0;
				for (int j = 1; j < num; j++) {
					if(isused[j]) useCnt++;
				}
				cnt += (num - useCnt - 1) * factorial(--tmpN);
				isused[num] = true;
			}
			sb.append(cnt+1).append("\n");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
