import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 백준_1434_책정리 {

  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    int M = sc.nextInt();
    List<Integer> boxList = new ArrayList<>();
    List<Integer> bookList = new ArrayList<>();

    for(int i = 0; i < N; i++) boxList.add(sc.nextInt());
    for(int i = 0; i < M; i++) bookList.add(sc.nextInt());

    int boxIndex = 0;
    int answer = 0;

    for(int i = 0; i < M; i++) {
      int book = bookList.get(i);
      if(boxList.get(boxIndex) >= book) {
        boxList.set(boxIndex, boxList.get(boxIndex) - book);
      } else {
        boxIndex++;
        boxList.set(boxIndex, boxList.get(boxIndex) - book);
      }
    }

    for(int i = 0; i < boxList.size(); i++) answer += boxList.get(i);

    System.out.println(answer);

  }
}
