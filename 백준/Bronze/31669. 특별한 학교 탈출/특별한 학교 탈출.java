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
	    
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int N = Integer.parseInt(st.nextToken());
	    int M = Integer.parseInt(st.nextToken());
	    char[][] school = new char[N][M];
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
			for (int j = 0; j < M; j++) {
				school[i][j] = s.charAt(j);
			}
		}
	    int minClass = 0;
	    boolean swc = false;
	    for (int i = 0; i < M; i++) {
	    	swc = false;
			for (int j = 0; j < N; j++) {
				if(school[j][i] == 'O') {
					swc = true;
					break;
				}
			}
			if(!swc) {
				minClass = i;
				break;
			}
		}
	    if(swc) bw.write("ESCAPE FAILED");
	    else bw.write(++minClass + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}