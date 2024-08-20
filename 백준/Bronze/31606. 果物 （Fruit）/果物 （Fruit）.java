import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        sb.append(x+y+3);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
