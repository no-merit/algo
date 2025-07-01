import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] paper = new int[7];
        for (int i = 1; i <= 6; i++) {
            paper[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        count += paper[6];

        count += paper[5];
        if (paper[5] > 0) {
            paper[1] = Math.max(0, paper[1] - paper[5] * 11);
        }

        count += paper[4];
        if (paper[4] > 0) {
            int twoSpace = paper[4] * 5;
            int usedTwo = Math.min(paper[2], twoSpace);
            paper[2] -= usedTwo;
            
            int oneSpace = (twoSpace - usedTwo) * 4;
            paper[1] = Math.max(0, paper[1] - oneSpace);
        }
        
        count += (paper[3] + 3) / 4;
        int rem3 = paper[3] % 4;
        if (rem3 > 0) {
            int usedTwo = 0;
            int oneSpace = 0;
            if (rem3 == 1) {
                usedTwo = Math.min(paper[2], 5);
                oneSpace = 27 - usedTwo * 4;
            } else if (rem3 == 2) {
                usedTwo = Math.min(paper[2], 3);
                oneSpace = 18 - usedTwo * 4;
            } else { // rem3 == 3
                usedTwo = Math.min(paper[2], 1);
                oneSpace = 9 - usedTwo * 4;
            }
            paper[2] -= usedTwo;
            paper[1] = Math.max(0, paper[1] - oneSpace);
        }

        if (paper[2] > 0) {
            count += (paper[2] + 8) / 9;
            int rem2 = paper[2] % 9;
            if (rem2 > 0) {
                paper[1] = Math.max(0, paper[1] - (36 - rem2 * 4));
            }
        }

        if (paper[1] > 0) {
            count += (paper[1] + 35) / 36;
        }

        System.out.println(count);
    }
}
