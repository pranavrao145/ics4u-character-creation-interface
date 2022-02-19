package models;

public class Teacher extends Person {
  private String subject1, string2;

  public Teacher(String firstName, String lastName, int age, String subject1,
                 String string2) {
    super(firstName, lastName, age);
    this.subject1 = subject1;
    this.string2 = string2;
  }

  public Teacher(String subject1, String string2) {
    this.subject1 = subject1;
    this.string2 = string2;
  }

  public Teacher(String firstName, String lastName, int age) {
    super(firstName, lastName, age);
  }

  public Teacher() {}

  public String getSubject1() { return subject1; }

  public void setSubject1(String subject1) { this.subject1 = subject1; }

  public String getString2() { return string2; }

  public void setString2(String string2) { this.string2 = string2; }
}
