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
		int[] stairs = new int[N+1];
		
		if (N == 1) {
			bw.write(Integer.parseInt(br.readLine()) + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		if (N == 2) {
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());
			bw.write((a+b) + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		int total = 0;
		for (int i = 1; i < N+1; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
			total += stairs[i];
		}
		// input end //
		
		int[] D = new int[N+1];
		D[1] = stairs[1]; D[2] = stairs[2]; D[3] = stairs[3]; 
		
		for (int i = 4; i < N; i++) {
			D[i] = Math.min(D[i-2], D[i-3]) + stairs[i];
		}
		
		bw.write(total-Math.min(D[N-1], D[N-2]) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}