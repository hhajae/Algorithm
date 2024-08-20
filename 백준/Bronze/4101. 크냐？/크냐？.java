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
	    
	    while(true) {
	    	String s = br.readLine();
	    	st = new StringTokenizer(s, " ");
	    	int a = Integer.parseInt(st.nextToken());
	    	int b = Integer.parseInt(st.nextToken());
	    	if(a == 0 && b == 0) break;
	    	sb.append(a > b ? "Yes\n" : "No\n");
	    }
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
