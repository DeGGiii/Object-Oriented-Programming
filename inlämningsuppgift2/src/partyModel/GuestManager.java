/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package partyModel;

import javax.swing.*;

public class GuestManager
{

  private Guest[] guestList;
  private int numOfElements;

  // Konstruktor med en parameter. Där antalet gäster defineras.
  public GuestManager(int maxElements)
  {
    this.guestList = new Guest[maxElements];
  }

  // en metod som lägger till en gäst ifall det finns plats, annars så får man fel meddelande.
  public void addGuest(Guest guest)
{

  if (numOfElements < guestList.length)
  {
    guestList[numOfElements] = guest;
    numOfElements++;
  } else {
    JOptionPane.showMessageDialog(null, "No space for a new guest! \n      Try removing one.");
    {

    }
  }


}

  // En metod som byter informationen av en gäst i listan.
  public void changeAt(int index, Guest guest)
  {
    guestList[index] = guest;
  }

  // En metod som ta bort en gäst från listan och därefter flyttar gästen ett steg
  // till vänster i arrayen för att fylla empty spaces.
  public boolean deleteAt(int index)
  {
    boolean success = true;

    if( index >= 0 && index < guestList.length)
    {

      moveElementsToLeft(index);
      numOfElements--;

    } else {

      success = false;
    }

    return success;
  }

  // En metod som då flytter gäster/gästen ett steg till vänster för att fylla empty spaces.
  private void moveElementsToLeft(int index)
  {
    for(int i = index+1; i < numOfElements; i++)
    {
      guestList[i-1] = guestList[i]; // Flyttar ett steg till vänster i arrayen

    }
  }

    // Den omvandlar alla elements i arrayen till en string.
  public String[] getInfoStrings()
  {
    String [] infoString = new String[numOfElements];
    for(int i = 0; i < numOfElements; i++){
      infoString[i] = guestList[i].toString();
    }
    return infoString;
  }

  //Getters.
  public Guest getGuestAt(int index)
  {
    this.guestList[index] = guestList[index];
    return guestList[index];
  }

  public int getNumOfGuests() {
    return numOfElements;
  }

}
