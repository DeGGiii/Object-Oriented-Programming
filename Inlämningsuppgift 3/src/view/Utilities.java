//För VG
package view;

import java.util.Scanner;

public class Utilities
{
    //Print a number chars on a line to the consol
    //chr - char to write
    //count - number of chars to print.
    public static void padChars(char chr, int count)
    {
        for (int i= 0; i < count; i++)
            System.out.print(chr);
        System.out.println();
    }

    //Fetch a valid whole number from the Consol/Terminal.
    //The number must be between lowLimit and upperLimit incl these.
    public static int getInteger(int lowLimit, int upperLimit)
    {

        String str = String.format("Ange ett heltal mellan %d och %d", lowLimit, upperLimit);
        System.out.println(str);

        int number = 0;
        boolean goodNumber = false;

        Scanner reader = new Scanner(System.in);
        do
        {
            System.out.println();;
            number = reader.nextInt();

            goodNumber = (number >= lowLimit) && (number <= upperLimit);
            if (!goodNumber)
                System.out.println("Ogiltigt nummer. Försök igen!");

        } while ( !goodNumber);

        // reader.close();
        return number;
    }

    //Fetch a line of chars (a String) from the Consol/Terminal.
    //Validate so the string is not null and not empty
    // (when the user presses the Return key).
    // The string is cleared of the beginning and trailing
    // spaces.
    public static String getString()
    {
        Scanner reader = new Scanner(System.in);
        boolean done = true;
        String str = "";

        do
        {
            done = reader.hasNextLine();

            if (done)
            {
                str = reader.nextLine();
                //delete spaces from the ends of the string
                str = str.trim();

                done = !(str.isEmpty() || str.isBlank());
            }
            else
                System.out.println("Ge en giltig sträng!");

        }while (!done);
        return str;
    }

}
