import java.util.*;

class Solution {
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        node[] n = new node[nodeinfo.length];
        
        for (int i=0; i<nodeinfo.length; i++) {
            n[i] = new node(nodeinfo[i][0], nodeinfo[i][1], i+1, null, null);
        }
        Arrays.sort(n, new Comparator<node>() {
            public int compare(node a, node b) {
                if (a.y == b.y) return a.x - b.x;
                else return b.y - a.y;
            }
        });
        
        node root = n[0];
        for (int i=1; i<n.length; i++) {
            Tree(root, n[i]);
        }
        preorder(root, answer[0]);
        postorder(root, answer[1]);
        return answer;
    }
    public void Tree(node parent, node child) {
        if (parent.x > child.x) {
            if (parent.left != null) Tree(parent.left, child);
            else parent.left = child;
        }
        else {
            if (parent.right != null) Tree(parent.right, child);
            else parent.right = child;
        }
    }
    public void preorder(node root, int[] arr) {
        int cnt = 0;
        Stack<node> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            node temp = st.pop();
            if (temp.right != null) st.push(temp.right);
            if (temp.left != null) st.push(temp.left);
            arr[cnt++] = temp.num;
        }
        st.clear();
    }
    public void postorder(node root, int[] arr) {
        int cnt = 0;
        node temp = null;
        node last = null;
        Stack<node> st = new Stack<>();
        while (!st.isEmpty() || root != null) {
            if (root != null) {
                st.push(root);
                root = root.left;
            }
            else {
                temp = st.peek();
                if (temp.right!=null && temp.right!=last) root = temp.right;
                else {
                    arr[cnt++] = temp.num;
                    last = st.pop();
                }
            }
        }
    }
    public class node {
        int x;
        int y;
        int num;
        node left;
        node right;
        public node (int x, int y, int num, node left, node right) {
            this.x = x; this.y = y; this.num = num;
            this.left = left; this.right = right;
        }
    }
}