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
		int cnt = 0;
		int cnt_ = 0;
		if ((s.length() == 1) && (s.charAt(0)) == ' ') cnt_ = 1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ((s.length() != 1) && (i == 0) && (c == ' ') && (s.charAt(1) == ' ')) cnt_ = 1;
			if (((i == 0) && (c ==  ' ')) || ((i == (s.length()-1)) && (c == ' '))) continue;
			if (c == ' ') cnt++;
		}
		if (cnt_ == 1) bw.write(0 + "\n");
		else bw.write(cnt+1 + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
