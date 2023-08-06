import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 백준_9012_괄호 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack;

    List<String> textList = new ArrayList<>();
    int T = Integer.parseInt(br.readLine());
    for(int i = 0; i < T; i++) textList.add(br.readLine());

    for(int i = 0; i < T; i++) {
      stack = new Stack<>();
      String text = textList.get(i);

      for(int j = 0; j < text.length(); j++) {
        char c = text.charAt(j);

        if(c == '(') {
          stack.push(c);
        } else {
          if(!stack.isEmpty()) {
            stack.pop();
          } else {
            System.out.println("NO");
            break;
          }
        }

        if(j >= text.length() - 1) {
          if(stack.isEmpty()) {
            System.out.println("YES");
          } else {
            System.out.println("NO");
          }
        }
      }
    }

  }
}
