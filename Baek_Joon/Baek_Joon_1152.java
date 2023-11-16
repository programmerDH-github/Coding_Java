import java.io.*;

public class Baek_Joon_1152 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int answer = 0;
        for(int i = 0; i < str.length; i++) {
            System.out.println("str : "+str[i]+"입니다.");
            if(str[i].equals("")) {
                System.out.println("if");
                continue;
            }
            answer++;
        }

        System.out.println(answer);
    }
}
