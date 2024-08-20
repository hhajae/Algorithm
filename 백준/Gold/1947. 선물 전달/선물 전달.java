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
	    int mod = 1_000_000_000;
	    long[] D = new long[N+1];
	    D[1] = 0;
	    if(N == 1) {
	    	bw.write("0"); bw.flush(); br.close(); bw.close(); return;
	    }
	    if(N == 2) {
	    	bw.write("1"); bw.flush(); br.close(); bw.close(); return;
	    }
	    D[2] = 1; D[3] = 2;
	    for (int i = 4; i < N+1; i++) {
	    	if((i-1) % 2 == 1) {
	    		D[i] = (D[i-1] * (i-1) + D[i-1] + 1) % mod;
	    	}
	    	else {
	    		D[i] = (D[i-1] * (i-1) + D[i-1] - 1) % mod;
	    	}
		}
	    sb.append(D[N]);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
