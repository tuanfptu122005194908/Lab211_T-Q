
package manager;

import object.*;

public class MatrixManager {

    // Cong ma tran
    public static Matrix addMatrix(Matrix m1, Matrix m2) {
        if (m1.getRow() != m2.getRow() || m1.getCol() != m2.getCol()) {
            System.out.println("Addition not possible: matrix sizes do not match.");
            return null;
        }
        Matrix res = new Matrix(m1.getRow(), m1.getCol());
        for (int i = 0; i < m1.getRow(); i++) {
            for (int j = 0; j < m2.getCol(); j++) {
                res.setValue(i, j, m1.getValue(i, j) + m2.getValue(i, j));
            }
        }
        return res;
    }
    // Trừ ma trận
    public static Matrix subtractionMatrix(Matrix m1, Matrix m2) {
        if (m1.getRow() != m2.getRow() || m1.getCol() != m2.getCol()) {
            System.out.println("Subtraction not possible: matrix sizes do not match.");
            return null;
        }
        Matrix result = new Matrix(m1.getRow(), m1.getCol());
        for (int i = 0; i < m1.getRow(); i++) {
            for (int j = 0; j < m1.getCol(); j++) {
                result.setValue(i, j, m1.getValue(i, j) - m2.getValue(i, j));
            }
        }
        return result;
    }

    // Nhân ma trận
    public static Matrix multiplicationMatrix(Matrix m1, Matrix m2) {
        if (m1.getCol() != m2.getRow()) {
            System.out.println("Multiplication not possible: m1 columns != m2 rows.");
            return null;
        }
        Matrix result = new Matrix(m1.getRow(), m2.getCol());
        for (int i = 0; i < m1.getRow(); i++) {
            for (int j = 0; j < m2.getCol(); j++) {
                int sum = 0;
                for (int k = 0; k < m1.getCol(); k++) {
                    sum += m1.getValue(i, k) * m2.getValue(k, j);
                }
                result.setValue(i, j, sum);
            }
        }
        return result;
    }
}
