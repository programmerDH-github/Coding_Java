import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_6603 {
    static String[] input;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        while(true) {
            input = br.readLine().split(" ");
            if(input[0].equals("0")) break;

            lotto(input,1,"", 0);
            sb.append("\n");

        }

        System.out.println(sb);

    }

    static void lotto(String[] arr, int index, String str, int count) {
        if(count == 6) {
            sb.append(str).append("\n");
            return;
        }

        for(int i = index; i < arr.length; i++) {
            lotto(arr, i+1, str+arr[i]+" ", count+1);
        }

    }

}
