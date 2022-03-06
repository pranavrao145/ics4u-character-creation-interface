/******************************************************************************
Program: InternationalStudent Class (Character Creation Interface)

Description: This is the InternationalStudent class. It contains a name and
grade inherited from its parent, Student, as well as an additional country
attribute.

Author: Pranav Rao

Date: March 1, 2022
*******************************************************************************/

package models; // declare this class as a part of the models package

public class InternationalStudent extends Student {
  private String country; // declare country attribute

  /**
   * Constructor method - this method is called when an object of this class
   * is made. This overload of the constructor takes a parameter for each of the
   * available attributes.
   *
   * @param name - the name with which to make the new InternationalStudent
   * @param grade - the grade with which to make the new InternationalStudent
   * @param country - the country with which to make the new
   *     InternationalStudent
   */
  public InternationalStudent(final String name, final int grade,
                              final String country) {
    super(name,
          grade); // call the superconstructor with the name and grade supplied
    this.country =
        country; // set the country of this object to the country provided
  }

  /**
   * Constructor method - this method is called when an object of this class
   * is made. This overload of the constructor takes no parameters and sets the
   * default values for each attribute
   */
  public InternationalStudent() {
    super();                 // call the superconstructor with no arguments
    this.country = "Canada"; // set the default value of country
  }

  /**
   * Describe method - returns a description of this class. This overrides the
   * method defined in the parent Person class
   *
   * @return - returns a description of this class
   */
  @Override
  public String describe() {
    return "International Student model, containing the name and grade from its superclasses Student and Person, as well as a country.";
  }

  // getters and setters

  public String getCountry() { return country; }

  public void setCountry(final String country) { this.country = country; }
}
