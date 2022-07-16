
//DAA Mini Application
import java.util.Scanner;

public class DAA {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        // FOR LOGIC
        int arr[][] = new int[n][m];
        int display[][] = new int[n][m];

        int count = 0; // For counting number of bullets
        int row = 0, col = 0; // For current position of boy
        int ro = 0, co = 0; // For first position of boy
        int inr = 0, inc = 0; // For previous position of boy

        // Inputting Structure of an island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // Copying arr into display
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                display[i][j] = arr[i][j];
            }
        }

        // For Finding Boy Position which is 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    row = i;
                    col = j;
                    ro = i;
                    co = j;
                    break;
                }
            }
        }

        // s is the starting point of small matrix and it is the minimum no. of bullets
        // to kill zombie
        int s = arr[row - 1][col - 1];

        // while boy is not at border
        while (row != 0 && col != 0 && row != n - 1 && col != m - 1) {
            int c = 0;

            // For finding smallest no. surrounding of boy
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if ((i == row && j == col) || (i == ro && j == co) || (i == inr && j == inc)) {
                        continue;
                    }

                    if (arr[i][j] < s) {
                        s = arr[i][j];
                    }
                }
            }

            // We got smallest no and we add it to answer
            count += s;

            // Now we have to find new boy's position here
            for (int i = row - 1; i <= row + 1; i++) {
                for (int j = col - 1; j <= col + 1; j++) {
                    if (i == row && j == col) {
                        continue;
                    }

                    if (arr[i][j] == s) {
                        display[i][j] = 0;
                        row = i;
                        col = j;
                        inr = i;
                        inc = j;
                        c = 1;
                        break;
                    }
                }

                if (c == 1) {
                    break;
                }
            }

            // IF boy's position is not at border
            if (row != 0 && col != 0 && row != n - 1 && col != m - 1) {
                s = arr[row - 1][col - 1];
            }

        }

        
        // DISPLAY OUTPUT
        
        // Prints display array
        System.out.println(ConsoleColors.BLUE+"He Finds the Path :");
        System.out.println();
        System.out.println();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (display[i][j] == 0) {
                    System.out.print("\t" + ConsoleColors.GREEN + arr[i][j]);  
                    Thread.sleep(1000);                  
                }
                else{
                    System.out.print("\t" + ConsoleColors.RED + arr[i][j]);  
                    Thread.sleep(1000);                  
                }

            }
            System.out.println();
            System.out.println();
        }
        
        
        // Prints Minimum number of bullets
        System.out.println();
        System.out.println(ConsoleColors.BLUE+"Minimum Number of Bullets Required : "+ConsoleColors.GREEN+count);
        System.out.println();
        System.out.println();
        System.out.println(ConsoleColors.WHITE);
    }
}