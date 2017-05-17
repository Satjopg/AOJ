import java.util.Scanner;

class Q02 {

  private static int count = 0;
  private static int size = 0;
  private static int pos_x = 0;
  private static int pos_y = 0;
  private static int start_x = 0;
  private static int start_y = 0;

  private static void initArray(String[][] swirl) {
    for(int i = 0;i < swirl.length;i++) {
      for(int j = 0;j < swirl[i].length;j++) {
        swirl[i][j] = " ";
      }
    }
  }

  private static boolean up(String[][] swirl) {
    start_x = pos_x;
    start_y = pos_y;
    if(count == 0) {
      while(true) {
        swirl[pos_y][pos_x] = "*";
        if(pos_y == 0) {
          break;
        }
        pos_y--;
      }
      return true;
    } else {
      while(true){
        if(swirl[pos_y-2][pos_x] == " ") {
          swirl[pos_y-1][pos_x] = "*";
          pos_y--;
        } else {
          break;
        }
      }
      if((start_y - pos_y) >= 2) {
        return true;
      } else {
        return false;
      }
    }
  }

  private static boolean right(String[][] swirl) {
    start_x = pos_x;
    start_y = pos_y;
    if(count == 0) {
      while(true) {
        swirl[pos_y][pos_x] = "*";
        if(pos_x == size - 1) {
          break;
        }
        pos_x++;
      }
      return true;
    } else {
      while(true){
        if(swirl[pos_y][pos_x+2] == " ") {
          swirl[pos_y][pos_x+1] = "*";
          pos_x++;
        } else {
          break;
        }
      }
      if((pos_x - start_x) >= 2) {
        return true;
      } else {
        return false;
      }
    }
  }

  private static boolean down(String[][] swirl) {
    start_x = pos_x;
    start_y = pos_y;
    if(count == 0) {
      while(true) {
        swirl[pos_y][pos_x] = "*";
        if(pos_y == (size - 1)) {
          break;
        }
        pos_y++;
      }
      return true;
    } else {
      while(true){
        if(swirl[pos_y+2][pos_x] == " ") {
          swirl[pos_y+1][pos_x] = "*";
          pos_y++;
        } else {
          break;
        }
      }
      if((pos_y - start_y) >= 2) {
        return true;
      } else {
        return false;
      }
    }
  }

  private static boolean left(String[][] swirl) {
    start_x = pos_x;
    start_y = pos_y;
    while(true){
      if(swirl[pos_y][pos_x-2] == " ") {
        swirl[pos_y][pos_x-1] = "*";
        pos_x--;
      } else {
        break;
      }
    }
    if((start_x - pos_x) < 2) {
      return false;
    }
    return true;
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    size = stdIn.nextInt();
    stdIn.close();
    String[][] swirl = new String[size][size];
    initArray(swirl);
    pos_y = size - 1;

    while(true) {
      if(!up(swirl)) break;
      System.out.println(pos_y+" "+pos_x);
      if(!right(swirl)) break;
      System.out.println(pos_y+" "+pos_x);
      if(!down(swirl)) break;
      System.out.println(pos_y+" "+pos_x);
      count++;
      if(!left(swirl)) break;
      System.out.println(pos_y+" "+pos_x);
    }

    for(int i = 0;i < swirl.length;i++) {
      for(int j = 0;j < swirl[i].length;j++) {
        System.out.print(swirl[i][j]);
      }
      System.out.println();
    }

  }
}
