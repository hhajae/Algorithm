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
	    
	    int antena = Integer.parseInt(br.readLine());
	    int eyes = Integer.parseInt(br.readLine());
	    if(antena >= 3 && eyes <= 4) sb.append("TroyMartian\n");
	    if(antena <= 6 && eyes >= 2) sb.append("VladSaturnian\n");
	    if(antena <= 2 && eyes <= 3) sb.append("GraemeMercurian");
	    	
	    bw.write(sb.toString());
		bw.flush();
	    bw.close();
	    br.close();
	}
}