package java23;

import java.io.BufferedReader;
import java.io.InputStreamReader;



public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String []  NMK = br.readLine().split(" ");
		int N = Integer.parseInt(NMK[0]);
		int M = Integer.parseInt(NMK[1]);
		int K = Integer.parseInt(NMK[2]);
		
		String [] Ks = br.readLine().split(" ");
		int [] arr = new int [K];
		
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(Ks[i]);
		}
		int st = 0;
		int ed = N;
		String answer = "";
		while(st<=ed) {
			int mid = (st+ed)/2;
			int pre = 0;
			String str="1";
			int cnt=1;
			for(int i=1; i<K; i++) {
				int dist = arr[i]-arr[pre];
				if(dist>=mid) {
					str+="1";
					pre=i;
					cnt++;
					if(cnt==M) {
						break;
					}
				}else {
					str+="0";
				}
			}
			while(str.length()<K) {
				str+="0";
			}
			if(cnt==M) {
				st=mid+1;
				answer = str;
			}else {
				ed=mid-1;
			}
			
			
		}
		
		System.out.println(answer);
		
		
	}

}
