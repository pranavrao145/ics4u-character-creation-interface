package models;

public class InternationalStudent extends Student {
  private String country;

  public InternationalStudent(String firstName, String lastName, int age,
                              String schoolName, int grade, String country) {
    super(firstName, lastName, age, schoolName, grade);
    this.country = country;
  }

  public InternationalStudent(String firstName, String lastName, int age,
                              String schoolName, int grade) {
    super(firstName, lastName, age, schoolName, grade);
  }

  public String getCountry() { return country; }

  public void setCountry(String country) { this.country = country; }
}
