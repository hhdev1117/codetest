import java.util.LinkedList;
import java.util.Scanner;

public class 백준_1158_요세푸스순열 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int K = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    sb.append("<");

    LinkedList<Integer> deque = new LinkedList<>();

    for(int i = 1; i <= N; i++) deque.add(i);

    while(deque.size() > 0) {
      for(int i = 0; i < K; i++) {
        if(i >= K-1) {
          sb.append(deque.pollFirst());
          sb.append(", ");
        } else {
          deque.offerLast(deque.pollFirst());
        }
      }
    }

    sb.delete(sb.length()-2, sb.length());
    sb.append(">");

    System.out.println(sb.toString());
  }
}
