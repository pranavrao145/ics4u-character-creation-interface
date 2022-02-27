package app;

import java.util.ArrayList;
import models.*;

public class Engine {
  private static ArrayList<Student> students;
  private static ArrayList<Teacher> teachers;
  private static ArrayList<InternationalStudent> internationalStudents;

  private static GUI gui;

  private static void initialize(GUI currentGUI) {
    students = new ArrayList<Student>();
    teachers = new ArrayList<Teacher>();
    internationalStudents = new ArrayList<InternationalStudent>();
    gui = currentGUI;
  }

  public static void run(GUI currentGUI) { initialize(currentGUI); }

  public static ArrayList<Student> getStudents() { return students; }

  public static ArrayList<Teacher> getTeachers() { return teachers; }

  public static ArrayList<InternationalStudent> getInternationalStudents() {
    return internationalStudents;
  }

  public static GUI getGUI() { return gui; }
}
