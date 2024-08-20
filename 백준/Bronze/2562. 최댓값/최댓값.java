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
		
		int max = -1;
		int ind = 0;
		for (int i = 1; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n > max) {
				max = n;
				ind = i;
			}
		}
		bw.write(max + "\n" + ind);
		
		bw.flush();
		bw.close();
		br.close();	
	}
}