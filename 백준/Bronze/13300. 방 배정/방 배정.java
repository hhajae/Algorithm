import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		String s = br.readLine();
		st = new StringTokenizer(s, " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] student = new int[7][2];
		int room = 0;
		
		for (int i = 0; i < N; i++) {
			s = br.readLine();
			st = new StringTokenizer(s, " ");
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			
			student[grade][sex]++;
		}
		
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				if (student[i][j] == 0) continue;
				if (student[i][j] % K == 0)
					room += (student[i][j] / K);
				else
					room += (student[i][j] / K) + 1;
			}
		}
		bw.write(room + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}