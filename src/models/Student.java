package models;

public class Student extends Person {
  private int grade;

  public Student(final String name, final int grade) {
    super(name);
    this.grade = grade;
  }

  public Student() {
    super();
    this.grade = 9;
  }

  @Override
  public String describe() {
    return "Student model, containing the name from its superclass Person, as well as a grade.";
  }

  public int getGrade() { return grade; }

  public void setGrade(final int grade) { this.grade = grade; }
}
