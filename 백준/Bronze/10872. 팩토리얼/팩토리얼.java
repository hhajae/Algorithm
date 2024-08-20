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
		int[] arr = {1, 1, 2, 6, 24, 120, 720, 5040, 40320,
				362880, 3628800, 39916800, 479001600}; 
		bw.write(arr[N] + "\n");
		
		bw.flush();
		br.close();
		bw.close();
	}
}
