import java.util.*;

public class Board {
    private int n;
    private char [][] theboard;
    private List<int[]> moves;

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

    public void fillintable () {
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                char temp ;
                String asker = String.format("Item at position at column: %d, row: %d", i, j);

                System.out.println(asker);
                Scanner sc = new Scanner(System.in);
                temp = sc.next().charAt(0);
                if (temp == 'x') {
                    int[] coor = new int[2];
                    coor[0] = i;
                    coor[1] = j;
                    moves.add(coor);
                }
                while (temp != '1'&& temp != '0' && temp != 'x') {
                    System.out.println("invalid input");
                    temp = sc.next().charAt(0);
                }
                filltoken(i, j, temp);
                System.out.println(Arrays.deepToString(theboard).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
            }

        }
    }

    public void fillintokensplit () {
        char[][] sampleboard = new char[4][4];
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
//                System.out.println("Invalid Board");
//                System.out.println("Please try again");
//                input = sc.nextLine();
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


    public void printbeginning () {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Board-size");
       n = sc.nextInt();
    }

    public static void main(String[] args) {
        System.out.println("Enter Board-size");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Board board = new Board(n);
        board.printemptyboard();
        board.fillintokensplit();
    }
}
