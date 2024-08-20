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
		
		int N = Integer.parseInt(br.readLine());
		int S = 0;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			if(s.equals("all")) {
				S = 0;
				for (int j = 0; j < 20; j++) {
					S = S + (1 << j);
				}
				continue;
			}
			
			else if(s.equals("empty")) {
				S = 0;
				continue;
			}
			st = new StringTokenizer(s, " ");
			s = st.nextToken();
			int x = Integer.parseInt(st.nextToken());
			if (x > 20) continue;
			
			if(s.equals("add")) {
				int check = 1;
				for (int j = 1; j < x; j++) {
					check = check << 1;
				}
				if ((S & check) != 0) { // x가 있으면 1, 없으면 0
					continue;
				}
				else {
					S = S + check;
				}
			}
			
			else if(s.equals("remove")) {
				int check = 1;
				for (int j = 1; j < x; j++) {
					check = check << 1;
				}
				if ((S & check) == 0) { // x가 있으면 1, 없으면 0
					continue;
				}
				else {
					S = S - check;
				}
			}
			
			else if(s.equals("check")) {
				int check = 1;
				for (int j = 1; j < x; j++) {
					check = check << 1;
				}
				if ((S & check) != 0) { // x가 있으면 1, 없으면 0
					bw.write(1 + "\n");
					continue;
				}
				bw.write(0 + "\n");
			}
			
			else if(s.equals("toggle")) {
				int check = 1;
				for (int j = 1; j < x; j++) {
					check = check << 1;
				}
				if ((S & check) != 0) { // x가 있으면 1, 없으면 0
					S = S - check;
				}
				else
					S = S + check;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}