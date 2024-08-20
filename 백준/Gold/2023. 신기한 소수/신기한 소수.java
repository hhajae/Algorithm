import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[] pos = {1, 3, 7, 9};
	private static void makeIsPrime(int n, int cnt) {
		if (cnt == N-1) {
			System.out.println(n);
			return;
		}

		for (int i = 0; i < 4; i++) {
			boolean isprime = true;
			int n_ = n * 10 + pos[i];
			for (int j = 2; j <= Math.sqrt(n_); j++) {
				if (n_ % j == 0) {
					isprime = false;
					break;
				}
			}
			if(isprime) {
				makeIsPrime(n_, cnt+1);
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		int[] start = {2, 3, 5, 7};
		for (int i = 0; i < 4; i++) {
			makeIsPrime(start[i], 0);
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}