import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int[] A = new int[3];
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());
            A[i] = n;
        }
        int[] B = new int[3];
        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(br.readLine());
            B[i] = n;
        }
        int Ascore = 3 * A[0] + 2 * A[1] + A[2];
        int Bscore = 3 * B[0] + 2 * B[1] + B[2];
        if(Ascore > Bscore) sb.append("A");
        else if (Bscore > Ascore) sb.append("B");
        else sb.append("T");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
