

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int[] maxPrimeNum = new int[n + 1];

		for (int i = 2; i <= n; i++) {
			if (maxPrimeNum[i] == 0) {
				for (int j = i; j <= n; j += i) {
					maxPrimeNum[j] = i;
				}
			}
		}

		int count = 0;
		for (int i = 1; i <= n; i++) {
			if (maxPrimeNum[i] <= k) {
				count++;
			}
		}

		System.out.println(count);
	}
}
