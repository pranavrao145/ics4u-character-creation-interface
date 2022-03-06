/******************************************************************************
Program: Person Class (Character Creation Interface)

Description: This is the Person class. It contains a name attribute. This is a
base class, in that it is intended that other classes inherit from this one.

Author: Pranav Rao

Date: March 1, 2022
*******************************************************************************/

package models; // declare this class as a part of the models package

public class Person {
  private String name; // declare name attribute

  /**
   * Constructor function - this function is called when an object of this class
   * is made. This overload of the constructor takes a parameter for each of the
   * available attributes.
   *
   * @param name - the name with which to make the new Person
   */
  public Person(final String name) {
    this.name = name; // set the name of this object to the name provided
  }

  /**
   * Constructor function - this function is called when an object of this class
   * is made. This overload of the constructor takes no parameters and sets the
   * default values for each attribute
   */
  public Person() {
    this.name = "no_name"; // set the default value of name
  }

  /**
   * Describe method - returns a description of this class.
   *
   * @return
   */
  public String describe() {
    return "Generic Person model, containing just a name.";
  }

  // getters and setters

  public String getName() { return name; }

  public void setName(final String name) { this.name = name; }
}
