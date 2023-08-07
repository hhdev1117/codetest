import java.io.*;

public class 백준_1654_랜선자르기 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] comm = br.readLine().split(" ");

    int K = Integer.parseInt(comm[0]);
    int N = Integer.parseInt(comm[1]);

    long max = 0;
    long min = 1;
    long answer = 0;

    long[] lanList = new long[K];
    for(int i = 0; i < lanList.length; i++) {
      lanList[i] = Long.parseLong(br.readLine());
      max = lanList[i] > max ? lanList[i] : max;
    }

    while(true) {

      answer = (max + min) / 2;
      long cnt = getLanCount(answer, lanList);
      if(cnt >= N) {
        min = answer;
      } else {
        max = answer;
      }

      if(answer == ((max + min) / 2)) {
        if(getLanCount(max, lanList) == N) answer = max;
        else answer = min;
        break;
      }
    }

    System.out.println(answer);
  }

  public static long getLanCount(long length, long[] lanList) {
    long cnt = 0;
    for(int i = 0; i < lanList.length; i++) cnt += lanList[i] / length;
    return cnt;
  }
}
