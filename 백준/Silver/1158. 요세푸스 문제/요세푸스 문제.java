import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int N = Integer.parseInt(st.nextToken());
	    int K = Integer.parseInt(st.nextToken());
	    
	    Queue<Integer> que = new LinkedList<>();
	    int[] box = new int[N];
	    
	    for (int i = 1; i < N+1; i++) {
			que.add(i);
		}

	    int cnt = 0;
	    int box_cnt = 0;
	    while(que.size() != 1) {
	    	cnt++;
	    	if (cnt % K == 0) {
	    		box[box_cnt++] = que.poll();
	    		continue;
	    	}
	    	que.add(que.poll());
	    }
	    box[N-1] = que.poll();
	    
	    StringBuilder sb = new StringBuilder();
	    sb.append("<");
	    for (int i = 0; i < N-1; i++) {
	    	sb.append(box[i]);
	    	sb.append(", ");
		}
	    sb.append(box[N-1]);
	    sb.append(">");
	    bw.write(sb.toString() + "");
	      
		bw.flush();
	    bw.close();
	    br.close();
	}
}