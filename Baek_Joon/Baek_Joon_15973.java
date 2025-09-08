import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_15973 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        String[] second = br.readLine().split(" ");

        long first_x1 = Long.parseLong(first[0]);
        long first_y1 = Long.parseLong(first[1]);
        long first_x2 = Long.parseLong(first[2]);
        long first_y2 = Long.parseLong(first[3]);

        long second_x1 = Long.parseLong(second[0]);
        long second_y1 = Long.parseLong(second[1]);
        long second_x2 = Long.parseLong(second[2]);
        long second_y2 = Long.parseLong(second[3]);

        if(first_x1 > second_x2 || first_x2 < second_x1 || first_y2 < second_y1 || first_y1 > second_y2) System.out.println("NULL");
        else if((first_x1 == second_x2 && first_y1 == second_y2 && first_x2 != second_x1) || (first_x2 == second_x1 && first_y1 == second_y2 && first_x1 != second_x2)
        || (first_x2 == second_x1 && first_y2 == second_y1 && first_x1 != second_x2) || (first_x1 == second_x2 && first_y2 == second_y1 && first_x2 != second_x1)) System.out.println("POINT");
        else if(first_x1 == second_x2 || first_y1 == second_y2 || first_x2 == second_x1 || first_y1 == second_y2 
        || first_x2 == second_x1 || first_y2 == second_y1 || first_x1 == second_x2 || first_y2 == second_y1) System.out.println("LINE");
        else System.out.println("FACE");
        
    }
}
