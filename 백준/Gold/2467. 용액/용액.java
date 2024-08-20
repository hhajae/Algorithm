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
        int[] fluids = new int[N];
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        for (int i = 0; i < N; i++) {
			fluids[i] = Integer.parseInt(st.nextToken());
		}
        /// input end ///
        int start = 0;
        int end = N-1;
        int cur = fluids[start] + fluids[end];
        int cur_a = start;
        int cur_b = end;
        while(start < end) {
        	int sum = fluids[start] + fluids[end];
        	if(sum == 0) {
        		cur = sum;
        		cur_a = start;
        		cur_b = end;
        		break;	
        	}
        	if(Math.abs(cur) > Math.abs(sum)) {
        		cur = sum;
        		cur_a = start;
        		cur_b = end;
        	}
        	if(sum < 0) {
        		start++;
        	} 
        	else if(sum > 0) {
        		end--;
        	}
        }
        sb.append(fluids[cur_a]).append(" ").append(fluids[cur_b]);
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
