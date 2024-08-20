import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            sb.append(name);
            int score = Integer.parseInt(st.nextToken());
            if(score >= 97) {
                sb.append(" A+\n");
            } else if(score >= 90) {
                sb.append(" A\n");
            } else if(score >= 87) {
                sb.append(" B+\n");
            } else if(score >= 80) {
                sb.append(" B\n");
            } else if(score >= 77) {
                sb.append(" C+\n");
            } else if(score >= 70) {
                sb.append(" C\n");
            } else if(score >= 67) {
                sb.append(" D+\n");
            } else if(score >= 60) {
                sb.append(" D\n");
            } else {
                sb.append(" F\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
