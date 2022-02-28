package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
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

    readDataFromFile();

    currentGUI.updateViewTable(Student.class,
                               currentGUI.getTableViewStudents());
    currentGUI.updateViewTable(Teacher.class,
                               currentGUI.getTableViewTeachers());
    currentGUI.updateViewTable(InternationalStudent.class,
                               currentGUI.getTableViewIntlStudents());
  }

  public static void saveDataToFile() {
    try {
      // create the new file if it doesn't exist
      File studentFile = new File("data/student_logs.txt"),
           teacherFile = new File("data/teacher_logs.txt"),
           internationalStudentFile =
               new File("data/international_student_logs.txt");

      studentFile.delete();
      teacherFile.delete();
      internationalStudentFile.delete();

      studentFile.getParentFile().mkdirs();
      studentFile.createNewFile();

      teacherFile.getParentFile().mkdirs();
      teacherFile.createNewFile();

      internationalStudentFile.getParentFile().mkdirs();
      internationalStudentFile.createNewFile();

      PrintWriter studentWriter =
          new PrintWriter(new FileWriter(studentFile, true));
      PrintWriter teacherWriter =
          new PrintWriter(new FileWriter(teacherFile, true));
      PrintWriter internationalStudentWriter =
          new PrintWriter(new FileWriter(internationalStudentFile, true));

      for (Student student : students) {
        String content =
            String.format("%s,%d", student.getName(), student.getGrade());

        studentWriter.println(content);
      }

      for (Teacher teacher : teachers) {
        String content =
            String.format("%s,%s,%s", teacher.getName(), teacher.getSubject1(),
                          teacher.getSubject2());

        teacherWriter.println(content);
      }

      for (InternationalStudent internationalStudent : internationalStudents) {
        String content = String.format(
            "%s,%d,%s", internationalStudent.getName(),
            internationalStudent.getGrade(), internationalStudent.getCountry());

        internationalStudentWriter.println(content);
      }

      studentWriter.close();
      teacherWriter.close();
      internationalStudentWriter.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void readDataFromFile() {
    try {
      // create the new file if it doesn't exist
      File studentFile = new File("data/student_logs.txt"),
           teacherFile = new File("data/teacher_logs.txt"),
           internationalStudentFile =
               new File("data/international_student_logs.txt");

      if (studentFile.exists()) {
        BufferedReader studentReader =
            new BufferedReader(new FileReader(studentFile));
        String line = studentReader.readLine();

        while (line != null) {
          ArrayList<String> currentStudentInfo =
              new ArrayList<String>(Arrays.asList(line.split(",")));
          students.add(
              new Student(currentStudentInfo.get(0),
                          Integer.parseInt(currentStudentInfo.get(1))));

          line = studentReader.readLine();
        }

        studentReader.close();
      }

      if (teacherFile.exists()) {
        BufferedReader teacherReader =
            new BufferedReader(new FileReader(teacherFile));
        String line = teacherReader.readLine();

        while (line != null) {
          ArrayList<String> currentTeacherInfo =
              new ArrayList<String>(Arrays.asList(line.split(",")));
          teachers.add(new Teacher(currentTeacherInfo.get(0),
                                   currentTeacherInfo.get(1),
                                   currentTeacherInfo.get(2)));

          line = teacherReader.readLine();
        }

        teacherReader.close();
      }

      if (internationalStudentFile.exists()) {
        BufferedReader internationalStudentReader =
            new BufferedReader(new FileReader(internationalStudentFile));
        String line = internationalStudentReader.readLine();

        while (line != null) {
          ArrayList<String> currentInternationalStudentInfo =
              new ArrayList<String>(Arrays.asList(line.split(",")));
          internationalStudents.add(new InternationalStudent(
              currentInternationalStudentInfo.get(0),
              Integer.parseInt(currentInternationalStudentInfo.get(1)),
              currentInternationalStudentInfo.get(2)));

          line = internationalStudentReader.readLine();
        }

        internationalStudentReader.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void run(GUI currentGUI) { initialize(currentGUI); }

  public static ArrayList<Student> getStudents() { return students; }

  public static ArrayList<Teacher> getTeachers() { return teachers; }

  public static ArrayList<InternationalStudent> getInternationalStudents() {
    return internationalStudents;
  }

  public static GUI getGUI() { return gui; }
}
