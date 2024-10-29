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
        for(int i = 1; i <= N; i++) {
            sum += i;
        }
        sb.append(sum).append("\n");
        sb.append(sum*sum).append("\n");
        sb.append(sum*sum);
        

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
