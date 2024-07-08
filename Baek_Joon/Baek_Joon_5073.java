import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String[] triangle = br.readLine().split(" ");
            int first = Integer.parseInt(triangle[0]);
            int second = Integer.parseInt(triangle[1]);
            int third = Integer.parseInt(triangle[2]);

            if(first == 0 || second == 0 || third == 0) break;

            if(first == second && second == third) sb.append("Equilateral").append("\n");
            else if(first == second || second == third || third == first) {
                if(first >= second+third || second >= first+third || third >= first+second) sb.append("Invalid").append("\n");
                else sb.append("Isosceles").append("\n");
            }
            else if(first >= second+third || second >= first+third || third >= first+second) sb.append("Invalid").append("\n");
            else sb.append("Scalene").append("\n");
        }

        System.out.println(sb);

    }
}
