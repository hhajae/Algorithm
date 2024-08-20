import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    int N = Integer.parseInt(br.readLine());
	    List<Integer> primes = new ArrayList<>();
	    int resCnt = 0;
	    boolean[] notPrimes = new boolean[5000001];
	    for (int i = 2; i < 5000001; i++) {
	    	if(notPrimes[i]) continue;
	    	for (int j = i; j < 5000001; j += i) {
				notPrimes[j] = true;
			}
	    	primes.add(i);
		}
	    List<Integer> sums = new ArrayList<>();
	    sums.add(0); sums.add(2);
	    
	    for (int i = 2; i < primes.size(); i++) {
			sums.add(primes.get(i-1) + sums.get(i-1));
		}
	    int start = 0;
	    outer : while(true) {
	    	for (int i = start + 1; i < sums.size(); i++) {
				int dist = sums.get(i) - sums.get(start);
				if(dist > N) {
					if(i == start + 1) break outer;
					start++;
					continue outer;
				}
				if(dist == N) {
					resCnt++;
				}
			}
	    }
	    sb.append(resCnt);
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
