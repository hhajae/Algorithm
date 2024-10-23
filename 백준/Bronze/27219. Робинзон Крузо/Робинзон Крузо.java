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
        while(true) {
            if(N >= 5) {
                sb.append("V");
                N -= 5;
                continue;
            }
            break;
        }
        for (int i = 0; i < N; i++) {
            sb.append("I");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
