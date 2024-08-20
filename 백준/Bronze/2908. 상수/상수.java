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
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		A = (A % 10) * 100 + ((A % 100) / 10) * 10 + (A / 100);
		B = (B % 10) * 100 + ((B % 100) / 10) * 10 + (B / 100);
		
		bw.write(((A>B)?A:B) + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
