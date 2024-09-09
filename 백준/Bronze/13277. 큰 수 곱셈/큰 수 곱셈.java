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
        st = new StringTokenizer(s, " ");
        BigInteger b1 = new BigInteger(st.nextToken());
        BigInteger b2 = new BigInteger(st.nextToken());
        sb.append(b1.multiply(b2));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
