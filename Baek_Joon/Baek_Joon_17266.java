import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_17266 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int lamp[] = new int[M];
        String[] lampArr = br.readLine().split(" ");
        for(int i = 0; i < M; i++) {
            lamp[i] = Integer.parseInt(lampArr[i]);
        }
        
        int height = 0;
        height = Math.max(lamp[0], N-lamp[lamp.length-1]);

        if(M == 1) {
            System.out.println(height);
            return;
        }

        for(int i = 0; i < M-1; i++) {
            int front = lamp[i];
            int back = lamp[i+1];               
            int distance = back - front;
            
            if(distance % 2 == 0) height = Math.max(height, distance/2);
            else height = Math.max(height, (distance/2+1));            
            
        }

        System.out.println(height);
        
    }
}
