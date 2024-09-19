import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        if(input.contains("__") || input.charAt(0) == '_' || input.charAt(input.length()-1) == '_' || (input.charAt(0) >= 65 && input.charAt(0) <= 90)) {
            System.out.println("Error!");
            return;
        }

        String answer = "";
        // C++
        if(input.contains("_")) {
            String[] input_arr = input.split("_");

            for(int i = 0; i < input_arr.length; i++) {
                for(int j = 0; j < input_arr[i].length(); j++) {
                    if((int)input_arr[i].charAt(j) >= 65 && (int)input_arr[i].charAt(j) <= 90) {
                        System.out.println("Error!");
                        return;
                    }

                    if(j == 0 && i != 0) {
                        answer += (input_arr[i].charAt(j)+"").toUpperCase();
                    }
                    else {
                        answer += input_arr[i].charAt(j);
                    }


                }

            }

        }
        // Java
        else {
            for(int i = 0; i < input.length(); i++) {
                if((int)input.charAt(i) >= 65 && (int)input.charAt(i) <= 90) {
                    answer += "_";
                    answer += (input.charAt(i)+"").toLowerCase();
                }   
                else answer += input.charAt(i);
            }
        }


        System.out.println(answer);

    }
}
