package app;

import java.awt.CardLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GUI {

  private JFrame frame;
  private CardLayout masterLayout;

  private JPanel panel_addStudent, panel_editStudent, panel_viewStudents;

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
  private JButton btn_viewStudentsDelete, btn_viewStudentsCreate;

  private JPanel panel_addTeacher, panel_editTeacher, panel_viewTeachers;

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
  private JButton btn_viewTeachersCreate, btn_viewTeachersDelete;

  private JPanel panel_addIntlStudent, panel_editIntlStudent,
      panel_viewIntlStudents;

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
  private JButton btn_viewIntlStudentsCreate, btn_viewIntlStudentsDelete;

  DefaultComboBoxModel<String> subjectOptions, countryOptions;
  DefaultComboBoxModel<Integer> gradeOptions;

  public GUI() {
    initializeValues();
    setupGUI();
    attachListeners();
  }

  private void initializeValues() {
    subjectOptions = new DefaultComboBoxModel<String>(
        new String[] {"Math", "Business", "Computer Science", "English",
                      "Phys Ed", "Science"});

    gradeOptions =
        new DefaultComboBoxModel<Integer>(new Integer[] {9, 10, 11, 12});

    countryOptions = new DefaultComboBoxModel<String>(new String[] {
        "India", "China", "Russia", "United Kingdom", "France", "Germany",
        "South Africa", "Argentina", "Brazil", "United States of America"

    });
  }

  private void setupGUI() {
    frame = new JFrame();
    masterLayout = new CardLayout();

    frame.setResizable(false);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(masterLayout);

    panel_editStudent = new JPanel();
    frame.getContentPane().add(panel_editStudent, "panel_edit");
    panel_editStudent.setLayout(null);

    lbl_editStudentTitle = new JLabel("Edit Student");
    lbl_editStudentTitle.setBounds(174, 12, 107, 17);
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
    frame.getContentPane().add(panel_addTeacher, "panel_addTeacher");

    lbl_addTeacherTitle = new JLabel("Create Teacher");
    lbl_addTeacherTitle.setBounds(174, 12, 107, 17);
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
    frame.getContentPane().add(panel_viewTeachers, "panel_viewTeachers");

    table_viewTeachers = new JTable();
    table_viewTeachers.setBounds(0, 34, 440, 186);
    panel_viewTeachers.add(table_viewTeachers);

    lbl_viewTeachersTitle = new JLabel("All Teachers");
    lbl_viewTeachersTitle.setBounds(188, 12, 84, 17);
    panel_viewTeachers.add(lbl_viewTeachersTitle);

    btn_viewTeachersCreate = new JButton("Create New Teacher");
    btn_viewTeachersCreate.setBounds(225, 232, 203, 27);
    panel_viewTeachers.add(btn_viewTeachersCreate);

    btn_viewTeachersDelete = new JButton("Delete Teacher");
    btn_viewTeachersDelete.setBounds(12, 232, 201, 27);
    panel_viewTeachers.add(btn_viewTeachersDelete);

    panel_addIntlStudent = new JPanel();
    panel_addIntlStudent.setLayout(null);
    frame.getContentPane().add(panel_addIntlStudent, "panel_addIntlStudent");

    lbl_addIntlStudentTitle = new JLabel("Create International Student");
    lbl_addIntlStudentTitle.setBounds(137, 12, 179, 17);
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
    frame.getContentPane().add(panel_addStudent, "panel_addStudent");

    lbl_addStudentTitle = new JLabel("Create Student");
    lbl_addStudentTitle.setBounds(174, 12, 107, 17);
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
    frame.getContentPane().add(panel_editTeacher, "panel_editTeacher");

    lbl_editTeacherTitle = new JLabel("Edit Teacher");
    lbl_editTeacherTitle.setBounds(174, 12, 107, 17);
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
    frame.getContentPane().add(panel_editIntlStudent, "panel_editIntlStudent");

    lbl_editIntlStudentTitle = new JLabel("Create International Student");
    lbl_editIntlStudentTitle.setBounds(137, 12, 179, 17);
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
    frame.getContentPane().add(panel_viewStudents, "panel_viewStudents");

    table_viewStudents = new JTable();
    table_viewStudents.setBounds(0, 34, 440, 186);
    panel_viewStudents.add(table_viewStudents);

    lbl_viewStudentsTitle = new JLabel("All Students");
    lbl_viewStudentsTitle.setBounds(188, 12, 84, 17);
    panel_viewStudents.add(lbl_viewStudentsTitle);

    btn_viewStudentsCreate = new JButton("Create New Student");
    btn_viewStudentsCreate.setBounds(225, 232, 203, 27);
    panel_viewStudents.add(btn_viewStudentsCreate);

    btn_viewStudentsDelete = new JButton("Delete Student");
    btn_viewStudentsDelete.setBounds(12, 232, 201, 27);
    panel_viewStudents.add(btn_viewStudentsDelete);

    panel_viewIntlStudents = new JPanel();
    panel_viewIntlStudents.setLayout(null);
    frame.getContentPane().add(panel_viewIntlStudents,
                               "panel_viewIntlStudents");

    table_viewIntlStudents = new JTable();
    table_viewIntlStudents.setBounds(0, 34, 440, 186);
    panel_viewIntlStudents.add(table_viewIntlStudents);

    lbl_viewIntlStudentsTitle = new JLabel("All International Students");
    lbl_viewIntlStudentsTitle.setBounds(145, 12, 168, 17);
    panel_viewIntlStudents.add(lbl_viewIntlStudentsTitle);

    btn_viewIntlStudentsCreate = new JButton("Create New Student");
    btn_viewIntlStudentsCreate.setBounds(225, 232, 203, 27);
    panel_viewIntlStudents.add(btn_viewIntlStudentsCreate);

    btn_viewIntlStudentsDelete = new JButton("Delete Student");
    btn_viewIntlStudentsDelete.setBounds(12, 232, 201, 27);
    panel_viewIntlStudents.add(btn_viewIntlStudentsDelete);
  }

  private void attachListeners() {}

  public JFrame getFrame() { return frame; }
}
