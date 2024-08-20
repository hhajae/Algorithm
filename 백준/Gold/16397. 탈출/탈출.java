import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
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
	    int T = Integer.parseInt(st.nextToken());
	    int G = Integer.parseInt(st.nextToken());
	    
	    Queue<Integer> que =new ArrayDeque<>();
	    boolean[] isvisited = new boolean[100000];
	    que.offer(N);
	    isvisited[N] = true;
	    int minRes = Integer.MAX_VALUE;
	    int depthCnt = 0;
	    while(!que.isEmpty()) {
	    	int queSize = que.size();
	    	if(depthCnt > T) break; 
	    	depthCnt++;
	    	while(queSize-- > 0) {
	    		int cur = que.poll();
	    		if(cur == G) {
	    			minRes = depthCnt;
	    			que.clear();
	    			break;
	    		}
	    		if((cur*2) < 100000 && cur != 0) {
	    			int tmpN = cur * 2;
	    			if (tmpN < 10) tmpN--;
	    			else if (tmpN < 100) {
	    				if(tmpN / 10 == 1) tmpN = tmpN % 10;
	    				else tmpN = tmpN - 10;
	    			}
	    			else if (tmpN < 1000) {
	    				if(tmpN / 100 == 1) tmpN = tmpN % 100;
	    				else tmpN = tmpN - 100;
	    			}
	    			else if (tmpN < 10000) {
	    				if(tmpN / 1000 == 1) tmpN = tmpN % 1000;
	    				else tmpN = tmpN - 1000;
	    			}
	    			else if (tmpN < 100000) {
	    				if(tmpN / 10000 == 1) tmpN = tmpN % 10000;
	    				else tmpN = tmpN - 10000;
	    			}
	    			if(!isvisited[tmpN]) {
	    				que.offer(tmpN);
	    				isvisited[tmpN] = true;
	    			}
	    		}
	    		if(cur < 99999 && cur < G) {
	    			if(!isvisited[cur+1]) {
	    				que.offer(cur+1);
	    				isvisited[cur+1] = true;
	    			}
	    		}
	    	}
	    }
	    if(minRes == Integer.MAX_VALUE) bw.write("ANG");
	    else bw.write((minRes-1) + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}

}
