package models;

public class Teacher extends Person {
  private String subject1, subject2;

  public Teacher(final String name, final String subject1,
                 final String subject2) {
    super(name);
    this.subject1 = subject1;
    this.subject2 = subject2;
  }

  public Teacher() {
    super();
    this.subject1 = "Math";
    this.subject2 = "English";
  }

  @Override
  public String describe() {
    return "Teacher model, containing the name from its superclass Person, as well as two subjects.";
  }

  public String getSubject1() { return subject1; }

  public String getSubject2() { return subject2; }

  public void setSubject2(final String subject2) { this.subject2 = subject2; }

  public void setSubject1(final String subject1) { this.subject1 = subject1; }
}
