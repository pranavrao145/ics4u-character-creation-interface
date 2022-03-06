/******************************************************************************
Program: Engine Class (Character Creation Interface)

Description: This is the engine for this app. This class contains all of the
methods to run the app itself, such as to intialize and run the app, as well as
to read and write to the log files.

Author: Pranav Rao

Date: March 1, 2022
*******************************************************************************/

package app; // declare this class as part of the app package

// import all necessary utilities
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

// import all models from the model package
import models.InternationalStudent;
import models.Student;
import models.Teacher;

public class Engine {
  // these three ArrayLists will store the students, teachers, and international
  // students ArrayList was used here to ensure there was no limit on how many
  // people could be stored at once
  private static ArrayList<Student> students;
  private static ArrayList<Teacher> teachers;
  private static ArrayList<InternationalStudent> internationalStudents;

  // this is the GUI variable, which will keep track of the GUI associated with
  // this engine
  private static GUI gui;

  /**
   * This method is responsible for initializing the application. It will
   * initialize all the variables above with appropriate default values, read
   * the necessary data from the log files, then update all the tables on the
   * GUI to reflect the newly read information.
   *
   * @param currentGUI - represents the current GUI associated with this Engine.
   *     This parameter is passed because it is needed to register the current
   *     GUI in the gui variable above
   */
  private static void initialize(final GUI currentGUI) {
    // initialize all model ArrayLists to empty
    students = new ArrayList<Student>();
    teachers = new ArrayList<Teacher>();
    internationalStudents = new ArrayList<InternationalStudent>();

    // set the gui of this engine to the GUI passed to the method
    gui = currentGUI;

    readDataFromFile(); // read the data in the log files and register them with
                        // the program

    // update the GUI tables with the newly read information
    currentGUI.updateViewTable(Student.class,
                               currentGUI.getTableViewStudents());
    currentGUI.updateViewTable(Teacher.class,
                               currentGUI.getTableViewTeachers());
    currentGUI.updateViewTable(InternationalStudent.class,
                               currentGUI.getTableViewIntlStudents());
  }

  /**
   * This method will save the data currently in the ArrayLists of this class
   * to the log files in data/. This method will be automatically called just
   * before the window closes.
   */
  public static void saveDataToFile() {
    // attempt to do the following, catching the exception if it fails
    try {
      // create three file objects (one for each log file) so we can work with
      // them in this program
      final File studentFile = new File("data/student_logs.txt"),
                 teacherFile = new File("data/teacher_logs.txt"),
                 internationalStudentFile =
                     new File("data/international_student_logs.txt");

      // for each of the files, delete them if they exist (we want to overwrite
      // them)
      studentFile.delete();
      teacherFile.delete();
      internationalStudentFile.delete();

      // for each of the files, create their necessary parent directories and
      // create the new files
      studentFile.getParentFile().mkdirs();
      studentFile.createNewFile();

      teacherFile.getParentFile().mkdirs();
      teacherFile.createNewFile();

      internationalStudentFile.getParentFile().mkdirs();
      internationalStudentFile.createNewFile();

      // create three new PrintWriter objects which will be used to write to the
      // files
      final PrintWriter studentWriter =
                            new PrintWriter(new FileWriter(studentFile, true)),
                        teacherWriter =
                            new PrintWriter(new FileWriter(teacherFile, true)),
                        internationalStudentWriter = new PrintWriter(
                            new FileWriter(internationalStudentFile, true));

      // for each of the students, write to the student log file a comma
      // separated list of the student's values (name, grade)
      for (final Student student : students) {
        final String content =
            String.format("%s;%d", student.getName(), student.getGrade());

        studentWriter.println(content);
      }

      // for each of the teachers, write to the teacher log file a comma
      // separated list of the teacher's values (name, subject 1, subject 2)
      for (final Teacher teacher : teachers) {
        final String content =
            String.format("%s;%s;%s", teacher.getName(), teacher.getSubject1(),
                          teacher.getSubject2());

        teacherWriter.println(content);
      }

      // for each of the international students, write to the international
      // student log file a comma separated list of the international student's
      // values (name, grade, country)
      for (final InternationalStudent internationalStudent :
           internationalStudents) {
        final String content = String.format(
            "%s;%d;%s", internationalStudent.getName(),
            internationalStudent.getGrade(), internationalStudent.getCountry());

        internationalStudentWriter.println(content);
      }

      // close all the writer objects previouly opened
      studentWriter.close();
      teacherWriter.close();
      internationalStudentWriter.close();

    } catch (
        final Exception
            e) { // if for whatever reason, the above fails, catch the exception
      e.printStackTrace(); // print the exception to the console
    }
  }

