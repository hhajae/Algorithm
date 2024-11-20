import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        while(true) {
            String s = br.readLine();
            if("0 0".equals(s)) {
                break;
            }

            st = new StringTokenizer(s, " ");
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
