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
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if(s.equals("Algorithm")) sb.append("204");
            else if(s.equals("Network")) sb.append("303");
            else if(s.equals("DataAnalysis")) sb.append("207");
            else if(s.equals("ArtificialIntelligence")) sb.append("302");
            else if(s.equals("CyberSecurity")) sb.append("B101");
            else if(s.equals("Startup")) sb.append("501");
            else if(s.equals("TestStrategy")) sb.append("105");
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
