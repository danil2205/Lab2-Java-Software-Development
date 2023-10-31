/*
1131 - zalikova
1131 % 5 = 1 => C=B^T
1131 % 7 = 4 => long
1131 % 11 = 9 => Знайти середнє значення елементів кожного стовпчика матриця
*/

public class Lab2 {
  public static void showMatrix(long[][] matrix) {
    for (long[] row : matrix) {
      for (long el : row) {
        System.out.printf("%s \t", el);
      }
      System.out.print("\n");
    }
  }

  public static boolean isRectMatrix(long[][] matrix) {
    int cols = matrix[0].length;

    for (long[] row : matrix) {
      if (row.length != cols) {
        return false;
      }
    }
    return true;
  }

  public static long[][] transposeMatrix(long[][] matrix) {
    int rows = matrix.length;
    int cols = matrix[0].length;

    long [][]matrixT = new long [cols][rows];

    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        matrixT[j][i] = matrix[i][j];
      }
    }

    return matrixT;
  }

  public static void avgEachCol(long[][] matrix) {
    try {
      for (int i = 0; i < matrix[0].length; i++) {
        double sum = 0;
        for (long[] longs : matrix) {
          sum += longs[i];
        }
        System.out.printf("\tAverage value of column %d is %.2f\n", i+1, sum / matrix.length);
      }
    } catch (Exception error) {
      System.out.printf("Error while calculating average of column: %s", error.getMessage());
    }
  }

  public static void main(String[] args) {
    long [][]matrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16},
    };

//    long [][]matrix = {
//            {1, 2, 3, 4, 5, 6},
//            {7, 8, 9, 10, 11, 12},
//            {13, 14, 15, 16, 17, 18},
//            {19, 20, 21, 22, 23, 24},
//    };

    System.out.println("Matrix:");
    Lab2.showMatrix(matrix);

    if (!Lab2.isRectMatrix(matrix)) {
      System.out.println("You cannot transpose this matrix");
      return;
    }

    long[][] transposedMatrix = Lab2.transposeMatrix(matrix);

    System.out.println("\nMatrix T:");
    Lab2.showMatrix(transposedMatrix);

    System.out.println("\nThe average value of the elements of each column of the matrix:");
    Lab2.avgEachCol(transposedMatrix);

  }
}
