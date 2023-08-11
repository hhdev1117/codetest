import java.util.*;

public class 백준_12738_가장긴증가하는부분수열3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int[] nArray = new int[N];
    List<Integer> lis = new ArrayList<>();

    for (int i = 0; i < N; i++) nArray[i] = sc.nextInt();

    lis.add(-1000000001);

    for(int i = 0; i < N; i++) {
      if(lis.get(lis.size() - 1) >= nArray[i]) {
        lis.set(getLowerBound(nArray[i], lis), nArray[i]);
      } else {
        lis.add(nArray[i]);
      }
    }

    System.out.println(lis.size() - 1);

  }

  public static int getLowerBound(int number, List<Integer> lis) {
    int left = 0;
    int right = lis.size();

    while(left < right) {
      int mid = (left + right) / 2;

      if(lis.get(mid) >= number) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }
}
