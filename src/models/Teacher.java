/******************************************************************************
Program: Teacher Class (Character Creation Interface)

Description: This is the Teacher class. It contains a name inherited from its
parent, Person, as well as additional subject1 and subject2 attributes.

Author: Pranav Rao

Date: March 1, 2022
*******************************************************************************/

package models; // declare this class as a part of the models package

public class Teacher extends Person {
  private String subject1,
      subject2; // declare subject 1 and subject 2 attributes to store the two
                // subjects of this teacher

  /**
   * Constructor function - this function is called when an object of this class
   * is made. This overload of the constructor takes a parameter for each of the
   * available attributes.
   *
   * @param name - the name with which to make the new Teacher
   * @param subject1 - the first subject with which to make the new Teacher
   * @param subject2 - the second subject with which to make the new Teacher
   */
  public Teacher(final String name, final String subject1,
                 final String subject2) {
    super(name); // call the superconstructor with the name supplied
    this.subject1 =
        subject1; // set the subject1 of this object to the subject1 provided
    this.subject2 =
        subject2; // set the subject2 of this object to the subject2 provided
  }

  /**
   * Constructor function - this function is called when an object of this class
   * is made. This overload of the constructor takes no parameters and sets the
   * default values for each attribute
   */
  public Teacher() {
    super();                   // call the superconstructor with no arguments
    this.subject1 = "Math";    // set the default value of subject1
    this.subject2 = "English"; // set the default value of subject2
  }

  /**
   * Describe method - returns a description of this class. This overrides the
   * method defined in the parent Person class
   *
   * @return - returns a description of this class
   */
  @Override
  public String describe() {
    return "Teacher model, containing the name from its superclass Person, as well as two subjects.";
  }

  // getters and setters

  public String getSubject1() { return subject1; }

  public String getSubject2() { return subject2; }

  public void setSubject2(final String subject2) { this.subject2 = subject2; }

  public void setSubject1(final String subject1) { this.subject1 = subject1; }
}
