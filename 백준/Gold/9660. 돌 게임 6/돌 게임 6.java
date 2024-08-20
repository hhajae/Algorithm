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
        
        long N = Long.parseLong(br.readLine());
        if(N == 1 || (3 <= N && N <= 6)) {
        	bw.write("SK"); bw.flush(); bw.close(); br.close(); return;
        }
        if(N == 2 || N == 7) {
        	bw.write("CY"); bw.flush(); bw.close(); br.close(); return;
        }
        if(N % 7 == 1 || N % 7 == 3 || N % 7 == 4 || N % 7 == 5 || N % 7 == 6) {
        	sb.append("SK");
        }
        else {
        	sb.append("CY");
        }
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
