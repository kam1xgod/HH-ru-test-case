import java.util.Scanner;

public class testCase {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    int n = Integer.parseInt(str.split(" ")[0]);
    int m = Integer.parseInt(str.split(" ")[1]);
    int s = Integer.parseInt(str.split(" ")[2]);

    if (n <= 0 && m <= 0) {
      System.out.println(0);
      scanner.close();
      System.exit(0);
    }
      
    int[] a = new int[n];
    int[] b = new int[m];

    for (int i = 0; i < Math.max(m, n); i++) {
      str = scanner.nextLine();
      if (i < n) {
        a[i] = Integer.parseInt(str.split(" ")[0]) + ((i - 1 >= 0) ? a[i - 1] : 0);
      }
      if (i < m) {
        b[i] = Integer.parseInt(str.split(" ")[1]) + ((i - 1 >= 0) ? b[i - 1] : 0);
      }
    }
    
    if (a[0] > s && b[0] > s) {
      System.out.println(0);
      scanner.close();
      System.exit(0);
    }

    int steps = 0;

    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < b.length; j++) {
        if (a[i] + b[j] <= s && i + j + 2 > steps) {
          steps = i + j + 2;
        }
      }
    }

    // int optimalPathForA = getOptimalPath(a, s);
    // int optimalPathForB = getOptimalPath(b, s);
    //
    // optimalPathForA += addIfPossible(a[optimalPathForA], b, s) + 1;
    // optimalPathForB += addIfPossible(b[optimalPathForB], a, s) + 1;
    //
    // System.out.println(Math.max(optimalPathForA, optimalPathForB));
    System.out.println(steps);
    scanner.close();
  }

  public static int getOptimalPath(int[] array, int s) {
    int result = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] <= s) {
        result = i;
      }
    }
    return result;
  }

  public static int addIfPossible(int currentSum, int[] array, int s) {
    int result = 0;
    for (int i = 0; i < array.length; i++) {
      if (currentSum + array[i] <= s) {
        result++;
      }
    }
    return result;
  }
}
