import java.util.Scanner;

public class softeer_비밀메뉴 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    String MNK = sc.nextLine();
    String mString = sc.nextLine();
    String nString = sc.nextLine();

    System.out.println(nString.indexOf(mString.toString()) > -1 ? "secret" : "normal");
  }
}
