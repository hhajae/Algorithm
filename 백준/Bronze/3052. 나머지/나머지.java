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
		
		int[] arr = new int[10];
		int[] fourtytwo = new int[42];
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			int n = (Integer.parseInt(br.readLine())) % 42;
			arr[i] = n;
			if (fourtytwo[n] != 1) fourtytwo[n] += 1;
		}
		for (int i = 0; i < fourtytwo.length; i++) {
			if (fourtytwo[i] == 1) cnt++;
		}
		bw.write(cnt + "\n");
		
		bw.flush();
		bw.close();
		br.close();	
	}
}