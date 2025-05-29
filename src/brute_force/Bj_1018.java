package brute_force;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj_1018 {
    private static final char WHITE = 'W';
    private static final char BLACK = 'B';

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] boardSizeInput = bf.readLine().split(" ");
        int boardHeight = Integer.parseInt(boardSizeInput[0]);
        int boardWidth = Integer.parseInt(boardSizeInput[1]);
        char[][] boardCells = new char[boardHeight][boardWidth];
        int minRepaintCount = 1000;

        for (int i = 0; i < boardHeight; i++) {
            boardCells[i] = bf.readLine().toCharArray();
        }

        for (int i = 0; i < boardHeight - 7; i++) {
            for (int j = 0; j < boardWidth - 7; j++) {
                minRepaintCount = Math.min(minRepaintCount, getRepaintCount(i, j, boardCells, true));
                minRepaintCount = Math.min(minRepaintCount, getRepaintCount(i, j, boardCells, false));
            }
        }

        System.out.println(minRepaintCount);
    }

    private static int getRepaintCount(int startYIndex, int startXIndex, char[][] boardCells, boolean isWhiteLocate) {
        int repaintCount = 0;

        for (int i = startYIndex; i < startYIndex + 8; i++) {
            for (int j = startXIndex; j < startXIndex + 8; j++) {
                if (isWhiteLocate && boardCells[i][j] == BLACK || !isWhiteLocate && boardCells[i][j] == WHITE) {
                    repaintCount++;
                }

                isWhiteLocate = !isWhiteLocate;
            }

            isWhiteLocate = !isWhiteLocate;
        }

        return repaintCount;
    }
}