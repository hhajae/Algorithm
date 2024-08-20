import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    int A = Integer.parseInt(br.readLine());
	    for (int i = 0; i < A; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(n).append(" ").append(n).append("\n");
	    }
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}	
}
	