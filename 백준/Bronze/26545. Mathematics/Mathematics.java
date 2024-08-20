import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    int A = Integer.parseInt(br.readLine());
	    int result = 0;
	    for (int i = 0; i < A; i++) {
			int n = Integer.parseInt(br.readLine());
			result += n;
		}
	    sb.append(result);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}