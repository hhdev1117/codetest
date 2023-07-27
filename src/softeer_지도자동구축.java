import java.util.Scanner;

public class softeer_지도자동구축 {
  public static void main(String args[])
  {
    Scanner sc = new Scanner(System.in);
    long N = sc.nextLong();

    long row = (long) Math.pow(2, N) + 1;

    System.out.println(row * row);
  }
}
