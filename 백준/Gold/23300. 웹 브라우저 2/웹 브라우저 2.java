import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		int[] A = new int[N+1];
		Stack<Integer> back = new Stack<>();
		Stack<Integer> forward = new Stack<>();
		int cur = -1;
		boolean first_visit = true;
		
		for (int i = 0; i < Q; i++) {
			s = br.readLine();
			if (s.equals("B")) {
				if (back.isEmpty())
					continue;
				forward.add(cur);
				cur = back.pop();
				continue;
			}
			else if (s.equals("F")) {
				if (forward.isEmpty()) {
					continue;
				}
				back.add(cur);
				cur = forward.pop();
				continue;
			}
			else if (s.equals("C")) {
				if (back.isEmpty()) continue;
				Object[] arr_c = back.toArray();
				back.clear();
				int cmp = (int)arr_c[0];
				for (int j = 1; j < arr_c.length; j++) {
					if (cmp != (int)arr_c[j]) {
						back.add(cmp);
						cmp = (int)arr_c[j];
					}
					else {
						continue;
					}
				}
				back.add((int)arr_c[arr_c.length-1]);
				continue;
			}
			// A i //
			st = new StringTokenizer(s, " ");
			String tmp_s = st.nextToken();
			int web = Integer.parseInt(st.nextToken());
			A[web]++; forward.clear();
			if (first_visit) {
				cur = web;
				first_visit = false;
			}
			else {
				back.add(cur);
				cur = web;
			}
		}
		
		bw.write(cur + "\n");
		boolean b_swc = false, f_swc = false;
		while(!back.isEmpty()) {
			b_swc = true;
			int out = back.pop();
			bw.write(out + " ");
		}
		if(!b_swc) bw.write(-1 + "");
		bw.write("\n");
		while(!forward.isEmpty()) {
			f_swc = true;
			bw.write(forward.pop() + " ");
		}
		if(!f_swc) bw.write(-1 + "");
		
		bw.flush();
		bw.close();
		br.close();
	}
}