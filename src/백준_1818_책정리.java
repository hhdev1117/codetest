import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 백준_1818_책정리 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    List<Integer> array = new ArrayList<>();

    array.add(0);

    for(int i = 0; i < N; i++) {
      int number = sc.nextInt();
      if(array.get(array.size() - 1) > number) {
        array.set(getLowerBound(number, array), number);
      } else {
        array.add(number);
      }
    }

    System.out.println(N - array.size() + 1);
  }

  public static int getLowerBound(int number, List<Integer> array) {
    int left = 0;
    int right = array.size();

    while(left < right) {
      int mid = (left + right) / 2;

      if(array.get(mid) <= number) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return left;
  }
}
