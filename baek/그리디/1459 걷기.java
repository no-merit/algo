package java23;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String []XYWS = br.readLine().split(" ");
		int X = Integer.parseInt(XYWS[0]);
		int Y = Integer.parseInt(XYWS[1]);
		long W = Integer.parseInt(XYWS[2]);
		long S = Integer.parseInt(XYWS[3]);
		
		if(S>=2*W) {
			long ans = (X+Y)*W;
			System.out.println((X+Y)*W);
			System.exit(0);
		}else if(2*S<2*W){
			long min = Math.min(X,Y);
			long max = Math.max(X,Y);
			long sub = max-min;//나머지
			if(sub%2==0) {
				System.out.println(sub*S+min*S);
			}else {
				System.out.println((sub-1)*S+min*S+W);
			}
			System.exit(0);
		}else {
			long min = Math.min(X,Y);
			long max = Math.max(X,Y);
			System.out.println((max-min)*W+min*S);
			System.exit(0);
		}
		
		
		
	}

}
