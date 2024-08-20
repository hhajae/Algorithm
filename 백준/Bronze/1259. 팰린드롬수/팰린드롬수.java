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
	    
	    while(true) {
	    	String s = br.readLine();
	    	if (s.equals("0")) break;
	    	boolean swc = false;
	    	for (int i = 0; i < s.length()/2; i++) {
				if(s.charAt(i) != s.charAt(s.length()-1-i)) {
					bw.write("no\n");
					swc = true;
					break;
				}
			}
	    	if(!swc) bw.write("yes\n");
	    }
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}