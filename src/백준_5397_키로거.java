import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_5397_키로거 {

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Stack<String> stack;
    Stack<String> stackTemp;

    StringBuilder sb;

    int cnt = Integer.parseInt(br.readLine());
    String[] commArray = new String[cnt];

    for(int i = 0; i < cnt; i++) commArray[i] = br.readLine();

    for(int i = 0; i < cnt; i++) {
      stack = new Stack<>();
      stackTemp = new Stack<>();
      sb = new StringBuilder();
      String comm = commArray[i];

      for(String str : comm.split("")) {
        if(str.equals("<")) {
          if(!stack.isEmpty()) {
            stackTemp.push(stack.pop());
          }
        } else if(str.equals(">")) {
          if(!stackTemp.isEmpty()) {
            stack.push(stackTemp.pop());
          }
        } else if(str.equals("-")) {
          if(!stack.isEmpty()) {
            stack.pop();
          }
        } else {
          stack.push(str);
        }
      }

      while(!stack.isEmpty()) stackTemp.push(stack.pop());
      while(!stackTemp.isEmpty()) sb.append(stackTemp.pop());
      System.out.println(sb.toString());
    }
  }
}
