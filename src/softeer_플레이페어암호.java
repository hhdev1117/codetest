import java.util.*;
import java.io.*;


public class softeer_플레이페어암호
{
  static List<Boolean> encCheckList = new ArrayList<>();
  public static void main(String args[]) throws Exception
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String plaintext = br.readLine();
    String key = br.readLine();

    char[] alphaMap = new char[91];
    char[][] keyMap = new char[5][5];
    List<List<Character>> plainMap = new ArrayList<>();
    List<Character> keyList = new ArrayList<>();

    for(int i = 65; i < 91; i++) {
      if(i == 'J') {
        alphaMap[i] = 0;
      } else {
        alphaMap[i] = (char) i;
      }
    }

    for(int i = 0; i < key.length(); i++) {
      char a = key.toCharArray()[i];
      if(alphaMap[a] > 0) {
        keyList.add(a);
        alphaMap[a] = 0;
      }
    }

    int index = 0;
    for(int i = 0; i < 5; i++) {
      for(int j = 0; j < 5; j++) {
        if(index < keyList.size()) {
          keyMap[i][j] = keyList.get(index++);
        } else {
          for(int k = 65; k < alphaMap.length; k++) {
            if(alphaMap[k] >= 'A') {
              keyMap[i][j] = alphaMap[k];
              alphaMap[k] = 0;
              break;
            }
          }
        }
      }
    }

    index = 0;
    List<Character> twinList = new ArrayList<>();
    while(index < plaintext.length()) {
      char a = plaintext.toCharArray()[index];
      if(twinList.isEmpty()) {
        twinList.add(a);
        index++;
      } else {
        if(twinList.get(0) == a) {
          if(twinList.get(0) == 'X') {
            twinList.add('Q');
          } else {
            twinList.add('X');
          }
        } else {
          twinList.add(a);
          index++;
        }
        plainMap.add(twinList);
        twinList = new ArrayList<>();
      }

    }

    if(!twinList.isEmpty()) {
      twinList.add('X');
      plainMap.add(twinList);
    }

    for(int i = 0; i < plainMap.size(); i++) {
      encCheckList.add(false);
    }

    for(int i = 0; i < plainMap.size(); i++) {
      plainMap.set(i, enc1(plainMap.get(i), keyMap, encCheckList, i));
      if(!encCheckList.get(i)) {
        plainMap.set(i, enc2(plainMap.get(i), keyMap, encCheckList, i));
      }
      if(!encCheckList.get(i)) {
        plainMap.set(i, enc3(plainMap.get(i), keyMap, encCheckList, i));
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < plainMap.size(); i++) {
      sb.append(plainMap.get(i).get(0)).append(plainMap.get(i).get(1));
    }

    System.out.println(sb.toString());
  }

  public static List<Character> enc1(List<Character> twinList, char[][] keyMap, List<Boolean> encCheckList, int index) {

    List<Character> encList = new ArrayList<>();
    encList.add('0');
    encList.add('0');

    for(int i = 0; i < 5; i++) {
      boolean a = false;
      boolean b = false;
      for(int j = 0; j < 5; j++) {
        if(keyMap[i][j] == twinList.get(0)) {
          a = true;
          if(j > 3) {
            encList.set(0, keyMap[i][0]);
          } else {
            encList.set(0, keyMap[i][j+1]);
          }
        }
        if(keyMap[i][j] == twinList.get(1)) {
          b = true;
          if(j > 3) {
            encList.set(1, keyMap[i][0]);
          } else {
            encList.set(1, keyMap[i][j+1]);
          }
        }
      }

      if(a) {
        if(b) {
          encCheckList.set(index, true);
          return encList;
        }
      }

    }

    return twinList;
  }

  public static List<Character> enc2(List<Character> twinList, char[][] keyMap, List<Boolean> encCheckList, int index) {
    List<Character> encList = new ArrayList<>();
    encList.add('0');
    encList.add('0');

    for(int i = 0; i < 5; i++) {
      boolean a = false;
      boolean b = false;
      for(int j = 0; j < 5; j++) {
        if(keyMap[j][i] == twinList.get(0)) {
          a = true;
          if(j > 3) {
            encList.set(0, keyMap[0][i]);
          } else {
            encList.set(0, keyMap[j+1][i]);
          }
        }
        if(keyMap[j][i] == twinList.get(1)) {
          b = true;
          if(j > 3) {
            encList.set(1, keyMap[0][i]);
          } else {
            encList.set(1, keyMap[j+1][i]);
          }
        }
      }

      if(a) {
        if(b) {
          encCheckList.set(index, true);
          return encList;
        }
      }

    }

    return twinList;
  }

  public static List<Character> enc3(List<Character> twinList, char[][] keyMap, List<Boolean> encCheckList, int index) {
    List<Character> encList = new ArrayList<>();
    encList.add('0');
    encList.add('0');
    int a_i = 6;
    int a_j = 6;
    int b_i = 6;
    int b_j = 6;

    for(int i = 0; i < 5; i++) {
      for(int j = 0; j < 5; j++) {
        if(keyMap[i][j] == twinList.get(0)) {
          a_i = i;
          a_j = j;
        }
        if(keyMap[i][j] == twinList.get(1)) {
          b_i = i;
          b_j = j;
        }
      }

      if(a_i < 6) {
        if(b_i < 6) {
          encList.set(0, keyMap[a_i][b_j]);
          encList.set(1, keyMap[b_i][a_j]);
          return encList;
        }
      }
    }

    return twinList;
  }

}