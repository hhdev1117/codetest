import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_2805_나무자르기 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] nm = br.readLine().split(" ");
    String[] tree = br.readLine().split(" ");

    long max = 0;
    long answer = 0;
    for(int i = 0; i < tree.length; i++) {
      long treeHigh = Integer.parseInt(tree[i]);
      if(treeHigh > max) max = treeHigh;
    }

    int N = Integer.parseInt(nm[0]);
    int M = Integer.parseInt(nm[1]);

    while(true) {
      long treeHigh = (max + answer) / 2;

      if(getTreeCut(treeHigh, tree) >= M) {
        answer = treeHigh;
      } else {
        max = treeHigh;
      }

      if(max - 1 == answer) break;
    }

    System.out.println(answer);
  }

  public static long getTreeCut(long treeHigh, String[] tree) {
    long treeCut = 0;

    for(int i = 0; i < tree.length; i++) {
      treeCut += Integer.parseInt(tree[i]) - treeHigh > 0 ? Integer.parseInt(tree[i]) - treeHigh : 0;
    }

    return treeCut;
  }
}
