import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        double start = 0;
        double end = Integer.MAX_VALUE;
        double mid = (start + end) / 2;
        int cnt = 0;
        while(start <= end) {
            if(cnt++ > 10000) break;
            mid = (start + end) / 2;
            long Lnum = (long)(L / mid);
            long Wnum = (long)(W / mid);
            long Hnum = (long)(H / mid);
            double num = Lnum * Wnum * Hnum;
            if(num >= N) {
                start = mid;
            } else {
                end = mid;
            }
        }
        sb.append(end);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
