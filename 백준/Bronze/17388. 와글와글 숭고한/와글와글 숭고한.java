import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    StringTokenizer st = null;
	    StringBuilder sb = new StringBuilder();
	    
	    String[] univ = {"Soongsil", "Korea", "Hanyang"};
	    String s = br.readLine();
	    st = new StringTokenizer(s, " ");
	    int minValue = Integer.MAX_VALUE;
	    int minInd = 0;
	    int sum = 0;
	    for (int i = 0; i < 3; i++) {
	    	int n = Integer.parseInt(st.nextToken());
	    	if(n < minValue) {
	    		minInd = i;
	    		minValue = n;
	    	}
	    	sum += n;
	    }
	    if(sum < 100) {
	    	sb.append(univ[minInd]);
	    } else {
	    	sb.append("OK");
	    }
	    
	    
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}