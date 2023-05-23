/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package partyController;

import partyView.*;
import partyModel.*;

import javax.swing.*;

//You should not have to change any code in this class.
//Study it to see what methods are expected in class GuestManager, Guest and Address
public class Controller
{
    MainFrame view;
    GuestManager register;  //in package partyModel

    //constructor
    public Controller(int maxNbrOfGuests)
    {
        register = new GuestManager(maxNbrOfGuests);
        view = new MainFrame(this);
        view.updateGuestList(register.getInfoStrings());
    }

    //Denna metod anropas varje gång någon ändring av modelen sker
    private void updateView(int index)
    {
        Guest guest = register.getGuestAt(index);
        if (guest == null)
            return;
        view.setFirstNameText(guest.getFirstName());
    }

    //Denna metod anropas av view
    public void buttonPressed(ButtonType button)
    {
        Guest guest = null;

        int index =0;
        switch (button)
        {
            case Add:
                guest = getguestDataFrView();
                register.addGuest(guest);
                break;

            case Change:
                index =view.getListIndex();
                if (validateIndex(index))
                {
                    guest = getguestDataFrView();
                    register.changeAt(index, guest);
                }
                break;

            case Delete:
                index = view.getListIndex();
                if (validateIndex(index))
                    register.deleteAt(index); // = new guest();   //noll-ställ
                break;
        }
        int attendance = register.getNumOfGuests();
        view.setNumGuest(Integer.toString(attendance));
        view.updateGuestList(register.getInfoStrings());
    }
    private boolean validateIndex(int index)
    {
        boolean ok = true;
        if (index < 0)
        {
            JOptionPane.showMessageDialog(null, "Select an item in the list!");
            ok = false;
        }
        return ok;
    }
    public void guestTypeChanged(ButtonType button)
    {
        //nothing to do
    }
    //Update view
    public void guestLisIndexChanged(int index)
    {
        updateView(index);

    }


    private Guest getguestDataFrView()
    {
        Guest guest = new Guest();
        String firstName = view.getFirstNameText();
        String lastName = view.getLastText();
        String street = view.getStreetText();
        String city = view.getCityText();
        String zipCode = view.getZipCodeText();


        Object country = view.getCountriesItem();


        if ( (firstName != null)  && (!firstName.isEmpty()) )
            guest.setFirstName(firstName);
        else
            view.errMessage("Give a valid first name");

        //vi hoppar över kontroll av resten
        try
        {
            guest.setLastName(lastName);
            guest.setAddress(new Address(street,city,zipCode, (Countries)country ));
       }
        catch (Exception e)
        {
            view.errMessage("Invalid values");
            return null;
        }
        return guest;
    }
    public void setCountryItem(Object country, int   index )
    {
        //behöver inte göras något!
        /*
        guest guest = register.getElementAt(index);
        if (guest != null)
            guest.setUnit ((UnitType)unit);

         */
    }
    public Countries [] getCountriesItems()
    {
        return Countries.values ();
    }


}
