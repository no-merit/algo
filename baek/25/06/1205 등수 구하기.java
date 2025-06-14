

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String [] NNP = br.readLine().split(" ");
		int N = Integer.parseInt(NNP[0]);
		long t = Long.parseLong(NNP[1]);
		int P = Integer.parseInt(NNP[2]);
		if(N==0) {
			System.out.println(1);
			return;
		}
		String [] list = br.readLine().split(" ");
		Long [] arr = new Long[N];
		for(int i=0; i<N; i++) {
			long score = Long.parseLong(list[i]);
			arr[i] = score;
		}
		Arrays.sort(arr,Collections.reverseOrder());
		if(N == P&&arr[N-1]>=t) {
			System.out.println(-1);
			return;
		}
		int st = 0;
		int ed = N-1;
		int rank =N;
		while(st<=ed) {
			int mid = st+(ed-st)/2;
			long target = arr[mid];
			if(target>t) {
				st = mid+1;
			}else {
				rank = mid;
				ed= mid-1;
			}
		}
		System.out.println(rank+1);
	}
}
