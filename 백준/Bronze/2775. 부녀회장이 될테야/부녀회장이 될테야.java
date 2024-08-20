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
	    
	    int[][] apart = new int[15][15];
	    for (int i = 0; i < 15; i++) {
	    	apart[i][1] = 1;
			apart[0][i] = i;
		}
	    for (int i = 1; i < 15; i++) {
			for (int j = 2; j < 15; j++) {
				apart[i][j] = apart[i][j-1] + apart[i-1][j];
			}
		}
	    
	    int T = Integer.parseInt(br.readLine());
	    for (int i = 0; i < T; i++) {
	    	int k = Integer.parseInt(br.readLine());
	    	int n = Integer.parseInt(br.readLine());
	    	bw.write(apart[k][n] + "\n");
		}
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}