import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baek_Joon_2822 {
    public static void main(String[] args) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            arrayList.add(Integer.parseInt(br.readLine()));
        }
        
        int sum = 0;
        ArrayList<Integer> idx = new ArrayList<>();        
        for(int i = 0; i < 5; i++) {     
            int max = 0;       
            for(int j = 0; j < arrayList.size(); j++) {
                if(max < arrayList.get(j) && !idx.contains(arrayList.indexOf(arrayList.get(j)))) max = arrayList.get(j);
            }
            sum += max;
            idx.add(arrayList.indexOf(max));            
        }

        Collections.sort(idx);

        System.out.println(sum);
        for(int i = 0; i < idx.size(); i++) {
            System.out.print((idx.get(i)+1)+" ");
        }

        
    }
}
