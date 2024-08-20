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
		
		String[] inS = new String[5];
		int Mlen = 0;
		for (int i = 0; i < 5; i++) {
			String s = br.readLine();
			inS[i] = s;
			if (s.length() > Mlen) {
				Mlen = s.length();
			}
		}
		char[][] A = new char[5][Mlen];
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < inS[i].length(); j++) {
				A[i][j] = inS[i].charAt(j);
			}
			if (inS[i].length() != Mlen) {
				for (int k = inS[i].length(); k < Mlen; k++) {
					A[i][k] = '#';
				}
			}
		}
		
		for (int i = 0; i < Mlen; i++) {
			for (int j = 0; j < 5; j++) {
				if (A[j][i] == '#') {
					continue;
				}
				bw.write(A[j][i] + "");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}