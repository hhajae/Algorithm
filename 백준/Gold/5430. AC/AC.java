import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case < T+1; test_case++) {
			String s = br.readLine();
			int N = Integer.parseInt(br.readLine());
			String arr_s = br.readLine();
			arr_s = arr_s.substring(1, arr_s.length()-1);
			st = new StringTokenizer(arr_s, ",");
			Deque<Integer> deq = new LinkedList<>();
			while(st.hasMoreTokens()) {
				deq.add(Integer.parseInt(st.nextToken()));
			}
			boolean swc = false;
			boolean start_point = true; // true면 앞에서부터 false면 뒤에서부터
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) == 'R') {
					start_point = !start_point;
				}
				else { // 'D'
					if (deq.isEmpty()) {
						swc = true;
						break;
					}
					if(start_point) { // 앞에서부터
						deq.pollFirst();
					}
					else {
						deq.pollLast();
					}
				}
			}
			if(swc) {
				sb.append("error");
			}
			else {
				if (start_point) {
					sb.append(deq.toString().replace(" ", ""));	
				}
				else {
					sb.append("[");
					while(!deq.isEmpty()) {
						if (deq.size() != 1) {
							sb.append(deq.pollLast());
							sb.append(",");	
						}
						else {
							sb.append(deq.pollLast());
						}
					}
					sb.append("]");
				}
			}
			if (test_case != T)
				sb.append("\n");
		}
        bw.write(sb.toString() + "");
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}