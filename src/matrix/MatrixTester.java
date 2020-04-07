package matrix;

public class MatrixTester {
    public static void main(String[] args) {
        int rows = 2;
        int cols = 2;
        Matrix<String> matrix = new Matrix<>(rows, cols);

        matrix.insert(0, 0, "a");
        matrix.insert(0, 1, "b");
        matrix.insert(1, 0, "c");
        matrix.insert(1, 1, "d");

        System.out.println(matrix.toString());
    }
}
