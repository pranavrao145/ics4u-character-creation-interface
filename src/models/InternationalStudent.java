package models;

public class InternationalStudent extends Student {
  private String country;

  public InternationalStudent(final String name, final int grade,
                              final String country) {
    super(name, grade);
    this.country = country;
  }

  @Override
  public String describe() {
    return "International Student model, containing the name and grade from its superclasses Student and Person, as well as a country.";
  }

  public String getCountry() { return country; }

  public void setCountry(final String country) { this.country = country; }
}
