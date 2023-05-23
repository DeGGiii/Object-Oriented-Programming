/* Namn: Jagtej Sidhu
   ID: al2890
   Program: Systemutvecklare
 */
package partyModel;

public class Address
{

    private String street;
    private String city;
    private String zipCode;
    private Countries country;

  // Konstruktor
  public Address()
  {

  }

  // En overloaded konstruktor med parametrar.
  public Address(String street, String city, String zipCode, Countries country)
  {
    this.street = street;
    this.city = city;
    this.zipCode = zipCode;
    this.country = country;
  }

  // Getters och Setters för alla instansvariabler
  public void setStreet(String street)
  {
    this.street = street;
  }

  public String getStreet()
  {
    return street;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public String getCity()
  {
    return city;
  }

  public void setZipCode(String zipCode)
  {
    this.zipCode = zipCode;
  }

  public String getZipCode()
  {
    return zipCode;
  }

  public void setCountry(Countries country)
  {
    this.country = country;
  }

  public Countries getCountry()
  {
    return country;
  }

  // Detta skrivs ut som text för användaren att se.
  @Override
  public String toString()
  {
    return "Street = " + street + " | City = " + city + " | ZipCode = " + zipCode + " | Country = " + country;
  }
}
