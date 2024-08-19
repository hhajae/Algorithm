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
        
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Deque<Integer> deq = new LinkedList<>();
        
        for (int i = 1; i < N+1; i++) {
			deq.add(i);
		}
        s = br.readLine();
        st = new StringTokenizer(s, " ");
        int res_cnt = 0;
        for (int i = 0; i < M; i++) {
        	int n = Integer.parseInt(st.nextToken());
        	if (deq.getFirst() == n) {
        		deq.pollFirst();
        		continue;
        	}
        	Object[] arr = deq.toArray();
        	int cnt = 0;
        	for (int j = 1; j < arr.length; j++) {
				if ((int)arr[j] == n) {
					cnt = j;
					break;
				}
			}
        	if (cnt <= arr.length / 2) {
        		res_cnt += cnt;
        		for (int j = 0; j < cnt; j++) {
					deq.addLast(deq.pollFirst());
				}
        		deq.pollFirst();
        	}
        	else {
        		res_cnt += (arr.length-1) - cnt + 1;
        		for (int j = 0; j < arr.length-cnt-1; j++) {
					deq.addFirst(deq.pollLast());
				}
        		deq.pollLast();
        	}
		}
        bw.write(res_cnt + "");
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}