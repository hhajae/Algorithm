import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        st = new StringTokenizer(s);
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int sum = A+B;
        int N = Integer.parseInt(br.readLine()) * 2;
        if(sum >= N) {
            sb.append(sum - N);
        } else {
            sb.append(sum);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
