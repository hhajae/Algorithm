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
        if((A+B) % 2 != 0 || B > A) {
            sb.append("-1");
        } else {
            sb.append((A+B)/2).append(" ").append((A-B)/2);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
