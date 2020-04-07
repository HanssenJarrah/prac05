package matrix;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A generic 2D-matrix.
 * @param <T> the cell type.
 */
public class Matrix<T> implements Iterable<T> {
    private ArrayList<ArrayList<T>> matrix;
    private int[] size;
    /**
     * Constructs a Matrix.
     *
     * @param rows - the number of rows.
     * @param columns - the number of columns.
     */
    public Matrix(int rows, int columns) {
        size = new int[]{rows, columns};
        matrix = new ArrayList<ArrayList<T>>(rows);

        for (int i = 0; i < rows; i++)
        {
            matrix.add(new ArrayList<T>(columns));
        }

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                matrix.get(i).add(null);
            }
        }
    }

    /**
     * Assigns a value to a given cell, specified by its row, column coordinates.
     *  @param row - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @param value - the value to be assigned to the given cell.
     */
    public void insert(int row, int column, T value) {
        matrix.get(row).set(column, value);
    }

    /**
     * Gets the value at a given cell, specified by its row, column coordinates.
     *
     * @param row - the row index with 0-based indexing.
     * @param column - the column index with 0-based indexing.
     * @return the value located at the given cell.
     */
    public T get(int row, int column) {
        return matrix.get(row).get(column);
    }

    /**
     * Gets the total number of cells in the matrix.
     *
     * @return an int equal to the total number of cells in the matrix.
     */
    public int[] size() {
        return size;
    }

    /**
     * Converts the matrix to String format.
     *
     * @return a String representation of the matrix.
     */
    public String toString() {
        StringBuilder matrixStr = new StringBuilder();
        for (ArrayList<T> row : matrix)
        {
            for (T col : row) {
                matrixStr.append(col.toString()).append(" ");
            }
            matrixStr.append("\n");
        }
        return matrixStr.toString();
    }

    /**
     * Gets an iterator for the matrix. The iterator follows column-major order.
     *
     * @return an iterator for the matrix.
     */
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            final int rows = size[0];
            final int cols = size[1];

            int row = 0;
            int col = 0;
            public boolean hasNext() {
                return col < cols;
            }

            public T next() {
                T result = matrix.get(row++).get(col);
                if (row == rows) {
                    row = 0;
                    col++;
                }
                return result;
            }
        };
    }
}