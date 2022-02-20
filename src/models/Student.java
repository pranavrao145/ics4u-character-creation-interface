package models;

public class Student extends Person {
  private String schoolName;
  private int grade;

  public Student(String firstName, String lastName, int age, String schoolName,
                 int grade) {
    super(firstName, lastName, age);
    this.schoolName = schoolName;
    this.grade = grade;
  }

  public Student(String firstName, String lastName, int age) {
    super(firstName, lastName, age);
  }

  public String getSchoolName() { return schoolName; }

  public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

  public int getGrade() { return grade; }

  public void setGrade(int grade) { this.grade = grade; }
}
