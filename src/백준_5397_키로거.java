import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 백준_5397_키로거 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Deque<Character> deque = new ArrayDeque<>();
    int cnt = sc.nextInt();

    for(int i = 0; i < cnt; i++) {
      String comm = sc.next();
      System.out.println(comm);
      int cur = 0;

      for(char com : comm.toCharArray()) {

        if(com == '<') {
          if(cur > 0) {
            cur--;
            deque.offerLast(deque.pollFirst());
          }
        } else if(com == '>') {
          if(cur < deque.size()) {
            cur++;
            deque.offerFirst(deque.pollLast());
          }
        } else if(com == '-') {
          if(cur > 0) {
            cur--;
            deque.removeFirst();
          }
        } else {
          cur++;
          deque.offerFirst(com);
        }
        //System.out.println("====> com : " + com + " / cur : " + cur + " / deque : " + deque.toString());
      }

      for(int j = 0; j < cur; j++) deque.offerLast(deque.pollFirst());

      int print = deque.size();
      for(int j = 0; j < print; j++) System.out.print(deque.pollLast());
    }
  }
}
