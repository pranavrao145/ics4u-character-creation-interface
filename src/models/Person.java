package models;

public class Person {
  private String name;

  public Person(final String name) { this.name = name; }

  public Person() { this.name = "no_name"; }

  public String describe() {
    return "Generic Person model, containing just a name.";
  }

  public String getName() { return name; }

  public void setName(final String name) { this.name = name; }
}
