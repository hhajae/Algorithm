import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder resSb = new StringBuilder();

        String[] pass = new String[] {
                "000000", // A
                "001111", // B
                "010011", // C
                "011100", // D
                "100110", // E
                "101001", // F
                "110101", // G
                "111010"  // H
        };

        String[] word = new String[] {"A","B","C","D","E","F","G","H"};

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        String[] arr = new String[n+1];
        for (int i = 0; i < n; i++) {
            arr[i+1] = s.substring(i*6, (i*6)+6);
        }

        outer: for (int i = 1; i < n+1; i++) {
            String str = arr[i];
            // 100% 일치하는지
            for (int j = 0; j < 8; j++) {
                if(str.equals(pass[j])) {
                    resSb.append(word[j]);
                    continue outer;
                }
            }

            // 1문자만 틀린지
            int ind = -1;
            for (int j = 0; j < 8; j++) {
                int cnt = 0;
                for (int k = 0; k < 6; k++) {
                    if(str.charAt(k) != pass[j].charAt(k)) {
                        cnt++;
                    }
                }
                if(cnt == 1) {
                    ind = j;
                    break;
                }
            }
            if(ind == -1) {
                resSb = new StringBuilder();
                resSb.append(i);
                break outer;
            }
            resSb.append(word[ind]);
        }

        bw.write(resSb.toString());
        bw.flush();
        bw.close();
        br.close();

    }
}