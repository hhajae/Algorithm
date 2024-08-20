import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    PriorityQueue<Long> cards = new PriorityQueue<>();
	    for (int i = 0; i < n; i++) {
			cards.offer(Long.parseLong(st.nextToken()));
		}
	    /// input end ///
	    while(m-- > 0) {
	    	long x = cards.poll();
	    	long y = cards.poll();
	    	cards.offer(x+y); cards.offer(x+y);
	    }
	    long res = 0;
	    while(!cards.isEmpty()) {
	    	res += cards.poll();
	    }
	    sb.append(res);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
