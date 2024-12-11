import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

		List<BigInteger> lst = new ArrayList<>();
		lst.add(BigInteger.ONE);
		lst.add(BigInteger.ONE);
		lst.add(new BigInteger("2"));
		for (int i = 3; i < 36; i++) {
			BigInteger sum = new BigInteger("0");
			for(int j = 0; j < i; j++) {
				sum = sum.add(lst.get(j).multiply(lst.get(i-j-1)));
			}
			lst.add(sum);
		}
		int N = Integer.parseInt(br.readLine());
		sb.append(lst.get(N));

		bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
