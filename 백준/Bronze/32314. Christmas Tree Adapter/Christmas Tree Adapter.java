import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int A = Integer.parseInt(br.readLine());
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int W = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        if(W/V >= A) sb.append(1);
        else sb.append(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
