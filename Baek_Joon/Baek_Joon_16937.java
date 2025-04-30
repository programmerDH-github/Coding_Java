import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_16937 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] H_W = br.readLine().split(" ");
        int H = Integer.parseInt(H_W[0]);
        int W = Integer.parseInt(H_W[1]);
        int N = Integer.parseInt(br.readLine());


        int[][] breadth = new int[N][2];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            breadth[i][0] = Integer.parseInt(input[0]);
            breadth[i][1] = Integer.parseInt(input[1]);
        }

        int max = 0;
        for(int i = 0; i < N-1; i++) {
            int firstH = breadth[i][0];
            int firstW = breadth[i][1];

            if(firstH <= H && firstW <= W) {
                int firstExtent = firstH*firstW;
                int nowH = H-firstH;
                int nowW = W-firstW;

                int secondExtent = 0;
                for(int j = i+1; j < N; j++) {
                    int secondH = breadth[j][0];
                    int secondW = breadth[j][1];

                    if((secondH <= nowH && secondW <= W) || (secondH <= H && secondW <= nowW)) {
                        secondExtent = Math.max(secondExtent, secondH*secondW);
                    }

                    int tmep = secondH;
                    secondH = secondW;
                    secondW = tmep;

                    if((secondH <= nowH && secondW <= W) || (secondH <= H && secondW <= nowW)) {
                        secondExtent = Math.max(secondExtent, secondH*secondW);
                    }

                }

                if(firstExtent != 0 && secondExtent != 0) {
                    max = Math.max(max, firstExtent+secondExtent);
                }

            }

            int tmep = firstH;
            firstH = firstW;
            firstW = tmep;

            if(firstH <= H && firstW <= W) {
                int firstExtent = firstH*firstW;
                int nowH = H-firstH;
                int nowW = W-firstW;

                int secondExtent = 0;
                for(int j = i+1; j < N; j++) {
                    int secondH = breadth[j][0];
                    int secondW = breadth[j][1];

                    if((secondH <= nowH && secondW <= W) || (secondH <= H && secondW <= nowW)) {
                        secondExtent = Math.max(secondExtent, secondH*secondW);
                    }

                    tmep = secondH;
                    secondH = secondW;
                    secondW = tmep;

                    if((secondH <= nowH && secondW <= W) || (secondH <= H && secondW <= nowW)) {
                        secondExtent = Math.max(secondExtent, secondH*secondW);
                    }

                }

                if(firstExtent != 0 && secondExtent != 0) {
                    max = Math.max(max, firstExtent+secondExtent);
                }


            }
        }

        System.out.println(max);

    }
}