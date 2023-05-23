/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package partyController;

import java.util.Scanner;

public class MainProgram
{
    public static void main(String[] args)
    {

        // En scanner som frågar om antalet gäster i listan.
        Scanner input = new Scanner(System.in);
        System.out.println("Please chose the total number of guests: ");
        int maxNbrOfGuests = input.nextInt();


        Controller controller = new Controller(maxNbrOfGuests);
    }
}
