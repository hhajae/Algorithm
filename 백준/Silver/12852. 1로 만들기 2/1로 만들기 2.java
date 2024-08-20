import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		if(N <= 3) {
			if(N == 1) bw.write("0\n1");
			else {
				bw.write("1\n");
				bw.write(N + " 1");
			}
			bw.flush();
			bw.close();
			br.close();
			return;
		}
		
		int[] D = new int[N+1];
		D[1] = 0; D[2] = 1; D[3] = 1;
		
		int[] streak = new int[N+1];
		streak[1] = 1; streak[2] = 1; streak[3] = 1;
		for (int i = 4; i < N+1; i++) {
			int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
			if(i % 3 == 0) a = D[i/3] + 1;
			if(i % 2 == 0) b = D[i/2] + 1;
			c = D[i-1] + 1;
			D[i] = Math.min(a, Math.min(b, c));
			if(D[i] == a) {
				streak[i] = i/3;
			}
			else if(D[i] == b) {
				streak[i] = i/2;
			}
			else streak[i] = i-1;
		}
		bw.write(D[N] + "\n");
		bw.write(N + " ");
		int stre = N;
		while(stre > 1) {
			bw.write(streak[stre] + " ");
			stre = streak[stre];
		}
		
		
		bw.flush();
		bw.close();
		br.close();
	}
}
