package app;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import models.InternationalStudent;
import models.Student;
import models.Teacher;

public class Engine {
  private static ArrayList<Student> students;
  private static ArrayList<Teacher> teachers;
  private static ArrayList<InternationalStudent> internationalStudents;

  private static GUI gui;

  private static void initialize(final GUI currentGUI) {
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
      final File studentFile = new File("data/student_logs.txt"),
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

      final PrintWriter studentWriter =
          new PrintWriter(new FileWriter(studentFile, true));
      final PrintWriter teacherWriter =
          new PrintWriter(new FileWriter(teacherFile, true));
      final PrintWriter internationalStudentWriter =
          new PrintWriter(new FileWriter(internationalStudentFile, true));

      for (final Student student : students) {
        final String content =
            String.format("%s,%d", student.getName(), student.getGrade());

        studentWriter.println(content);
      }

      for (final Teacher teacher : teachers) {
        final String content =
            String.format("%s,%s,%s", teacher.getName(), teacher.getSubject1(),
                          teacher.getSubject2());

        teacherWriter.println(content);
      }

      for (final InternationalStudent internationalStudent :
           internationalStudents) {
        final String content = String.format(
            "%s,%d,%s", internationalStudent.getName(),
            internationalStudent.getGrade(), internationalStudent.getCountry());

        internationalStudentWriter.println(content);
      }

      studentWriter.close();
      teacherWriter.close();
      internationalStudentWriter.close();

    } catch (final Exception e) {
      e.printStackTrace();
    }
  }

  public static void readDataFromFile() {
    try {
      // create the new file if it doesn't exist
      final File studentFile = new File("data/student_logs.txt"),
                 teacherFile = new File("data/teacher_logs.txt"),
                 internationalStudentFile =
                     new File("data/international_student_logs.txt");

      if (studentFile.exists()) {
        final BufferedReader studentReader =
            new BufferedReader(new FileReader(studentFile));
        String line = studentReader.readLine();

        while (line != null) {
          final ArrayList<String> currentStudentInfo =
              new ArrayList<String>(Arrays.asList(line.split(",")));
          students.add(
              new Student(currentStudentInfo.get(0),
                          Integer.parseInt(currentStudentInfo.get(1))));

          line = studentReader.readLine();
        }

        studentReader.close();
      }

      if (teacherFile.exists()) {
        final BufferedReader teacherReader =
            new BufferedReader(new FileReader(teacherFile));
        String line = teacherReader.readLine();

        while (line != null) {
          final ArrayList<String> currentTeacherInfo =
              new ArrayList<String>(Arrays.asList(line.split(",")));
          teachers.add(new Teacher(currentTeacherInfo.get(0),
                                   currentTeacherInfo.get(1),
                                   currentTeacherInfo.get(2)));

          line = teacherReader.readLine();
        }

        teacherReader.close();
      }

      if (internationalStudentFile.exists()) {
        final BufferedReader internationalStudentReader =
            new BufferedReader(new FileReader(internationalStudentFile));
        String line = internationalStudentReader.readLine();

        while (line != null) {
          final ArrayList<String> currentInternationalStudentInfo =
              new ArrayList<String>(Arrays.asList(line.split(",")));
          internationalStudents.add(new InternationalStudent(
              currentInternationalStudentInfo.get(0),
              Integer.parseInt(currentInternationalStudentInfo.get(1)),
              currentInternationalStudentInfo.get(2)));

          line = internationalStudentReader.readLine();
        }

        internationalStudentReader.close();
      }
    } catch (final Exception e) {
      e.printStackTrace();
    }
  }

  public static void run(final GUI currentGUI) { initialize(currentGUI); }

  public static ArrayList<Student> getStudents() { return students; }

  public static ArrayList<Teacher> getTeachers() { return teachers; }

  public static ArrayList<InternationalStudent> getInternationalStudents() {
    return internationalStudents;
  }

  public static GUI getGUI() { return gui; }
}
