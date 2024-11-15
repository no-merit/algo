package java23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		String [] row = br.readLine().split(" ");
		int [] arr = new int [N];
		int max = 0;
		for(int i=0; i<N; i++) {
			int now = Integer.parseInt(row[i]);
			arr[i] = now;
		}
		
		Arrays.sort(arr);
		Integer [] diff = new Integer [N-1];
		for(int i=0; i<N-1; i++) {
			diff[i] = arr[i+1]-arr[i];
		}
		Arrays.sort(diff,Collections.reverseOrder());
		
		int sum =0;
		for(int i=K-1; i<N-1; i++) {
			sum+=diff[i];
			
		}
		System.out.println(sum);
	}

}
