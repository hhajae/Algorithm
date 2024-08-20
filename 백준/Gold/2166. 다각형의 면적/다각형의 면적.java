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
	    
	    int N = Integer.parseInt(br.readLine());
	    int[][] polys = new int[N][2];
	    for (int i = 0; i < N; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			polys[i][0] = x; polys[i][1] = y;
		}
	    /// input end ///
	    double red = 0;
	    double blue = 0;
	    for (int i = 0; i < N-1; i++) {
			long mul = (long)polys[i][0] * (long)polys[i+1][1];
			red += (double)mul;
		}
	    red += (long)polys[N-1][0] * (long)polys[0][1];
	    for (int i = 0; i < N-1; i++) {
	    	long mul = (long)polys[i][1] * (long)polys[i+1][0];
	    	blue += (double)mul;
	    }
	    blue += (long)polys[N-1][1] * (long)polys[0][0];
	    double res = Math.abs(red - blue) / 2.0;
	    System.out.printf("%.1f", res);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
