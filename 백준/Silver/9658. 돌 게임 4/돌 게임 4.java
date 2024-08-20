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
        if(N % 7 == 1 || N % 7 == 3) {
        	sb.append("CY");
        }
        else {
        	sb.append("SK");
        }
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
