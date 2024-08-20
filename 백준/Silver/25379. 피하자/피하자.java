import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		String s = br.readLine();
//		sb = (StringBuilder)br.readLine();
		
		if (s.length() == 1) {
			bw.write(0 + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		st = new StringTokenizer(s, " ");
		boolean[] barr = new boolean[N];
		for (int i = 0; i < N; i++) {
			barr[i] = (Long.parseLong(st.nextToken())) % 2 == 0;
		}
		
		long res_even1 = 0, res_odd1 = 0, res_even2 = 0, res_odd2 = 0;
		long cnt_even1 = 0, cnt_odd1 = 0, cnt_even2 = 0, cnt_odd2 = 0;

		for (int i = 0; i < N; i++) {
			if (barr[i]) {
				res_even1 += cnt_even1;
				cnt_odd1++;
			}
			else {
				res_odd1 += cnt_odd1;
				cnt_even1++;
			}
			if (barr[N-i-1]) {
				res_even2 += cnt_even2;
				cnt_odd2++;
			}
			else {
				res_odd2 += cnt_odd2;
				cnt_even2++;	
			}
		}
		long min1 = Math.min(res_even1, res_even2);
		long min2 = Math.min(res_odd1, res_odd2);
		if (min1 < min2)
			bw.write(min1 + "\n");
		else
			bw.write(min2 + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
