/******************************************************************************
Program: Student Class (Character Creation Interface)

Description: This is the Student class. It contains a name inherited from its
parent, Person, as well as an additional grade attribute.

Author: Pranav Rao

Date: March 1, 2022
*******************************************************************************/

package models; // declare this class as a part of the models package

public class Student extends Person {
  private int grade; // declare grade attribute

  /**
   * Constructor method - this method is called when an object of this class
   * is made. This overload of the constructor takes a parameter for each of the
   * available attributes.
   *
   * @param name - the name with which to make the new Student
   * @param grade - the grade with which to make the new Student
   */
  public Student(final String name, final int grade) {
    super(name);        // call the superconstructor with the name supplied
    this.grade = grade; // set the grade of this object to the grade provided
  }

  /**
   * Constructor method - this method is called when an object of this class
   * is made. This overload of the constructor takes no parameters and sets the
   * default values for each attribute
   */
  public Student() {
    super();        // call the superconstructor with no arguments
    this.grade = 9; // set the default value of grade
  }

  /**
   * Describe method - returns a description of this class. This overrides the
   * method defined in the parent Person class
   *
   * @return - returns a description of this class
   */
  @Override
  public String describe() {
    return "Student model, containing the name from its superclass Person, as well as a grade.";
  }

  // getters and setters

  public int getGrade() { return grade; }

  public void setGrade(final int grade) { this.grade = grade; }
}
