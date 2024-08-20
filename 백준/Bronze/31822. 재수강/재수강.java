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
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        String repeatSubject = s.substring(0, 5);
        
        int N = Integer.parseInt(br.readLine());
        int resCnt = 0;
        for (int i = 0; i < N; i++) {
			s = br.readLine().substring(0, 5);
			if(s.equals(repeatSubject)) resCnt++;
		}
        sb.append(resCnt);
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
