import java.io.*;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());

		if(A+B+C != 180) sb.append("Error");
		else if(A == 60 && B == 60 && C == 60) sb.append("Equilateral");
		else if((A == B && B != C) || (A == C && C != B) || (B == C && C != A)) sb.append("Isosceles");
		else sb.append("Scalene");

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}

}
