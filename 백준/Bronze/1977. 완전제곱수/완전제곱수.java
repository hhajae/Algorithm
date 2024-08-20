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
	    
	    int M = Integer.parseInt(br.readLine());
	    int N = Integer.parseInt(br.readLine());
	    int res = 0;
	    int sum = 0;
	    for (int i = M; i <= N; i++) {
			int root = (int)Math.sqrt(i);
			int rootpow = root * root;
			if (rootpow == i) {
				if(res == 0) res = i;
				sum += i;
			}
		}
	    if(res == 0) bw.write("-1\n");
	    else {
	    	bw.write(sum + "\n");
		    bw.write(res + "\n");	
	    }
	    
	    
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}
