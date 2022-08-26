import java.util.*;

public class Board {
    private int n;
    private char [][] theboard;

    // Constructor
    public Board (int n) {
        if (n < 1 || n > 15) {
            throw new InputMismatchException("Invalid Board-size ");
        }
        this.n = n;
        this.theboard = new char [n][n];
    }

    public void filltoken (int i, int j , char token) {
        theboard[i][j] = token;
    }



    public void printemptyboard (){
        String str1 = String.format("Creating %d x %d Board", n, n);
        System.out.println(str1);
        System.out.println("x = Empty Space");
        System.out.println("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("x ");
            }
            System.out.print("\n");
        }
    }

    public void fillintable () {
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < n; j++) {
                char temp ;
                String asker = String.format("Item at position at column: %d, row: %d", i, j);

                System.out.println(asker);
                Scanner sc = new Scanner(System.in);
                temp = sc.next().charAt(0);
                while (temp != '1'&& temp != '0' && temp != 'x') {
                    System.out.println("invalid input");
                    temp = sc.next().charAt(0);
                }
                filltoken(i, j, temp);
                System.out.println(Arrays.deepToString(theboard).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));
            }

        }
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
        board.fillintable();
    }
}
