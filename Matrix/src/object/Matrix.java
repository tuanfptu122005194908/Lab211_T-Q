package object;

public class Matrix {

    private int row;  // so hang cua ma tran
    private int col; // so cot cua ma tran
    private int[][] data;  // mang 2 chieu luu tru du lieu cua ma tran

    // constructor
    public Matrix(int row, int col) {
        this.row = row;
        this.col = col;
        this.data = new int[row][col];
    }

    public int getCol() {
        return col;
    }

    public int[][] getData() {
        return data;
    }

    public int getRow() {
        return row;
    }

    public void setValue(int row, int col, int value) {
        this.data[row][col] = value;
    }

    public int getValue(int row, int col) {
        return this.data[row][col];
    }

    public void display() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print("[" + data[i][j] + "]");  // in toan bo ma tran theo dang bang
            }
            System.out.println();
        }
    }
}
