import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 백준_4949_균형잡힌세상 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Stack<Character> stack;

    while(true) {
      stack = new Stack<>();
      String text = br.readLine();
      if(text.equals(".")) break;

      for(char a : text.toCharArray()) {
        if (a == '(' || a == '[') {
          stack.push(a);
        } else if(a == ')') {
          if(stack.isEmpty()) {
            System.out.println("no");
            break;
          }
          if(stack.pop() != '(') {
            System.out.println("no");
            break;
          }
        } else if(a == ']') {
          if(stack.isEmpty()) {
            System.out.println("no");
            break;
          }
          if(stack.pop() != '[') {
            System.out.println("no");
            break;
          }
        } else if(a == '.') {
          if(stack.isEmpty()) System.out.println("yes");
          else System.out.println("no");
          break;
        }
      }
    }
  }
}
