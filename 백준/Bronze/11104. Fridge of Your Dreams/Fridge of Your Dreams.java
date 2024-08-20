import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    int T = Integer.parseInt(br.readLine());
	    for (int tc = 0; tc < T; tc++) {
			 String s = br.readLine();
			 int sum = 0;
			 int bit = 1;
			 for (int i = 23; i >= 0; i--) {
				int b = s.charAt(i) - '0';
				bit *= 2;
				if(i == 23) bit = 1;
				if(b == 0) continue;
				sum += bit;
			}
			 sb.append(sum).append("\n");
		}
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}