import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cnt2 = 0;
        int cnte = 0;
        String s = br.readLine();
        for (int i = 0; i < N; i++) {
            if(s.charAt(i) == '2') cnt2++;
            else if(s.charAt(i) == 'e') cnte++;
        }
        if(cnt2 > cnte) {
            sb.append("2");
        } else if(cnte > cnt2) {
            sb.append("e");
        } else {
            sb.append("yee");
        } 
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
