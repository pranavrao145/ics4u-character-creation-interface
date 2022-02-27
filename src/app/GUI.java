package app;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import models.*;

public class GUI {
  private JFrame frame;
  private Container contentPane;
  private CardLayout masterLayout;

  private JPanel panel_home;
  private JLabel lbl_homeChoose;
  private JButton btn_homeStudent, btn_homeIntlStudent, btn_homeTeacher;

  private JPanel panel_addStudent, panel_editStudent, panel_viewStudents,
      panel_deleteStudent;

  private JLabel lbl_addStudentName, lbl_addStudentTitle, lbl_addStudentGrade;
  private JButton btn_addStudentSave, btn_addStudentCancel;
  private JTextField textField_addStudentName;
  private JComboBox<Integer> comboBox_addStudentGrade;

  private JTextField textField_editStudentName;
  private JLabel lbl_editStudentTitle, lbl_editStudentName,
      lbl_editStudentGrade;
  private JComboBox<Integer> comboBox_editStudentGrade;
  private JButton btn_editStudentCancel, btn_editStudentSave;

  private JLabel lbl_viewStudentsTitle;
  private JTable table_viewStudents;
  private JButton btn_viewStudentsDelete, btn_viewStudentsCreate,
      btn_viewStudentsGoHome;

  private JButton btn_deleteStudentCancel, btn_deleteStudentDelete;
  private JLabel lbl_deleteStudent;
  private JComboBox<String> comboBox_deleteStudent;

  private JPanel panel_addTeacher, panel_editTeacher, panel_viewTeachers,
      panel_deleteTeacher;

  private JLabel lbl_addTeacherName, lbl_addTeacherTitle,
      lbl_addTeacherSubject1, lbl_addTeacherSubject2;
  private JButton btn_addTeacherSave, btn_addTeacherCancel;
  private JTextField textField_addTeacherName;
  private JComboBox<String> comboBox_addTeacherSubject1,
      comboBox_addTeacherSubject2;

  private JLabel lbl_editTeacherName, lbl_editTeacherTitle,
      lbl_editTeacherSubject1, lbl_editTeacherSubject2;
  private JButton btn_editTeacherSave, btn_editTeacherCancel;
  private JTextField textField_editTeacherName;
  private JComboBox<String> comboBox_editTeacherSubject1,
      comboBox_editTeacherSubject2;

  private JLabel lbl_viewTeachersTitle;
  private JTable table_viewTeachers;
  private JButton btn_viewTeachersCreate, btn_viewTeachersDelete,
      btn_viewTeachersGoHome;

  private JButton btn_deleteTeacherDelete, btn_deleteTeacherCancel;
  private JLabel lbl_deleteTeacher;
  private JComboBox<String> comboBox_deleteTeacher;

  private JPanel panel_addIntlStudent, panel_editIntlStudent,
      panel_viewIntlStudents, panel_deleteIntlStudent;

  private JLabel lbl_addIntlStudentName, lbl_addIntlStudentTitle,
      lbl_addIntlStudentGrade, lbl_addIntlStudentCountry;
  private JButton btn_addIntlStudentSave, btn_addIntlStudentCancel;
  private JTextField textField_addIntlStudentName;
  private JComboBox<Integer> comboBox_addIntlStudentGrade;
  private JComboBox<String> comboBox_addIntlStudentCountry;

  private JLabel lbl_editIntlStudentTitle, lbl_editIntlStudentName,
      lbl_editIntlStudentGrade, lbl_editIntlStudentCountry;
  private JTextField textField_editIntlStudentName;
  private JButton btn_editIntlStudentCancel, btn_editIntlStudentSave;
  private JComboBox<Integer> comboBox_editIntlStudentGrade;
  private JComboBox<String> comboBox_editIntlStudentCountry;

  private JTable table_viewIntlStudents;
  private JLabel lbl_viewIntlStudentsTitle;
  private JButton btn_viewIntlStudentsCreate, btn_viewIntlStudentsDelete,
      btn_viewIntlStudentsGoHome;

  private JButton btn_deleteIntlStudentCancel, btn_deleteIntlStudentDelete;
  private JLabel lbl_deleteIntlStudent;
  private JComboBox<String> comboBox_deleteIntlStudent;

