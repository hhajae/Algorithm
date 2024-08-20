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
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        int iter = 122;
        int[] prefixSum = new int[iter];
        prefixSum[1] = 1; prefixSum[2] = 4;
        int smallSum = 3;
        int largeSum = 3;
        for (int i = 3; i < iter; i++) {
        	largeSum += smallSum;
        	smallSum++;
			prefixSum[i] = prefixSum[i-1] + largeSum;
		}
        int[] D = new int[N+1];
        Arrays.fill(D, Integer.MAX_VALUE);
        outer: for (int i = 1; i < N+1; i++) {
        	for (int j = 1; j < iter; j++) {
				if(prefixSum[j] == i) {
					D[i] = 1;
					continue outer;
				}
				if(prefixSum[j] > i) {
					continue outer;
				}
				D[i] = Math.min(D[i], D[i-prefixSum[j]] + 1);
			}
		}
        sb.append(D[N]);
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
