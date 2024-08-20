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
        
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        s = br.readLine();
        st = new StringTokenizer(s, " ");
        long[] accSum = new long[N+1];
        for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			accSum[i] = accSum[i-1] + n;
		}
        if(accSum[N] < S) {
        	bw.write("0"); bw.flush(); bw.close(); br.close(); return;
        }
        int minRes = Integer.MAX_VALUE;
        int pivot = N;
        int move = N-1;
        while(true) {
        	long val = accSum[pivot] - accSum[move];
        	if(val >= S) {
        		minRes = Math.min(minRes, pivot-move);
        		pivot--;
        	}
        	else if(val < S) {
        		move--;
        	}
        	if(pivot == move || move < 0 || pivot < 0) break; 
        }
        
        sb.append(minRes);
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
