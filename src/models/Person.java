package models;

public class Person {
  private String name;

  public Person(String name, int age) { this.name = name; }

  public Person() {}

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }
}
