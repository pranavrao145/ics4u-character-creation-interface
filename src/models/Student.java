package models;

public class Student extends Person {
  private int grade;

  public Student(String name, int grade) {
    super(name);
    this.grade = grade;
  }

  @Override
  public String describe() {
    return "Student model, containing the name from its superclass Person, as well as a grade.";
  }

  public int getGrade() { return grade; }

  public void setGrade(int grade) { this.grade = grade; }
}
