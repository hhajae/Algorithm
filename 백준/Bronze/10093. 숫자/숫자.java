import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		if (A > B) {
			long tmp = A;
			A = B;
			B = tmp;
		}
		if (A == B) bw.write("0\n");
		
		else {
		bw.write(B-A-1 + "\n");
		for(long i = A+1; i < B; i++) {
			bw.write(i + " ");
		}
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
