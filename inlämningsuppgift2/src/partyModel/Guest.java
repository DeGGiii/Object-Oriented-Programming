/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package partyModel;

public class Guest
{

    private String firstName;
    private String lastName;
    private Address address;

    // En konstruktor med ett skapat objekt inuti.
    public Guest()
    {
        Address address = new Address();
    }

    // Getters och Settes för instansvariablerna.
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public Address getAddress()
    {
        return address;
    }

    // Detta skrivs ut som text för användaren att se.
    @Override
    public String toString()
    {
        return "Guest: " + "FirstName = " + firstName + " | LastName = " + lastName + " | " + address;
    }
}
