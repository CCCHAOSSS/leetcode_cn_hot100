public class WordSearch {

    public static void main(String[] args) {

    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean res = check(board, word, 0, i, j, visited);
                if (res) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean check(char[][] board, String word, int idx, int row, int col, boolean[][] visited) {
        if (board[row][col] != word.charAt(idx)) {
            return false;
        }else if (idx == word.length() - 1) {
            return true;
        }

        visited[row][col] = true;
        int[] rows = {0, 0, 1, -1};
        int[] cols = {1, -1, 0, 0};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int newi = row + rows[i];
                int newj = col + cols[i];
                if (newi >0 && newi < board.length && newj > 0 && newj < board[0].length ) {
                    boolean res = check(board, word, idx + 1, newi, newj, visited);
                    if (res) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
