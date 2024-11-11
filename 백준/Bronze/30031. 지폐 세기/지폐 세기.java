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
        int sum = 0;
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            st = new StringTokenizer(s, " ");
            int size = Integer.parseInt(st.nextToken());
            int money = switch (size) {
                case 136 -> 1000;
                case 142 -> 5000;
                case 148 -> 10000;
                case 154 -> 50000;
                default -> 0;
            };
            sum += money;
        }
        sb.append(sum);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
