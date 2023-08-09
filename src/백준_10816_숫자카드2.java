import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class 백준_10816_숫자카드2 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    String[] nArray = br.readLine().split(" ");

    int M = Integer.parseInt(br.readLine());
    String[] mArray = br.readLine().split(" ");

    Arrays.sort(nArray, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Long.compare(Long.parseLong(o1), Long.parseLong(o2));
      }
    });

    for(String str : nArray) System.out.print (str + " ");

    for(int i = 0; i < M; i++) {
      getCardCount(mArray[i], nArray);
    }
  }

  public static int getCardCount(String num, String[] nArray) {
    int max = nArray.length;
    int min = 0;
    int mid = 0;

    int number = Integer.parseInt(num);

    int answer = 0;

    while(true) {
      mid = (int) Math.floor((float) (max + min) / (float) 2);
      int n = Integer.parseInt(nArray[mid]);
      if(n > number) {
        //System.out.println("1 mid > number ===> mid : " + mid + " / max : " + max + " / min : " + min);
        max = mid;
      } else if(n < number) {
        //System.out.println("2 mid < number ===> mid : " + mid + " / max : " + max + " / min : " + min);
        min = mid;
      } else {
        //System.out.println("3 mid = number ===> mid : " + mid + " / max : " + max + " / min : " + min);
        answer++;
        break;
      }

      if(mid == (long) Math.floor((float) (max + min) / (float) 2)) return 0;
    }

    System.out.println(mid);
    return answer;
  }
}
