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
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int[] primes = new int[100001];
		int primeInd = -1;
		boolean[] checkPrimes = new boolean[100001];
		for (int i = 2; i < 100001; i++) {
			if(checkPrimes[i]) continue;
			for (int j = i; j < 100001; j+=i) {
				checkPrimes[j] = true;
			}
			primes[++primeInd] = i;
		}
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int underPrime = 0;
		for (int i = A; i <= B; i++) {
//			System.out.println(i);
			int cur = i;
			int primeCnt = 0;
			outer: while(true) {
				for (int j = 0; j < primeInd+1; j++) {
					if(cur % primes[j] != 0) continue;
					cur /= primes[j];
					primeCnt++;
					if(cur == 1) break outer;
					continue outer;
				}
			}
			for (int j = 0; j < primeInd+1; j++) {
				if(primeCnt == primes[j]) {
					underPrime++;
					break;
				}
				if(primeCnt < primes[j]) break;
			}
		}
		bw.write(underPrime + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}