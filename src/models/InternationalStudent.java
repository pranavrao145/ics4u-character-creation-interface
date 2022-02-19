package models;

public class InternationalStudent extends Student {
  private String country;

  public InternationalStudent(String firstName, String lastName, int age,
                              String schoolName, int grade, String country) {
    super(firstName, lastName, age, schoolName, grade);
    this.country = country;
  }

  public InternationalStudent(String schoolName, int grade, String country) {
    super(schoolName, grade);
    this.country = country;
  }

  public InternationalStudent(String firstName, String lastName, int age,
                              String country) {
    super(firstName, lastName, age);
    this.country = country;
  }

  public InternationalStudent(String country) { this.country = country; }

  public InternationalStudent(String firstName, String lastName, int age,
                              String schoolName, int grade) {
    super(firstName, lastName, age, schoolName, grade);
  }

  public InternationalStudent(String schoolName, int grade) {
    super(schoolName, grade);
  }

  public InternationalStudent(String firstName, String lastName, int age) {
    super(firstName, lastName, age);
  }

  public InternationalStudent() {}

  public String getCountry() { return country; }

  public void setCountry(String country) { this.country = country; }
}
