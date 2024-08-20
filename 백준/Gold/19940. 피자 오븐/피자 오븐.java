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
	    
	    int T = Integer.parseInt(br.readLine());
	    for (int test_case = 0; test_case < T; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int[] oven = new int[5];
			
			// +60 +10 -10 +1 -1
			oven[0] += N / 60;
			N %= 60;
			int mod = N % 10;
			if(N <= 35) {
				if(mod <= 5) {
					oven[1] += N / 10;
					oven[3] += mod;
				}
				else {
					oven[1] += N / 10 + 1;
					oven[4] += 10 - mod;
				}
			}
			else { // > 35
				oven[0] += 1;
				if(mod < 5) {
					oven[2] += 6 - N/10;
					oven[3] += mod;
				}
				else {
					oven[2] += 6 - (N/10 + 1);
					oven[4] += 10 - mod;
				}
			}
			
			for (int i = 0; i < 5; i++) {
				bw.write(oven[i] + " ");
			}
			bw.newLine();
		}
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}