  DefaultComboBoxModel<String> subjectOptions, countryOptions,
      defaultDeletionOptions;
  DefaultComboBoxModel<Integer> gradeOptions;

  public GUI() {
    initializeValues();
    setupGUI();
    attachListeners();
    frame.setVisible(true);
  }

  private void initializeValues() {
    subjectOptions = new DefaultComboBoxModel<String>(
        new String[] {"Math", "Business", "Computer Science", "English",
                      "Phys Ed", "Science"});

    gradeOptions =
        new DefaultComboBoxModel<Integer>(new Integer[] {9, 10, 11, 12});

    countryOptions = new DefaultComboBoxModel<String>(new String[] {
        "India", "China", "Russia", "United Kingdom", "France", "Germany",
        "South Africa", "Argentina", "Brazil", "United States of America"});

    defaultDeletionOptions = new DefaultComboBoxModel<String>();
  }

  public static void tempChangeLabel(JLabel label, String newText) {
    String oldText = label.getText();
    label.setText(newText);

    SwingWorker<Object, Object> worker = new SwingWorker<Object, Object>() {
      @Override
      protected Object doInBackground() throws Exception {
        Thread.sleep(1000);
        return null;
      }

      @Override
      protected void done() {
        label.setText(oldText);
        super.done();
      }
    };

    worker.execute();
  }

  public static void tempChangeLabel(JButton button, String newText) {
    String oldText = button.getText();
    button.setText(newText);

    SwingWorker<Object, Object> worker = new SwingWorker<Object, Object>() {
      @Override
      protected Object doInBackground() throws Exception {
        Thread.sleep(1000);
        return null;
      }

      @Override
      protected void done() {
        button.setText(oldText);
        super.done();
      }
    };

    worker.execute();
  }

  private void updateViewTable(Class<?> cls, JTable table) {
    DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
    tableModel.getDataVector().removeAllElements();

    if (cls == Student.class) {
      tableModel.addRow(new Object[] {"Name", "Grade"});
      for (Student student : Engine.getStudents()) {
        tableModel.addRow(new Object[] {student.getName(), student.getGrade()});
      }
    } else if (cls == Teacher.class) {
      tableModel.addRow(new Object[] {"Name", "Subject 1", "Subject 2"});
      for (Teacher teacher : Engine.getTeachers()) {
        tableModel.addRow(new Object[] {
            teacher.getName(), teacher.getSubject1(), teacher.getSubject2()});
      }
    } else if (cls == InternationalStudent.class) {
      tableModel.addRow(new Object[] {"Name", "Grade", "Country"});
      for (InternationalStudent internationalStudent :
           Engine.getInternationalStudents()) {
        tableModel.addRow(new Object[] {internationalStudent.getName(),
                                        internationalStudent.getGrade(),
                                        internationalStudent.getCountry()});
      }
    }
  }

  private void updateDeleteList(Class<?> cls, JComboBox<String> comboBox) {
    DefaultComboBoxModel<String> comboBoxModel =
        (DefaultComboBoxModel<String>)comboBox.getModel();
    comboBoxModel.removeAllElements();

    if (cls == Student.class) {
      for (Student student : Engine.getStudents()) {
        comboBoxModel.addElement(student.getName());
      }
    } else if (cls == Teacher.class) {
      for (Teacher teacher : Engine.getTeachers()) {
        comboBoxModel.addElement(teacher.getName());
      }
    } else if (cls == InternationalStudent.class) {
      for (InternationalStudent internationalstudent :
           Engine.getInternationalStudents()) {
        comboBoxModel.addElement(internationalstudent.getName());
      }
    }
  }

