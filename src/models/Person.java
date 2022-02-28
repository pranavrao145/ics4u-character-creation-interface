package models;

public class Person {
  private String name;

  public Person(String name) { this.name = name; }

  public Person() {}

  public String describe() {
    return "Generic Person model, containing just a name.";
  }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }
}
