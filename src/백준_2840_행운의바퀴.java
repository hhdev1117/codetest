import java.util.*;

public class 백준_2840_행운의바퀴 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    Deque<String> deque = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    int N = sc.nextInt();
    int K = sc.nextInt();

    for(int i = 0; i < N; i++) deque.add("?");

    for(int i = 0; i < K; i++) {
      int num = sc.nextInt();
      String alp = sc.next();

      for(int j = 0; j < num; j++) deque.offerFirst(deque.pollLast());


      if(!deque.getFirst().equals("?") && !deque.getFirst().equals(alp)) {
        sb.append("!");
        break;
      }

      if(!deque.getFirst().equals(alp) && deque.contains(alp)) {
        sb.append("!");
        break;
      }

      deque.removeFirst();
      deque.offerFirst(alp);
    }

    if(!sb.toString().equals("!")) {
      for (int i = 0; i < deque.size(); i++) System.out.print(deque.toArray()[i]);
    } else {
      System.out.println(sb.toString());
    }
  }
}
