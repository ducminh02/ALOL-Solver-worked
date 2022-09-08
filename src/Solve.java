import java.util.*;

public class Solve {
    private final Board board;
    private final Logik logic;


    public Solve(Board board, Logik logic) {
        this.board = board;
        this.logic = logic;
    }

    public boolean isFull(Board boardd) {
        for (int i = 0; i < board.getN(); i++) {
            for (int j = 0; j < board.getN(); j++) {
                if (boardd.getTheboard()[i][j] == 'x') {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Character> possibleEntries(Board boardd, int i, int j) {
        List<Character> possibilities = new ArrayList<>();

        boardd.getTheboard()[i][j] = '0';

        if (logic.checkall(boardd)) {
            possibilities.add('0');
        }
        boardd.getTheboard()[i][j] = '1';
        if (logic.checkall(boardd)) {
            possibilities.add('1');
        }
        return possibilities;
    }

    public void magic (Board boardd) {
        int i = 0;
        int j = 0;
        List<Character> possibilities;

        if (isFull(boardd)) {
            board.setTheboard(boardd);
            System.out.println("Board solved!");
            System.out.println(Arrays.deepToString(board.getTheboard()).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        }
        else {
            for (int x = 0; x < boardd.getN(); x++) {
                for (int y = 0; y < boardd.getN(); y++) {
                    if (boardd.getTheboard()[x][y] == 'x') {
                        i = x;
                        j = y;
                        break;
                    }
                }
            }
            possibilities = possibleEntries(boardd, i , j);
            for (char c : possibilities ) {
                boardd.getTheboard()[i][j] = c;
                magic(boardd);
            }
            boardd.getTheboard()[i][j] = 'x';
        }

    }

    public static void main(String[] args) {
        System.out.println("Enter Board-size");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Board board = new Board(n);

        board.printemptyboard();

        board.fillintokensplit();

        Logik logic = new Logik(board);
        System.out.println("Checking if board is valid...");
        if (!logic.checkall(board)) {
            throw  new InputMismatchException("Invalid Board");
        }
        System.out.println("Board is valid");
        System.out.println(board.getMoves());
        Solve solve = new Solve(board, logic);
        solve.magic(board);

    }

}