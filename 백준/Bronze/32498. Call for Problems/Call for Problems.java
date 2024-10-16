import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int n1 = Integer.parseInt(br.readLine());
            if(n1 % 2 == 1) cnt++;
        }
        sb.append(cnt);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
