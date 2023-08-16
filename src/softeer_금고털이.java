import java.util.*;
import java.io.*;


public class softeer_금고털이
{
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);

    int answer = 0;

    int W = sc.nextInt();
    int N = sc.nextInt();

    Map<Integer, Integer> itemMap = new HashMap<>();
    List<Integer> index = new ArrayList<>();

    for(int i = 0; i < N; i++) {
      int M = sc.nextInt();
      int P = sc.nextInt();

      if(itemMap.get(P) == null) {
        itemMap.put(P, M);
        index.add(P);
      }
      else {
        itemMap.put(P, itemMap.get(P) + M);
      }
    }

    Collections.sort(index);

    for(int i = itemMap.size() - 1; i >= 0; i--) {
      int price = index.get(i);
      if(itemMap.get(price) < W) {
        W -= itemMap.get(price);
        answer += itemMap.get(price) * price;
      } else {
        answer += W * price;
        break;
      }
    }

    System.out.println(answer);

  }
}