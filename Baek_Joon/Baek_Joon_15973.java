import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_15973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        String[] second = br.readLine().split(" ");

        int first_x1 = Integer.parseInt(first[0]);
        int first_y1 = Integer.parseInt(first[1]);
        int first_x2 = Integer.parseInt(first[2]);
        int first_y2 = Integer.parseInt(first[3]);

        int second_x1 = Integer.parseInt(second[0]);
        int second_y1 = Integer.parseInt(second[1]);
        int second_x2 = Integer.parseInt(second[2]);
        int second_y2 = Integer.parseInt(second[3]);


        if((first_x1 == second_x2 && first_y1 == second_y2) || (first_x2 == second_x1 && first_y1 == second_y2)
        || (first_x2 == second_x1 && first_y2 == second_y1) || (first_x1 == second_x2 && first_y2 == second_y1)) System.out.println("POINT");
        else if(first_x1 == second_x2 || first_y1 == second_y2 || first_x2 == second_x1 || first_y1 == second_y2 
        || first_x2 == second_x1 || first_y2 == second_y1 || first_x1 == second_x2 || first_y2 == second_y1) System.out.println("LINE");
        else if((first_x1 > second_x2 || first_y1 > second_y2) && (first_x2 < second_x1 || first_y1 > second_y2) 
        && (first_x1 < second_x1 || first_y2 < second_y1) && (first_x1 < second_x2 || first_y2 > second_y1)) System.out.println("NULL");
        else System.out.println("FACE");

    }
}
