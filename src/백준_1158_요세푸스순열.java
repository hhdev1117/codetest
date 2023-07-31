import java.util.LinkedList;
import java.util.Scanner;

public class 백준_1021_회전하는큐 {

  public static void main(String[] args) {
    int answer = 0;

    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int M = sc.nextInt();

    int[] numArray = new int[M];
    LinkedList<Integer> deque = new LinkedList<>();

    for (int i = 0; i < M; i++)
      numArray[i] = sc.nextInt();
    for (int i = 1; i <= N; i++)
      deque.offer(i);

    for (int i = 0; i < M; i++) {
      int num = numArray[i];
      if (deque.size() / 2 >= deque.indexOf(num)) {
        while (true) {
          if (deque.getFirst() == num) {
            deque.removeFirst();
            break;
          } else {
            deque.offerLast(deque.pollFirst());
            answer++;
          }
        }
      } else {
        while (true) {
          if (deque.getFirst() == num) {
            deque.removeFirst();
            break;
          } else {
            deque.offerFirst(deque.pollLast());
            answer++;
          }
        }
      }
      /*
      System.out.print("\tanswer : " + answer + "\tarray : ");
      for(int j = 0; j < deque.size(); j++) {
        System.out.print(deque.get(j) + "\t");
      }
      System.out.println();

      }
      */

    }
    System.out.println(answer);
  }
}
