import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		List<int[]> players = new ArrayList<>();
        String line;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
              int white = sc.nextInt();;
              int black = sc.nextInt();;
            players.add(new int[]{white, black});
        }
        
        int len = players.size();
        int [][][] dp = new int [len+1][16][16];
        for(int i=1; i<=len;i++) {
        	int [] player = players.get(i-1);
        	int white = player[0];
        	int black = player[1];
        	for(int w=0;w<16;w++) {
        		for(int b = 0; b<16;b++) {
        			dp[i][w][b] = dp[i - 1][w][b];
        			if(w>0) {
        				dp[i][w][b] = Math.max(dp[i][w][b], dp[i-1][w-1][b]+white);
        			}
        			if(b>0) {
        				dp[i][w][b] = Math.max(dp[i][w][b], dp[i-1][w][b-1]+black);
        			}
        		}
        	}
        }
        System.out.println(dp[len][15][15]);
	}
	
}
