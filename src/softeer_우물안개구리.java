import java.util.*;

public class softeer_우물안개구리 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();

    List<Integer> weightList = new ArrayList<>();
    Map<Integer, Integer> loserMap = new HashMap<>();

    for(int i = 0; i < N; i++) weightList.add(sc.nextInt());

    for(int i = 0; i < M; i++) {
      int first = sc.nextInt();
      int second = sc.nextInt();

      if(weightList.get(first - 1) > weightList.get(second - 1)) {
        loserMap.put(second, weightList.get(second - 1));
      } else if(weightList.get(first - 1) < weightList.get(second - 1)) {
        loserMap.put(first, weightList.get(first - 1));
      } else {
        loserMap.put(first, weightList.get(first - 1));
        loserMap.put(second, weightList.get(second - 1));
      }
    }

    System.out.println(N - loserMap.size());

  }
}
