package board;

public class Board {
    public int size;
    public char matrix[][];

    public Board(int size, char symbol) {
        this.size = size;
        matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = symbol;
            }
        }
    }

    public void setDefaultSysmbol()  {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrix[i][j] = '-';
            }
        }
    }

    public void printBoardConfig() {
        int sz = this.size;
        for (int i = 0; i < sz; i++) {
            for (int j = 0; j < sz; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

}
