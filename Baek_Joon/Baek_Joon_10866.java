import java.io.*;
import java.util.ArrayList;

public class Baek_Joon_10866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arraylist = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            String[] order = br.readLine().split(" ");
            if(order.length > 1) {
                String[] front_back = order[0].split("_");
                if(front_back[1].equals("front")) arraylist.add(0, Integer.parseInt(order[1]));
                else arraylist.add(Integer.parseInt(order[1]));
            }
            else {
                if(order[0].startsWith("pop")) {
                    if(!arraylist.isEmpty()) {
                        if(order[0].endsWith("front")) {
                            System.out.println(arraylist.get(0));
                            arraylist.remove(0);
                        }
                        else {
                            System.out.println(arraylist.get(arraylist.size()-1));
                            arraylist.remove(arraylist.size()-1);
                        }
                        
                    }
                    else {
                        System.out.println(-1);
                    }
                }
                else if(order[0].equals("size")) {
                    System.out.println(arraylist.size());
                }
                else if(order[0].equals("empty")) {
                    if(!arraylist.isEmpty()) System.out.println(0);
                    else System.out.println(1);
                }
                else if(order[0].equals("front")) {
                    if(!arraylist.isEmpty()) System.out.println(arraylist.get(0));
                    else System.out.println(-1);
                }
                else if(order[0].equals("back")) {
                    if(!arraylist.isEmpty()) System.out.println(arraylist.get(arraylist.size()-1));
                    else System.out.println(-1);
                }
            }
        }
    }
}
