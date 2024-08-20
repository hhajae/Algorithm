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
        int[] A = new int[N];
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
        s = br.readLine();
        st = new StringTokenizer(s, " ");
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        /// input end ///
        long persons = 0;
        for (int i = 0; i < N; i++) {
			persons++;
			A[i] = A[i] - B;
			if (A[i] > 0) {
				if(A[i] % C == 0) persons += A[i] / C;
				else persons += A[i] / C + 1;
			}
		}
        bw.write(persons + "\n");
        
		bw.flush();
	    bw.close();
	    br.close();
	}
}