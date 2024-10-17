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
        String[][] scores = {
                {},
                {"A", "B", "C", "D", "E", "F", "G", "H", "J", "L", "M"},
                {"A", "C", "E", "F", "G", "H", "I", "L", "M"},
                {"A", "C", "E", "F", "G", "H", "I", "L", "M"},
                {"A", "B", "C", "E", "F", "G", "H", "L", "M"},
                {"A", "C", "E", "F", "G", "H", "L", "M"},
                {"A", "C", "E", "F", "G", "H", "L", "M"},
                {"A", "C", "E", "F", "G", "H", "L", "M"},
                {"A", "C", "E", "F", "G", "H", "L", "M"},
                {"A", "C", "E", "F", "G", "H", "L", "M"},
                {"A", "B", "C", "F", "G", "H", "L", "M"}
        };
        sb.append(scores[N].length).append("\n");
        for (int i = 0; i < scores[N].length; i++) {
            sb.append(scores[N][i]).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
