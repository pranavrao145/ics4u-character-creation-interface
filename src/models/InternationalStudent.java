package models;

public class InternationalStudent extends Student {
  private String country;

  public InternationalStudent(String name, int grade, String country) {
    super(name, grade);
    this.country = country;
  }

  @Override
  public String describe() {
    return "International Student model, containing the name and grade from its superclasses Student and Person, as well as a country.";
  }

  public String getCountry() { return country; }

  public void setCountry(String country) { this.country = country; }
}
