import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int order = 0;
        for(int i = 0; i < T; i++) {
            String input = br.readLine();

            if(input.length() < 3) {
                sb.append("Good").append("\n");
                continue;
            }

            int count = 0;
            for(int j = 0; j < input.length(); j++) {
                if((int)input.charAt(j) > 70) {
                    sb.append("Good").append("\n");
                    break;
                }

                if(count == 0) {
                    if((int)input.charAt(j) > 70) {
                        sb.append("Good").append("\n");
                        break;
                    }
                    
                    count++;

                }
                else if(count == 1) {
                    if(input.charAt(j) != 'A' && input.charAt(j) != 'F') {
                        sb.append("Good").append("\n");
                        break;
                    }
                    
                    if(input.charAt(j) == 'F') count++;

                }
                else if(count == 2) {
                    if(input.charAt(j) != 'F' && input.charAt(j) != 'C') {
                        sb.append("Good").append("\n");
                        break;
                    }

                    if(input.charAt(j) == 'C') count++;

                }
                else if(count == 3) {
                    if(input.charAt(j) != 'C' && (int)input.charAt(j) > 70) {
                        sb.append("Good").append("\n");
                        break;
                    }

                    if((int)input.charAt(j) != 'C') count++;

                }
                else {
                    sb.append("Good").append("\n");
                }

                if(j == input.length()-1) {
                    sb.append("Infected!").append("\n");
                }
                
            }

        }

    /*
        String regExPattern = "^[A-F]?A+F+C+[A-F]?$"; 
        ^ : 정규표현식 시작
        $ : 정규표현식 끝
        [A-F] : A,B,C,D,E,F
        ? : 0번 또는 1번
        + : 그 전 문자가 1개 이상
        
    */
        System.out.println(sb);

    }
}
