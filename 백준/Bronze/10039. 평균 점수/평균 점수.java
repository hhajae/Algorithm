import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int A = Math.max(Integer.parseInt(br.readLine()), 40);
        int B = Math.max(Integer.parseInt(br.readLine()), 40);
        int C = Math.max(Integer.parseInt(br.readLine()), 40);
        int D = Math.max(Integer.parseInt(br.readLine()), 40);
        int E = Math.max(Integer.parseInt(br.readLine()), 40);

        sb.append((A+B+C+D+E)/5);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
