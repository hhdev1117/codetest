import java.util.Arrays;
import java.util.Scanner;

public class 백준_10816_숫자카드2 {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    StringBuilder sb = new StringBuilder();

    int N = sc.nextInt();
    int[] nArray = new int[N];
    for(int i = 0; i < N; i++) nArray[i] = sc.nextInt();

    int M = sc.nextInt();

    Arrays.sort(nArray);

    for(int i = 0; i < M; i++) {
      int number = sc.nextInt();

      sb.append(getUpperBound(number, nArray) - getLowerBound(number, nArray)).append(" ");
    }

    System.out.println(sb);
  }

  public static int getLowerBound(int number, int[] nArray) {
    int right = nArray.length;
    int left = 0;

    while(left < right) {
      int mid = (right + left)/2;
      if(nArray[mid] >= number) {
        right = mid;
      } else {
        left = mid + 1;
      }
    }

    return left;
  }

  public static int getUpperBound(int number, int[] nArray) {
    int right = nArray.length;
    int left = 0;

    while(left < right) {
      int mid = (right + left)/2;
      if(nArray[mid] <= number) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }

    return left;
  }
}
