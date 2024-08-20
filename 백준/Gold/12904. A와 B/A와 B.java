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
	    
	    String S = br.readLine();
	    String T = br.readLine();
	    while(T.length() > S.length()) {
	    	char c = T.charAt(T.length()-1);
	    	if (c == 'A') {
	    		T = T.substring(0, T.length()-1);
	    	}
	    	else if (c == 'B') {
	    		StringBuilder sb = new StringBuilder();
	    		T = T.substring(0, T.length() - 1);
	    		for (int i = T.length()-1; i >= 0; i--) {
					sb.append(T.charAt(i));
				}
	    		T = sb.toString();
	    	}
	    }
	    if(T.equals(S)) bw.write("1");
	    else bw.write("0");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}