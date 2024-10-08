import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int oddCnt = 0;
        int evenCnt = 0;
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n % 2 == 0) evenCnt++;
            else oddCnt++;
        }
        if(evenCnt > oddCnt) sb.append("Happy");
        else sb.append("Sad");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
