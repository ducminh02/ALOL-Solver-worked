import java.util.*;

public class Board {
    private final int n;
    private final char [][] theboard;
    private final List<int[]> moves;

    // Constructor
    public Board (int n) {
        if (n < 1 || n > 15 || n % 2 == 1) {
            throw new InputMismatchException("Invalid Board-size ");
        }
        this.n = n;
        this.theboard = new char [n][n];
        this.moves = new ArrayList<>();
    }

    public int getN() {
        return n;
    }

    public List<int[]> getMoves() {
        return moves;
    }

    public void setTheboard(Board boardd) {
    }

    public char[][] getTheboard() {
        return theboard;
    }

    public void filltoken (int i, int j , char token) {
        theboard[i][j] = token;
    }



    public void printemptyboard (){
        char[][] emptyboard= new char[n][n];

        String str1 = String.format("Creating %d x %d Board", n, n);
        System.out.println(str1);
        System.out.println("x = Empty Space");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                emptyboard[i][j] = 'x';
            }
        }
        System.out.println(Arrays.deepToString(emptyboard).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
        System.out.println("\n");
    }



    public void fillintokensplit () {
        String input;

        // Displaying Msg
        System.out.println("Insert a board here:");
        System.out.println("e.g 10x1/xx10/1x0x/0011");

        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        for (int i = 0; i < n; i++) {
            String[] lines = input.split("/");

            // if nums of lines doesnt match n
            if (lines.length != n) {
                throw  new InputMismatchException("Invalid Board");

            }
            for (int j = 0; j < n; j++) {
                char[] tokens = lines[j].toCharArray();

                // if nums of columns doesnt match n
                if (tokens.length != n) {
                    throw  new InputMismatchException("Invalid Board");

                }
                for (int k = 0; k < tokens.length; k++) {
                    if (tokens[k] != '1' && tokens[k] != '0' && tokens[k] != 'x') {
                        throw  new InputMismatchException("Invalid Board");

                    }
                    filltoken(j,k, tokens[k]);
                }
            }
        }
        System.out.println(Arrays.deepToString(theboard).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
    }

}