  private void setupGUI() {
    frame = new JFrame();
    contentPane = frame.getContentPane();
    masterLayout = new CardLayout();

    frame.setResizable(false);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane.setLayout(masterLayout);

    panel_editStudent = new JPanel();
    contentPane.add(panel_editStudent, "panel_editStudent");
    panel_editStudent.setLayout(null);

    lbl_editStudentTitle = new JLabel("Edit Student");
    lbl_editStudentTitle.setBounds(12, 12, 107, 17);
    panel_editStudent.add(lbl_editStudentTitle);

    lbl_editStudentName = new JLabel("Name:");
    lbl_editStudentName.setBounds(12, 65, 107, 17);
    panel_editStudent.add(lbl_editStudentName);

    lbl_editStudentGrade = new JLabel("Grade:");
    lbl_editStudentGrade.setBounds(12, 149, 107, 17);
    panel_editStudent.add(lbl_editStudentGrade);

    textField_editStudentName = new JTextField();
    textField_editStudentName.setColumns(10);
    textField_editStudentName.setBounds(62, 63, 114, 21);
    panel_editStudent.add(textField_editStudentName);

    comboBox_editStudentGrade = new JComboBox<Integer>(gradeOptions);
    comboBox_editStudentGrade.setBounds(62, 144, 57, 26);
    panel_editStudent.add(comboBox_editStudentGrade);

    btn_editStudentCancel = new JButton("Cancel");
    btn_editStudentCancel.setBounds(106, 231, 105, 27);
    panel_editStudent.add(btn_editStudentCancel);

    btn_editStudentSave = new JButton("Save");
    btn_editStudentSave.setBounds(223, 231, 105, 27);
    panel_editStudent.add(btn_editStudentSave);

    panel_addTeacher = new JPanel();
    panel_addTeacher.setLayout(null);
    contentPane.add(panel_addTeacher, "panel_addTeacher");

    lbl_addTeacherTitle = new JLabel("Create Teacher");
    lbl_addTeacherTitle.setBounds(12, 12, 107, 17);
    panel_addTeacher.add(lbl_addTeacherTitle);

    lbl_addTeacherName = new JLabel("Name:");
    lbl_addTeacherName.setBounds(12, 48, 107, 17);
    panel_addTeacher.add(lbl_addTeacherName);

    textField_addTeacherName = new JTextField();
    textField_addTeacherName.setColumns(10);
    textField_addTeacherName.setBounds(62, 46, 114, 21);
    panel_addTeacher.add(textField_addTeacherName);

    btn_addTeacherCancel = new JButton("Cancel");
    btn_addTeacherCancel.setBounds(106, 231, 105, 27);
    panel_addTeacher.add(btn_addTeacherCancel);

    btn_addTeacherSave = new JButton("Save");
    btn_addTeacherSave.setBounds(223, 231, 105, 27);
    panel_addTeacher.add(btn_addTeacherSave);

    lbl_addTeacherSubject1 = new JLabel("Subject 1:");
    lbl_addTeacherSubject1.setBounds(12, 112, 81, 17);
    panel_addTeacher.add(lbl_addTeacherSubject1);

    lbl_addTeacherSubject2 = new JLabel("Subject 2:");
    lbl_addTeacherSubject2.setBounds(12, 176, 81, 17);
    panel_addTeacher.add(lbl_addTeacherSubject2);

    comboBox_addTeacherSubject1 = new JComboBox<String>(subjectOptions);
    comboBox_addTeacherSubject1.setBounds(88, 107, 107, 26);
    panel_addTeacher.add(comboBox_addTeacherSubject1);

    comboBox_addTeacherSubject2 = new JComboBox<String>(subjectOptions);
    comboBox_addTeacherSubject2.setBounds(88, 171, 107, 26);
    panel_addTeacher.add(comboBox_addTeacherSubject2);

    panel_viewTeachers = new JPanel();
    panel_viewTeachers.setLayout(null);
    contentPane.add(panel_viewTeachers, "panel_viewTeachers");

    DefaultTableModel viewTeacherModel = new DefaultTableModel(
        new Object[] {"Name", "Subject 1", "Subject 2"}, 0);
    table_viewTeachers = new JTable(viewTeacherModel);
    viewTeacherModel.addRow(new Object[] {"Name", "Subject 1", "Subject 2"});
    table_viewTeachers.setEnabled(false);
    table_viewTeachers.setBounds(0, 34, 440, 186);
    panel_viewTeachers.add(table_viewTeachers);

    lbl_viewTeachersTitle = new JLabel("All Teachers");
    lbl_viewTeachersTitle.setBounds(12, 12, 84, 17);
    panel_viewTeachers.add(lbl_viewTeachersTitle);

    btn_viewTeachersCreate = new JButton("Create New Teacher");
    btn_viewTeachersCreate.setBounds(225, 232, 203, 27);
    panel_viewTeachers.add(btn_viewTeachersCreate);

    btn_viewTeachersDelete = new JButton("Delete Teacher");
    btn_viewTeachersDelete.setBounds(12, 232, 201, 27);
    panel_viewTeachers.add(btn_viewTeachersDelete);

    btn_viewTeachersGoHome = new JButton("Go Home");
    btn_viewTeachersGoHome.setBounds(323, 9, 105, 22);
    panel_viewTeachers.add(btn_viewTeachersGoHome);

    panel_addIntlStudent = new JPanel();
    panel_addIntlStudent.setLayout(null);
    contentPane.add(panel_addIntlStudent, "panel_addIntlStudent");

    lbl_addIntlStudentTitle = new JLabel("Create International Student");
    lbl_addIntlStudentTitle.setBounds(12, 12, 179, 17);
    panel_addIntlStudent.add(lbl_addIntlStudentTitle);

    lbl_addIntlStudentName = new JLabel("Name:");
    lbl_addIntlStudentName.setBounds(12, 48, 107, 17);
    panel_addIntlStudent.add(lbl_addIntlStudentName);

    lbl_addIntlStudentGrade = new JLabel("Grade:");
    lbl_addIntlStudentGrade.setBounds(12, 113, 107, 17);
    panel_addIntlStudent.add(lbl_addIntlStudentGrade);

    textField_addIntlStudentName = new JTextField();
    textField_addIntlStudentName.setColumns(10);
    textField_addIntlStudentName.setBounds(62, 46, 114, 21);
    panel_addIntlStudent.add(textField_addIntlStudentName);

    comboBox_addIntlStudentGrade = new JComboBox<Integer>(gradeOptions);
    comboBox_addIntlStudentGrade.setBounds(62, 108, 57, 26);
    panel_addIntlStudent.add(comboBox_addIntlStudentGrade);

    btn_addIntlStudentCancel = new JButton("Cancel");
    btn_addIntlStudentCancel.setBounds(106, 231, 105, 27);
    panel_addIntlStudent.add(btn_addIntlStudentCancel);

    btn_addIntlStudentSave = new JButton("Save");
    btn_addIntlStudentSave.setBounds(223, 231, 105, 27);
    panel_addIntlStudent.add(btn_addIntlStudentSave);

    lbl_addIntlStudentCountry = new JLabel("Country:");
    lbl_addIntlStudentCountry.setBounds(12, 175, 60, 17);
    panel_addIntlStudent.add(lbl_addIntlStudentCountry);

    comboBox_addIntlStudentCountry = new JComboBox<String>(countryOptions);
    comboBox_addIntlStudentCountry.setBounds(72, 170, 104, 26);
    panel_addIntlStudent.add(comboBox_addIntlStudentCountry);

    panel_addStudent = new JPanel();
    panel_addStudent.setLayout(null);
    contentPane.add(panel_addStudent, "panel_addStudent");

    lbl_addStudentTitle = new JLabel("Create Student");
    lbl_addStudentTitle.setBounds(12, 12, 186, 17);
    panel_addStudent.add(lbl_addStudentTitle);

    lbl_addStudentName = new JLabel("Name:");
    lbl_addStudentName.setBounds(12, 65, 107, 17);
    panel_addStudent.add(lbl_addStudentName);

    lbl_addStudentGrade = new JLabel("Grade:");
    lbl_addStudentGrade.setBounds(12, 149, 107, 17);
    panel_addStudent.add(lbl_addStudentGrade);

    textField_addStudentName = new JTextField();
    textField_addStudentName.setColumns(10);
    textField_addStudentName.setBounds(62, 63, 114, 21);
    panel_addStudent.add(textField_addStudentName);

    comboBox_addStudentGrade = new JComboBox<Integer>(gradeOptions);
    comboBox_addStudentGrade.setBounds(62, 144, 57, 26);
    panel_addStudent.add(comboBox_addStudentGrade);

    btn_addStudentCancel = new JButton("Cancel");
    btn_addStudentCancel.setBounds(106, 231, 105, 27);
    panel_addStudent.add(btn_addStudentCancel);

    btn_addStudentSave = new JButton("Save");
    btn_addStudentSave.setBounds(223, 231, 105, 27);
    panel_addStudent.add(btn_addStudentSave);

    panel_editTeacher = new JPanel();
    panel_editTeacher.setLayout(null);
    contentPane.add(panel_editTeacher, "panel_editTeacher");

    lbl_editTeacherTitle = new JLabel("Edit Teacher");
    lbl_editTeacherTitle.setBounds(12, 12, 107, 17);
    panel_editTeacher.add(lbl_editTeacherTitle);

    lbl_editTeacherName = new JLabel("Name:");
    lbl_editTeacherName.setBounds(12, 48, 107, 17);
    panel_editTeacher.add(lbl_editTeacherName);

    textField_editTeacherName = new JTextField();
    textField_editTeacherName.setColumns(10);
    textField_editTeacherName.setBounds(62, 46, 114, 21);
    panel_editTeacher.add(textField_editTeacherName);

    btn_editTeacherCancel = new JButton("Cancel");
    btn_editTeacherCancel.setBounds(106, 231, 105, 27);
    panel_editTeacher.add(btn_editTeacherCancel);

    btn_editTeacherSave = new JButton("Save");
    btn_editTeacherSave.setBounds(223, 231, 105, 27);
    panel_editTeacher.add(btn_editTeacherSave);

    lbl_editTeacherSubject1 = new JLabel("Subject 1:");
    lbl_editTeacherSubject1.setBounds(12, 112, 81, 17);
    panel_editTeacher.add(lbl_editTeacherSubject1);

    lbl_editTeacherSubject2 = new JLabel("Subject 2:");
    lbl_editTeacherSubject2.setBounds(12, 176, 81, 17);
    panel_editTeacher.add(lbl_editTeacherSubject2);

    comboBox_editTeacherSubject1 = new JComboBox<String>(subjectOptions);
    comboBox_editTeacherSubject1.setBounds(88, 107, 107, 26);
    panel_editTeacher.add(comboBox_editTeacherSubject1);

    comboBox_editTeacherSubject2 = new JComboBox<String>(subjectOptions);
    comboBox_editTeacherSubject2.setBounds(88, 171, 107, 26);
    panel_editTeacher.add(comboBox_editTeacherSubject2);

    panel_editIntlStudent = new JPanel();
    panel_editIntlStudent.setLayout(null);
    contentPane.add(panel_editIntlStudent, "panel_editIntlStudent");

    lbl_editIntlStudentTitle = new JLabel("Create International Student");
    lbl_editIntlStudentTitle.setBounds(12, 12, 179, 17);
    panel_editIntlStudent.add(lbl_editIntlStudentTitle);

    lbl_editIntlStudentName = new JLabel("Name:");
    lbl_editIntlStudentName.setBounds(12, 48, 107, 17);
    panel_editIntlStudent.add(lbl_editIntlStudentName);

    lbl_editIntlStudentGrade = new JLabel("Grade:");
    lbl_editIntlStudentGrade.setBounds(12, 113, 107, 17);
    panel_editIntlStudent.add(lbl_editIntlStudentGrade);

    textField_editIntlStudentName = new JTextField();
    textField_editIntlStudentName.setColumns(10);
    textField_editIntlStudentName.setBounds(62, 46, 114, 21);
    panel_editIntlStudent.add(textField_editIntlStudentName);

    comboBox_editIntlStudentGrade = new JComboBox<Integer>(gradeOptions);
    comboBox_editIntlStudentGrade.setBounds(62, 108, 57, 26);
    panel_editIntlStudent.add(comboBox_editIntlStudentGrade);

    btn_editIntlStudentCancel = new JButton("Cancel");
    btn_editIntlStudentCancel.setBounds(106, 231, 105, 27);
    panel_editIntlStudent.add(btn_editIntlStudentCancel);

    btn_editIntlStudentSave = new JButton("Save");
    btn_editIntlStudentSave.setBounds(223, 231, 105, 27);
    panel_editIntlStudent.add(btn_editIntlStudentSave);

    lbl_editIntlStudentCountry = new JLabel("Country:");
    lbl_editIntlStudentCountry.setBounds(12, 175, 60, 17);
    panel_editIntlStudent.add(lbl_editIntlStudentCountry);

    comboBox_editIntlStudentCountry = new JComboBox<String>(countryOptions);
    comboBox_editIntlStudentCountry.setBounds(72, 170, 104, 26);
    panel_editIntlStudent.add(comboBox_editIntlStudentCountry);

    panel_viewStudents = new JPanel();
    panel_viewStudents.setLayout(null);
    contentPane.add(panel_viewStudents, "panel_viewStudents");

    DefaultTableModel viewStudentsModel =
        new DefaultTableModel(new Object[] {"Name", "Grade"}, 0);
    table_viewStudents = new JTable(viewStudentsModel);
    viewStudentsModel.addRow(new Object[] {"Name", "Grade"});
    table_viewStudents.setEnabled(false);
    table_viewStudents.setBounds(0, 34, 440, 186);
    panel_viewStudents.add(table_viewStudents);

    lbl_viewStudentsTitle = new JLabel("All Students");
    lbl_viewStudentsTitle.setBounds(12, 12, 84, 17);
    panel_viewStudents.add(lbl_viewStudentsTitle);

    btn_viewStudentsCreate = new JButton("Create New Student");
    btn_viewStudentsCreate.setBounds(225, 232, 203, 27);
    panel_viewStudents.add(btn_viewStudentsCreate);

    btn_viewStudentsDelete = new JButton("Delete Student");
    btn_viewStudentsDelete.setBounds(12, 232, 201, 27);
    panel_viewStudents.add(btn_viewStudentsDelete);

    btn_viewStudentsGoHome = new JButton("Go Home");
    btn_viewStudentsGoHome.setBounds(323, 9, 105, 22);
    panel_viewStudents.add(btn_viewStudentsGoHome);

    panel_viewIntlStudents = new JPanel();
    panel_viewIntlStudents.setLayout(null);
    contentPane.add(panel_viewIntlStudents, "panel_viewIntlStudents");

    DefaultTableModel viewIntlStudentsModel =
        new DefaultTableModel(new Object[] {"Name", "Grade", "Country"}, 0);
    table_viewIntlStudents = new JTable(viewIntlStudentsModel);
    viewIntlStudentsModel.addRow(new Object[] {"Name", "Grade", "Country"});
    table_viewIntlStudents.setEnabled(false);
    table_viewIntlStudents.setBounds(0, 34, 440, 186);
    panel_viewIntlStudents.add(table_viewIntlStudents);

    lbl_viewIntlStudentsTitle = new JLabel("All International Students");
    lbl_viewIntlStudentsTitle.setBounds(12, 12, 168, 17);
    panel_viewIntlStudents.add(lbl_viewIntlStudentsTitle);

    btn_viewIntlStudentsCreate = new JButton("Create New Student");
    btn_viewIntlStudentsCreate.setBounds(225, 232, 203, 27);
    panel_viewIntlStudents.add(btn_viewIntlStudentsCreate);

    btn_viewIntlStudentsDelete = new JButton("Delete Student");
    btn_viewIntlStudentsDelete.setBounds(12, 232, 201, 27);
    panel_viewIntlStudents.add(btn_viewIntlStudentsDelete);

    btn_viewIntlStudentsGoHome = new JButton("Go Home");
    btn_viewIntlStudentsGoHome.setBounds(323, 9, 105, 22);
    panel_viewIntlStudents.add(btn_viewIntlStudentsGoHome);

    panel_home = new JPanel();
    contentPane.add(panel_home, "panel_home");
    panel_home.setLayout(null);

    lbl_homeChoose = new JLabel("Choose a table to view and modify:");
    lbl_homeChoose.setBounds(113, 12, 225, 17);
    panel_home.add(lbl_homeChoose);

    btn_homeStudent = new JButton("Student");
    btn_homeStudent.setBounds(12, 115, 125, 27);
    panel_home.add(btn_homeStudent);

    btn_homeIntlStudent = new JButton("Intl Student");
    btn_homeIntlStudent.setBounds(159, 115, 125, 27);
    panel_home.add(btn_homeIntlStudent);

    btn_homeTeacher = new JButton("Teacher");
    btn_homeTeacher.setBounds(303, 115, 125, 27);
    panel_home.add(btn_homeTeacher);

    masterLayout.show(contentPane, "panel_home");

    panel_deleteStudent = new JPanel();
    contentPane.add(panel_deleteStudent, "panel_deleteStudent");
    panel_deleteStudent.setLayout(null);

    btn_deleteStudentCancel = new JButton("Cancel");
    btn_deleteStudentCancel.setBounds(108, 231, 105, 27);
    panel_deleteStudent.add(btn_deleteStudentCancel);

    btn_deleteStudentDelete = new JButton("Delete");
    btn_deleteStudentDelete.setBounds(225, 231, 105, 27);
    panel_deleteStudent.add(btn_deleteStudentDelete);

    comboBox_deleteStudent = new JComboBox<String>(defaultDeletionOptions);
    comboBox_deleteStudent.setBounds(146, 109, 133, 26);
    panel_deleteStudent.add(comboBox_deleteStudent);

    lbl_deleteStudent = new JLabel("Choose a student to delete:");
    lbl_deleteStudent.setBounds(126, 80, 171, 17);
    panel_deleteStudent.add(lbl_deleteStudent);

    panel_deleteTeacher = new JPanel();
    panel_deleteTeacher.setLayout(null);
    contentPane.add(panel_deleteTeacher, "panel_deleteTeacher");

    btn_deleteTeacherCancel = new JButton("Cancel");
    btn_deleteTeacherCancel.setBounds(108, 231, 105, 27);
    panel_deleteTeacher.add(btn_deleteTeacherCancel);

    btn_deleteTeacherDelete = new JButton("Delete");
    btn_deleteTeacherDelete.setBounds(225, 231, 105, 27);
    panel_deleteTeacher.add(btn_deleteTeacherDelete);

    comboBox_deleteTeacher = new JComboBox<String>(defaultDeletionOptions);
    comboBox_deleteTeacher.setBounds(146, 109, 133, 26);
    panel_deleteTeacher.add(comboBox_deleteTeacher);

    lbl_deleteTeacher = new JLabel("Choose a teacher to delete:");
    lbl_deleteTeacher.setBounds(126, 80, 171, 17);
    panel_deleteTeacher.add(lbl_deleteTeacher);

    panel_deleteIntlStudent = new JPanel();
    panel_deleteIntlStudent.setLayout(null);
    contentPane.add(panel_deleteIntlStudent, "panel_deleteIntlStudent");

    btn_deleteIntlStudentCancel = new JButton("Cancel");
    btn_deleteIntlStudentCancel.setBounds(108, 231, 105, 27);
    panel_deleteIntlStudent.add(btn_deleteIntlStudentCancel);

    btn_deleteIntlStudentDelete = new JButton("Delete");
    btn_deleteIntlStudentDelete.setBounds(225, 231, 105, 27);
    panel_deleteIntlStudent.add(btn_deleteIntlStudentDelete);

    comboBox_deleteIntlStudent = new JComboBox<String>(defaultDeletionOptions);
    comboBox_deleteIntlStudent.setBounds(146, 109, 133, 26);
    panel_deleteIntlStudent.add(comboBox_deleteIntlStudent);

    lbl_deleteIntlStudent =
        new JLabel("Choose an international student to delete:");
    lbl_deleteIntlStudent.setBounds(91, 77, 252, 17);
    panel_deleteIntlStudent.add(lbl_deleteIntlStudent);
  }

