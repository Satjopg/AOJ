import java.util.Scanner;

public class ITP1_2_C {

  static int[] sort(int[] progression) {

    int min, temp;
    min = temp = 0;

    for (int i = 0; i < progression.length - 1 ; i++ ) {
      min = i;
      for (int j = i + 1; j < progression.length ; j++ ) {
        if ( progression[min] > progression[j] ) {
          min = j;
        }
      }
      temp = progression[i];
      progression[i] = progression[min];
      progression[min] = temp;
    }
    return progression;
  }

  public static void main(String[] args) {
    Scanner stdIn = new Scanner(System.in);
    int progression[] = new int[3];
    for (int i = 0;i < 3 ;i++) {
      progression[i] = stdIn.nextInt();
    }

    progression = sort(progression);

    System.out.println(progression[0]+" "+progression[1]+" "+progression[2]);
  }
}
