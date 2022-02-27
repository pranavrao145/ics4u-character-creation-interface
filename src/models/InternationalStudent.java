package models;

public class InternationalStudent extends Student {
  private String country;

  public InternationalStudent(String name, int grade, String country) {
    super(name, grade);
    this.country = country;
  }

  public String getCountry() { return country; }

  public void setCountry(String country) { this.country = country; }
}
