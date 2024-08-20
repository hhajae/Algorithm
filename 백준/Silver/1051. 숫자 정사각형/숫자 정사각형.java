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
	    int[][] squares = new int[N][M];
	    for (int i = 0; i < N; i++) {
	    	s = br.readLine();
			for (int j = 0; j < M; j++) {
				squares[i][j] = s.charAt(j) - '0';
			}
		}
	    /// input end ///
	    int curSize = Math.min(N, M);
	    while(curSize > 0) {
	    	for (int i = 0; i < N - curSize + 1; i++) {
				for (int j = 0; j < M - curSize + 1; j++) {
					int spot = squares[i][j];
					if(spot != squares[i+curSize-1][j]) continue;
					if(spot != squares[i][j+curSize-1]) continue;
					if(spot != squares[i+curSize-1][j+curSize-1]) continue;
					System.out.println(curSize * curSize);
					System.exit(0);
				}
			}
	    	curSize--;
	    }
	}
}