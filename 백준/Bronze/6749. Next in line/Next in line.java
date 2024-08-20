import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int Y = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        sb.append(M+(M-Y));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
