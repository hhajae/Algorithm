import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int resSum = 0;
        int accSum = 0;
        for (int i = 0; i < M - 2; i++) {
        	if(S.charAt(i) == 'O') continue;
        	if(S.charAt(i+1) == 'O' && S.charAt(i+2) == 'I') {
        		accSum++;
        		if(accSum >= N) {
        			resSum++;
        		}
        	}
        	else {
        		accSum = 0;
        	}
        }
        bw.write(resSum + "\n");
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}