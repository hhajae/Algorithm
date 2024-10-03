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
        String result = (N-2) % 7 == 0 ? "1" : "0";
        sb.append(result);
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
