import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int cnt =0;
        for(int i=0; i<str.length();i++) {
        	char now = str.charAt(i);
        	if(now=='a') cnt++;
        }
        int ans =Integer.MAX_VALUE;
        for(int i=0; i<str.length();i++) {
        	int tmp=0;
        	for(int j=i;j<i+cnt;j++) {
        		int tmp_idx = j;
        		if(j>=str.length()) {
        			tmp_idx=j%str.length();
        		}
        		
        		char now = str.charAt(tmp_idx);
        		if(now == 'b') tmp++;
        	}
        	ans=Math.min(ans, tmp);
        }
        System.out.println(ans);
      
        
    }
}
