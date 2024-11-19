import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N1 = Integer.parseInt(br.readLine());
        int N2 = Integer.parseInt(br.readLine());
        int N3 = Integer.parseInt(br.readLine());
        int N4 = Integer.parseInt(br.readLine());
        int N5 = Integer.parseInt(br.readLine());
        
        int minBurger = Math.min(N1, Math.min(N2, N3));
        int minBevarage = Math.min(N4, N5);
        sb.append(minBevarage + minBurger - 50);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
