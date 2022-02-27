package models;

public class Student extends Person {
  private int grade;

  public Student(String name, int grade) {
    super(name);
    this.grade = grade;
  }

  public int getGrade() { return grade; }

  public void setGrade(int grade) { this.grade = grade; }
}
