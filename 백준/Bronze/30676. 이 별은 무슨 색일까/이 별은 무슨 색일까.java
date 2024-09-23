import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        int lambda = Integer.parseInt(br.readLine());
        if(620 <= lambda) sb.append("Red");
        else if(590 <= lambda) sb.append("Orange");
        else if(570 <= lambda) sb.append("Yellow");
        else if(495 <= lambda) sb.append("Green");
        else if(450 <= lambda) sb.append("Blue");
        else if(425 <= lambda) sb.append("Indigo");
        else sb.append("Violet");
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
