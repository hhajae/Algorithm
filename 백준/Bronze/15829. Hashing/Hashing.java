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
	    
	    int L = Integer.parseInt(br.readLine());
	    String s = br.readLine();
	    long sum = 0;
	    for (int i = 0; i < L; i++) {
			long n = (int)s.charAt(i) - 96;
			for (int j = 1; j <= i; j++) {
				n *= 31;
				n %= 1234567891;
			}
			sum = (sum % 1234567891 + n) % 1234567891;
		}
	    bw.write(sum + "\n");
	    
		bw.flush();
	    bw.close();
	    br.close();
	}
}