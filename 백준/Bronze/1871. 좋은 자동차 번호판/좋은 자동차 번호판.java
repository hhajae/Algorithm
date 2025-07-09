import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            st = new StringTokenizer(s, "-");
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            int A = (str.charAt(0) - 65) * 26 * 26;
            int B = (str.charAt(1) - 65) * 26;
            int C = (str.charAt(2) - 65);
            int first = A+B+C;

            if(Math.abs(first - num) <= 100) {
                sb.append("nice\n");
            } else {
                sb.append("not nice\n");
            }

        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}