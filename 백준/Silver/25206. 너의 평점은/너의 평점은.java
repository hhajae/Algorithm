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
		
		double sum = 0.0;
		double score_sum = 0.0;
		double avg = 0.0;
		for (int i = 0; i < 20; i++) {
			String s = br.readLine();
			st = new StringTokenizer(s, " ");
			String subject = st.nextToken();
			double score = Double.parseDouble(st.nextToken());
			score_sum += score;
			String grade = st.nextToken();
			
			switch(grade) {
			case("P"):
				score_sum -= score;
				break;
			case("F"):
				break;
			case("A+"):
				sum += score * 4.5;
				break;
			case("A0"):
				sum += score * 4.0;
				break;
			case("B+"):
				sum += score * 3.5;
				break;
			case("B0"):
				sum += score * 3.0;
				break;
			case("C+"):
				sum += score * 2.5;
				break;
			case("C0"):
				sum += score * 2.0;
				break;
			case("D+"):
				sum += score * 1.5;
				break;
			case("D0"):
				sum += score * 1.0;
				break;
			default:
				bw.write("default\n");
				break;
			}
			
		}
		avg = sum / score_sum;
		bw.write(avg + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}