  /**
   *  This method will take read the data currently stored in the log files
   *  and update the arrays of students, teachers, and international students
   *  with the information that it gets. This method will be called upon the
   *  initialization of the program, allowing for data persistence.
   */
  public static void readDataFromFile() {
    // attempt to do the following, catching the exception if it fails
    try {
      // create three file objects (one for each log file) so we can work with
      // them in this program
      final File studentFile = new File("data/student_logs.txt"),
                 teacherFile = new File("data/teacher_logs.txt"),
                 internationalStudentFile =
                     new File("data/international_student_logs.txt");

      if (studentFile.exists()) { // if the student log file exists
        // create a new buffered reader object
        final BufferedReader studentReader =
            new BufferedReader(new FileReader(studentFile));

        // read the first line from the file
        String line = studentReader.readLine();

        while (line != null) { // while the last line that was read is not empty
          // split the current line by commas (the character by which the info
          // is delimited) and store it in an ArrayList
          final ArrayList<String> currentStudentInfo =
              new ArrayList<String>(Arrays.asList(line.split(";")));
          // add the information gathered and stored in the ArrayList to the
          // master ArrayList containing all the students
          students.add(
              new Student(currentStudentInfo.get(0),
                          Integer.parseInt(currentStudentInfo.get(1))));

          line = studentReader
                     .readLine(); // read the next line of the student logs
        }

        studentReader.close(); // once all reading operations have finished,
                               // close the student reader
      }

      if (teacherFile.exists()) { // if the student log file exists
        // create a new buffered reader object
        final BufferedReader teacherReader =
            new BufferedReader(new FileReader(teacherFile));

        // read the first line from the file
        String line = teacherReader.readLine();

        while (line != null) { // while the last line that was read is not empty
          // split the current line by commas (the character by which the info
          // is delimited) and store it in an ArrayList
          final ArrayList<String> currentTeacherInfo =
              new ArrayList<String>(Arrays.asList(line.split(";")));
          // add the information gathered and stored in the ArrayList to the
          // master ArrayList containing all the teachers
          teachers.add(new Teacher(currentTeacherInfo.get(0),
                                   currentTeacherInfo.get(1),
                                   currentTeacherInfo.get(2)));

          // read the next line of the teacher logs
          line = teacherReader.readLine();
        }

        teacherReader.close(); // once all reading operations have finished,
                               // close the teacher reader
      }

      if (internationalStudentFile
              .exists()) { // if the international student log file exists
        // create a new buffered reader object
        final BufferedReader internationalStudentReader =
            new BufferedReader(new FileReader(internationalStudentFile));

        // read the first line from the file
        String line = internationalStudentReader.readLine();

        while (line != null) { // while the last line that was read is not empty
          // split the current line by commas (the character by which the info
          // is delimited) and store it in an ArrayList
          final ArrayList<String> currentInternationalStudentInfo =
              new ArrayList<String>(Arrays.asList(line.split(";")));
          // add the information gathered and stored in the ArrayList to the
          // master ArrayList containing all the international students
          internationalStudents.add(new InternationalStudent(
              currentInternationalStudentInfo.get(0),
              Integer.parseInt(currentInternationalStudentInfo.get(1)),
              currentInternationalStudentInfo.get(2)));

          line = internationalStudentReader
                     .readLine(); // read the next line of the international
                                  // student logs
        }

        internationalStudentReader
            .close(); // once all reading operations have finished,
                      // close the international student reader
      }
    } catch (
        final Exception
            e) { // if for whatever reason, the above fails, catch the exception
      e.printStackTrace(); // print the exception to the console
    }
  }

  /**
   * This method is the entry point for this class. It will be called by the
   * main class to start the entire program
   *
   * @param currentGUI - represents the current GUI associated with this Engine.
   *     This parameter is passed because it is needed to register the current
   *     GUI in the gui variable above
   */
  public static void run(final GUI currentGUI) { initialize(currentGUI); }

  // necessary getters and setters

  public static ArrayList<Student> getStudents() { return students; }

  public static ArrayList<Teacher> getTeachers() { return teachers; }

  public static ArrayList<InternationalStudent> getInternationalStudents() {
    return internationalStudents;
  }

  public static GUI getGUI() { return gui; }
}
