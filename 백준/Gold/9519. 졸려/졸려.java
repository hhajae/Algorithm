import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	private static String Rkaqkr(String s) {
		StringBuilder sb = new StringBuilder();
		int L = s.length();
		for (int i = 0; i < L / 2; i++) {
			sb.append(s.charAt(i)).append(s.charAt(L-1-i));
		}
		if (L % 2 == 1) sb.append(s.charAt(L/2));
		return sb.toString();
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		int X = Integer.parseInt(br.readLine());
		String s = br.readLine();
		int L = s.length();
		String res = s;
		int cir_cnt = 0;
		for (int i = 0; i < L; i++) {
			res = Rkaqkr(res);
			cir_cnt++;
			if(res.equals(s)) break;
		}
		for (int i = 0; i < cir_cnt - (X % cir_cnt); i++) {
			res = Rkaqkr(res);
		}
		bw.write(res);
		
		bw.flush();
		br.close();
		bw.close();
	}
}