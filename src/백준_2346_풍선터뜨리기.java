import java.util.*;

public class 백준_2346_풍선터뜨리기 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    Deque<Integer> deque = new ArrayDeque<>();
    Map<Integer, Integer> numMap = new HashMap<>();

    for(int i = 0; i < N; i++) {
      deque.add(i + 1);
      numMap.put(i + 1, sc.nextInt());
    }

    sb.append(1).append(" ");
    int move = numMap.get(1);
    deque.removeFirst();

    for(int i = 0; i < N - 1; i++) {
      if(move > 0) {
        for (int j = 0; j < move - 1; j++)
          deque.offerLast(deque.pollFirst());
      } else {
        move = move * -1;
        for (int j = 0; j < move; j++)
          deque.offerFirst(deque.pollLast());
      }

      move = numMap.get(deque.getFirst());
      sb.append(deque.pollFirst()).append(" ");

    }

    System.out.println(sb.toString());
  }
}
