import java.util.*;

public class Logic {
    private Board board;


    public Logic (Board board) {
        this.board= board;

    }
    // Hilffunktionen

    public char[] getColumn (char[][] arr, int index) {
        char[] column = new char[arr[0].length];
        for (int i = 0; i < column.length; i++) {
            column[i] = arr[i][index];
        }
        return column;
    }

    // check if there are 3 0's or 1's found on the board
    public void checkrule3 () {
        if (board.getN() >= 3) {
            for (int i = 0; i < board.getN() ; i++) {
                for (int j = 0; j < board.getN() - 2; j++) {
                    if (board.getTheboard()[i][j] == board.getTheboard()[i][j+1] &&
                            board.getTheboard()[i][j+1] == board.getTheboard()[i][j+2]
                    && board.getTheboard()[i][j] != 'x') {
                        throw new InputMismatchException("3 consecutive numbers found");
                    }
                }
            }

            for (int i = 0; i < board.getN() -2; i++) {
                for (int j = 0; j < board.getN(); j++) {
                    if (board.getTheboard()[i][j] == board.getTheboard()[i+1][j] &&
                        board.getTheboard()[i+1][j] == board.getTheboard()[i+2][j]
                        && board.getTheboard()[i][j] != 'x') {
                        throw new InputMismatchException("3 consecutive numbers found");

                    }
                }
            }
        }
    }
    // check if there are the same number of 1's and 0's on the board
    public void checkrule1 () {
        for (int i = 0; i < board.getN(); i++) {
            int count0 = 0;
            int count1 = 0;

            for (int j = 0; j < board.getN(); j++) {
                if (board.getTheboard()[i][j] == '0') {
                    count0++;
                }

                if (board.getTheboard()[i][j] == '1') {
                    count1++;
                }
            }
            if (count0 > board.getN()/2 || count1 > board.getN()/2) {
                throw new InputMismatchException("Numbers of 0's and 1's on the same row are not the same");
            }
        }

        for (int i = 0; i < board.getN(); i++) {
            int count0 = 0;
            int count1 = 0;

            for (int j = 0; j < board.getN(); j++) {
                if (board.getTheboard()[j][i] == '0') {
                    count0++;
                }

                if (board.getTheboard()[j][i] == '1') {
                    count1++;
                }
            }
            if (count0 > board.getN()/2 || count1 > board.getN()/2) {
                throw new InputMismatchException("Numbers of 0's and 1's on the same row are not the same");
            }
        }

    }

    // Check for duplicate Rows or Column
    public void checkrule2 () {
        Map<String, Integer> checker = new HashMap<>();

        for (char[] x: board.getTheboard()) {
            String convert = Arrays.toString(x);
            if(!checker.containsKey(convert) || convert.contains("x")) {
                boolean a = checker.containsKey(convert);
                checker.put(convert, 1);
            }
            else {
                String str = "At least 2 duplicate rows found";
                throw new InputMismatchException(str);
            }
        }


        Map<String, Integer> checker2 = new HashMap<>();

        for (int i = 0; i < board.getN(); i++) {
            char[] tempcoloumn = getColumn(board.getTheboard(), i);
            String convert = Arrays.toString(tempcoloumn);
            if (!checker2.containsKey(convert) || convert.contains("x")) {
                checker2.put(convert, 1);
            }
            else {
                String str = "At least 2 duplicate column found";
                throw new InputMismatchException(str);
            }
        }
    }

    public void check2op () {
        HashSet<char[]> checker = new HashSet<>();
        for (int i = 0; i < board.getN(); i++) {
            char[] a = board.getTheboard()[i];
            checker.add(a);
        }

        if (checker.size() != board.getN()) {
            String str = "At least 2 duplicate rows found";
            throw new InputMismatchException(str);
        }
    }
    public void checkall() {
        checkrule1();
        checkrule2();
//        check2op();
        checkrule3();
    }

    public static void main(String[] args) {
        System.out.println("Enter Board-size");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Board board = new Board(n);

        board.printemptyboard();
//        board.fillintable();
        board.fillintokensplit();

        Logic logic = new Logic(board);
        System.out.println("Checking if board is valid...");
        logic.checkall();
        System.out.println("Board is valid");
        System.out.println(board.getMoves());
    }


}
