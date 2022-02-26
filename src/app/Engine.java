package app;

import models.*;

public class Engine {
  private static InternationalStudent[] internationalStudent;
  private static Student[] students;
  private static Teacher[] teachers;

  private static GUI gui;

  private static void initialize(GUI currentGUI) {
    internationalStudent = new InternationalStudent[100];
    students = new Student[100];
    teachers = new Teacher[100];
    gui = currentGUI;
  }

  public static void run(GUI currentGUI) { initialize(currentGUI); }

  public static InternationalStudent[] getInternationalStudent() {
    return internationalStudent;
  }

  public static void
  setInternationalStudent(InternationalStudent[] internationalStudent) {
    Engine.internationalStudent = internationalStudent;
  }

  public static Student[] getStudents() { return students; }

  public static void setStudents(Student[] students) {
    Engine.students = students;
  }

  public static Teacher[] getTeachers() { return teachers; }

  public static void setTeachers(Teacher[] teachers) {
    Engine.teachers = teachers;
  }

  public static GUI getGui() { return gui; }

  public static void setGui(GUI gui) { Engine.gui = gui; }
}
