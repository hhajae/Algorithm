import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		String s = br.readLine();
		int n1 = Integer.parseInt(s);
		s = br.readLine();
		int n2 = Integer.parseInt(s);
		
		int A = n1 * (n2 % 10);
		int B = n1 * ((n2 % 100)/10);
		int C = n1 * (n2/100);
		System.out.println(A);
		System.out.println(B);
		System.out.println(C);
		System.out.println(n1*n2);
	    }
}
