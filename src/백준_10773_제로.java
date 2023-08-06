import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_10773_제로 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Integer> stack = new Stack<>();

    int answer = 0;
    int K = Integer.parseInt(br.readLine());

    for(int i = 0; i < K; i++) {
      int money = Integer.parseInt(br.readLine());

      if(money > 0) {
        stack.push(money);
      } else {
        if(!stack.isEmpty()) stack.pop();
      }
    }

    while(!stack.isEmpty()) {
      answer += stack.pop();
    }

    System.out.println(answer);
  }
}
