import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int A = Integer.parseInt(st.nextToken());
	    int B = Integer.parseInt(st.nextToken());
	    sb.append(B-A).append(" ").append(B);
	    
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}