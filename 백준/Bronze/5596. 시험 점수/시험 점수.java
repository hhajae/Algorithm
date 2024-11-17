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
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        
        s = br.readLine();
        st = new StringTokenizer(s, " ");
        int sum1 = 0;
        for (int i = 0; i < 4; i++) {
            sum1 += Integer.parseInt(st.nextToken());
        }
        int res = Math.max(sum1, sum);
        sb.append(res);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
