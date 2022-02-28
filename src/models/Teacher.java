package models;

public class Teacher extends Person {
  private String subject1, subject2;

  public Teacher(String name, String subject1, String subject2) {
    super(name);
    this.subject1 = subject1;
    this.subject2 = subject2;
  }

  @Override
  public String describe() {
    return "Teacher model, containing the name from its superclass Person, as well as two subjects.";
  }

  public String getSubject1() { return subject1; }

  public String getSubject2() { return subject2; }

  public void setSubject2(String subject2) { this.subject2 = subject2; }

  public void setSubject1(String subject1) { this.subject1 = subject1; }
}
