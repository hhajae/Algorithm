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
	    
	    int N = Integer.parseInt(br.readLine());
	    int[] tiles = new int[1001];
	    tiles[1] = 1; tiles[2] = 3;
	    for (int i = 3; i < N+1; i++) {
			tiles[i] = (tiles[i-1] + 2 * tiles[i-2]) % 10007;
		}
	    bw.write(tiles[N] + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}