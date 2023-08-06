import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 백준_12789_도키도키간식드리미 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Stack<Integer> stack = new Stack<>();
    List<Integer> list = new ArrayList<>();
    int N = Integer.parseInt(br.readLine());
    String[] num = br.readLine().split(" ");

    String answer = "Sad";
    list.add(0);

    for(int i = 0; i < N; i++) {
      int number = Integer.parseInt(num[i]);

      if(list.get(list.size() - 1) + 1 == number) {
        list.add(number);

        while(!stack.isEmpty()) {
          if(stack.lastElement() == list.get(list.size() - 1) + 1) list.add(stack.pop());
          else break;
        }
      } else {
        stack.push(number);
      }
    }

    if(list.size() == N + 1) answer = "Nice";

    System.out.println(answer);
  }
}
