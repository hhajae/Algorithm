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
		
		// 65 97 'A' 'a'
		String s = br.readLine();
		int[] alpha = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a') c -= 32;
			alpha[c-65] += 1;
		}
		int MAX = -1;
		int Max_cnt = 0;
		int max_ind = 0;
		for (int i = 0; i < alpha.length; i++) {
			if (alpha[i] > MAX) {
				MAX = alpha[i];
				max_ind = i;
			}
		}
		for (int i : alpha) {
			if (i == MAX) {
				Max_cnt++;
			}
		}
		if (Max_cnt > 1) {
			bw.write("?");
		}
		else {
			bw.write(String.format("%c", (max_ind + 65)));
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}