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
	    
	    String s = br.readLine();
	    int N = Integer.parseInt(s);
	    boolean swc = false;
	    int n = 0;
	    int ind = 0;
	    for (int i = 1; i < N; i++) {
	    	String tmp = i + "";
			n = i;
			for (int j = 0; j < tmp.length(); j++) {
				n += Integer.parseInt(tmp.charAt(j) + "");
			}
			if(n == N) {
				ind = i;
				swc = true;
				break;
			}
		}
	    if(swc) bw.write(ind + "\n");
	    else bw.write("0");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}