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
        int[] menu = new int[N+1];
        for (int i = 1; i < N+1; i++) {
			menu[i] = Integer.parseInt(br.readLine());
		}
        int M = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < M; i++) {
			int n = Integer.parseInt(br.readLine());
			sum += menu[n];
		}
        sb.append(sum);
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
