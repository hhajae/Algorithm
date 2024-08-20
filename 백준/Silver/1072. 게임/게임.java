import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        String s = br.readLine();
        st = new StringTokenizer(s, " ");
        double X = Double.parseDouble(st.nextToken());
        double Y = Double.parseDouble(st.nextToken());

        int origin = (int)(Y*100/X);
        long start = 0;
        long end = Integer.MAX_VALUE + (long)X;
        while(start <= end) {
        	long mid = (start + end) / 2;
//        	System.out.println(start + ", " + mid + ", " + end);
        	double tmpX = X + mid;
        	double tmpY = Y + mid;
        	int tmpOrigin = (int)(tmpY*100/tmpX);
        	if(tmpOrigin == origin) {
        		start = mid + 1;
        		continue;
        	}
        	end = mid - 1;
        }
//        System.out.println(start + ", " + (start+end)/2 + ", " + end);
        if(start >= Integer.MAX_VALUE) sb.append("-1");
        else if(start == 0) sb.append(1);
        else sb.append(start);
        
        bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}
