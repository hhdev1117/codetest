import java.io.*;
import java.util.*;

public class 백준_1920_수찾기 {

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    String[] nArray = br.readLine().split(" ");

    Arrays.sort(nArray, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return Long.compare(Long.parseLong(o1), Long.parseLong(o2));
      }
    });

    int M = Integer.parseInt(br.readLine());
    String[] mArray = br.readLine().split(" ");

    for(int i = 0; i < M; i++) {
      String number = mArray[i];

      System.out.println(isInclude(number, nArray));
    }

  }

  public static int isInclude(String number, String[] nArray) {
    long max = nArray.length;
    long min = 0;
    long num = Integer.parseInt(number);

    while(true) {
      long search = (long) Math.floor((float)(max + min) / (float)2);

      if(Long.parseLong(nArray[(int) search]) > num) {
        max = search;
      } else if(Long.parseLong(nArray[(int) search]) < num) {
        min = search;
      } else {
        return 1;
      }

      if(search == (long) Math.floor((float)(max + min) / (float)2)) return 0;
    }
  }
}
