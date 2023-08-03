import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 백준_1406_에디터 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    Deque<Character> deque = new ArrayDeque<>();
    StringBuilder sb = new StringBuilder();

    for(char a : sc.next().toCharArray()) deque.add(a);

    int cur = deque.size();
    int commCnt = sc.nextInt();

    for(int i = 0; i < commCnt; i++) {
      String comm = sc.next();

      if(comm.equals("L")) {
        if(cur - 1 >= 0) {
          cur--;
          deque.offerFirst(deque.pollLast());
        }
      } else if(comm.equals("D")) {
        if(cur + 1 <= deque.size()) {
          cur++;
          deque.offerLast(deque.pollFirst());
        }
      } else if(comm.equals("B")) {
        if(cur - 1 >= 0) {
          cur--;
          deque.pollLast();
        }
      } else if(comm.equals("P")) {
        cur++;
        deque.offerLast(sc.next().charAt(0));
      }

    }

    for(int i = 0; i < deque.size()-cur; i++) {
      deque.offerLast(deque.pollFirst());
    }

    for(char a : deque) sb.append(a);
    System.out.println(sb.toString());



/*
    Scanner sc = new Scanner(System.in);

    LinkedList<Character> strList = new LinkedList<>();
    StringBuilder sb = new StringBuilder();

    for(char str : sc.nextLine().toCharArray())
      strList.add(str);

    int cur = strList.size();
    int commCnt = sc.nextInt();

    for(int i = 0; i < commCnt; i++) {
      String comm = sc.next();
      if(comm.equals("L")) {
        cur = Math.max(cur - 1, 0);
      } else if(comm.equals("D")) {
        cur = Math.min(cur + 1, strList.size());
      } else if(comm.equals("B")) {
        if(cur - 1 >= 0) strList.remove(cur - 1);
        cur = Math.max(cur - 1, 0);
      } else if(comm.equals("P")) {
        strList.add(cur, sc.next().charAt(0));
        cur = Math.min(cur + 1, strList.size());
      }
    }

    for(char str : strList) sb.append(str);
    System.out.println(sb.toString());
*/
  }

}
