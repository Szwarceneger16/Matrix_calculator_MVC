package szwarcgrzegorz.matrixcalculator.model;

public class Matrix{
    private int[][] matrix;
    private int rows;
    private int columns;
    String name;

    public Matrix(int r,int c,String name) {
        this.rows = r;
        this.columns = c;
        matrix = new int[r][c];
        this.name = name;
    }

    public Matrix(Matrix another){
        this.rows = another.rows;
        this.columns = another.columns;
        this.matrix = new int[this.rows][this.columns];
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                this.matrix[i][j] = another.matrix[i][j];
            }
        }
        this.name = another.name;
    }

    public void setElement(int row,int column, int value) {
        matrix[row][column] = value;
    }

    public void addElement(int row,int column, int value) {
        matrix[row][column] += value;
    }

    public int getElement(int row,int column) {
        return matrix[row][column];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public String getName() {
        return name;
    }
}