  private void attachListeners() {
    // listeners for the home screen

    btn_homeStudent.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewStudents");
      }
    });

    btn_homeTeacher.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewTeachers");
      }
    });

    btn_homeIntlStudent.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewIntlStudents");
      }
    });

    // listners for the view students screen

    btn_viewStudentsGoHome.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_home");
      }
    });

    btn_viewStudentsCreate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_addStudent");
      }
    });

    btn_viewStudentsDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // if there are no students
        if (Engine.getStudents().size() == 0) {
          tempChangeLabel(btn_viewStudentsDelete, "No students yet!");
        } else {
          updateDeleteList(Student.class, comboBox_deleteStudent);
          masterLayout.show(contentPane, "panel_deleteStudent");
        }
      }
    });

    // listeners for the add student screen

    btn_addStudentCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewStudents");
      }
    });

    btn_addStudentSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (textField_addStudentName.getText().equals("")) {
          tempChangeLabel(lbl_addStudentTitle, "Please enter a name!");
        } else {
          Engine.getStudents().add(
              new Student(textField_addStudentName.getText(),
                          (int)comboBox_addStudentGrade.getSelectedItem()));
          updateViewTable(Student.class, table_viewStudents);
          masterLayout.show(contentPane, "panel_viewStudents");
        }
      }
    });

    // listeners for the delete student screen

    btn_deleteStudentCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewStudents");
      }
    });

    btn_deleteStudentDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int index = comboBox_deleteStudent.getSelectedIndex();
        Engine.getStudents().remove(Engine.getStudents().get(index));
        updateViewTable(Student.class, table_viewStudents);
        masterLayout.show(contentPane, "panel_viewStudents");
      }
    });

    // listners for the view teachers screen

    btn_viewTeachersGoHome.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_home");
      }
    });

    btn_viewTeachersCreate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_addTeacher");
      }
    });

    btn_viewTeachersDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // if there are no teachers
        if (Engine.getTeachers().size() == 0) {
          tempChangeLabel(btn_viewTeachersDelete, "No teachers yet!");
        } else {
          updateDeleteList(Teacher.class, comboBox_deleteTeacher);
          masterLayout.show(contentPane, "panel_deleteTeacher");
        }
      }
    });

    // listeners for the add teacher screen

    btn_addTeacherCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewTeachers");
      }
    });

    btn_addTeacherSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (textField_addTeacherName.getText().equals("")) {
          tempChangeLabel(lbl_addTeacherTitle, "Please enter a name!");
        } else {
          Engine.getTeachers().add(new Teacher(
              textField_addTeacherName.getText(),
              (String)comboBox_addTeacherSubject1.getSelectedItem(),
              (String)comboBox_addTeacherSubject2.getSelectedItem()));
          updateViewTable(Teacher.class, table_viewTeachers);
          masterLayout.show(contentPane, "panel_viewTeachers");
        }
      }
    });

    // listeners for the delete teacher screen

    btn_deleteTeacherCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewTeachers");
      }
    });

    btn_deleteTeacherDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int index = comboBox_deleteTeacher.getSelectedIndex();
        Engine.getTeachers().remove(Engine.getTeachers().get(index));
        updateViewTable(Teacher.class, table_viewTeachers);
        masterLayout.show(contentPane, "panel_viewTeachers");
      }
    });

    // listeners for the view international students screen

    btn_viewIntlStudentsGoHome.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_home");
      }
    });

    btn_viewIntlStudentsCreate.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_addIntlStudent");
      }
    });

    btn_viewIntlStudentsDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // if there are no international students
        if (Engine.getInternationalStudents().size() == 0) {
          tempChangeLabel(btn_viewIntlStudentsDelete, "No students yet!");
        } else {
          updateDeleteList(InternationalStudent.class,
                           comboBox_deleteIntlStudent);
          masterLayout.show(contentPane, "panel_deleteIntlStudent");
        }
      }
    });

    // listeners for the add international students screen

    btn_addIntlStudentCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewIntlStudents");
      }
    });

    btn_addIntlStudentSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        if (textField_addIntlStudentName.getText().equals("")) {
          tempChangeLabel(lbl_addIntlStudentTitle, "Please enter a name!");
        } else {
          Engine.getInternationalStudents().add(new InternationalStudent(
              textField_addIntlStudentName.getText(),
              (int)comboBox_addIntlStudentGrade.getSelectedItem(),
              (String)comboBox_addIntlStudentCountry.getSelectedItem()));
          updateViewTable(InternationalStudent.class, table_viewIntlStudents);
          masterLayout.show(contentPane, "panel_viewIntlStudents");
        }
      }
    });

    // listeners for the delete international students screen

    btn_deleteIntlStudentCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewIntlStudents");
      }
    });

    btn_deleteIntlStudentDelete.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        int index = comboBox_deleteIntlStudent.getSelectedIndex();
        Engine.getInternationalStudents().remove(
            Engine.getInternationalStudents().get(index));
        updateViewTable(InternationalStudent.class, table_viewIntlStudents);
        masterLayout.show(contentPane, "panel_viewIntlStudents");
      }
    });
  }

  public JFrame getFrame() { return frame; }
}
