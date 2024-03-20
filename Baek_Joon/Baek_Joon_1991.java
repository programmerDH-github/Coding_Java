import java.io.*;

public class Baek_Joon_1991 {
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new Node[N+1];

        for(int i = 0; i < N; i++) {
            String[] value = br.readLine().split(" ");
            char parent_value = value[0].charAt(0);
            char left_value = value[1].charAt(0);
            char right_value = value[2].charAt(0);
            
            if(tree[parent_value - 'A'] == null) {
                tree[parent_value - 'A'] = new Node(parent_value);
            }
            if(left_value != '.') {
                tree[left_value - 'A'] = new Node(left_value);
                tree[parent_value - 'A'].left = tree[left_value - 'A'];
            }
            if(right_value != '.') {
                tree[right_value - 'A'] = new Node(right_value);
                tree[parent_value - 'A'].right = tree[right_value - 'A'];
            }
        }

        pre_order(tree[0]);
        System.out.println();

        in_order(tree[0]);
        System.out.println();

        post_order(tree[0]);
        System.out.println();
    }

    public static void pre_order(Node node) {
        if(node == null) return;
        System.out.print(node.vlaue);
        pre_order(node.left);
        pre_order(node.right);        
    }

    public static void in_order(Node node) {
        if(node == null) return;
        in_order(node.left);
        System.out.print(node.vlaue);
        in_order(node.right);
    }

    public static void post_order(Node node) {
        if(node == null) return;
        post_order(node.left);
        post_order(node.right);
        System.out.print(node.vlaue);
    }

    static class Node {
        char vlaue;
        Node left;
        Node right;
        public Node(char vlaue) {
            this.vlaue = vlaue;
            this.left = null;
            this.right = null;
        }        
    }
}
