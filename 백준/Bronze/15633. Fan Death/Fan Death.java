import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 1; i < N+1; i++) {
            if(N % i == 0) {
                sum += i;
            }
        }
        sb.append((sum*5)-24);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}