import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int H = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        sb.append(H*60 + M);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
