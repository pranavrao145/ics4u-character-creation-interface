package app;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class GUI {

  private JFrame frame;
  private JPanel panel_addStudent, panel_editStudent, panel_viewStudents;
  private JLabel lbl_addStudentGrade, lbl_addStudentTitle, lbl_addStudentName,
      lbl_addStudentAge;
  private JTextField textField_addStudentName;
  private JComboBox<Integer> comboBox_addStudentAge, comboBox_addStudentGrade;
  private JButton btn_addStudentCancel, btn_addStudentSave;

  private JTextField textField_editStudentName;
  private JLabel lbl_editStudentTitle, lbl_editStudentName,
      lbl_editStudentGrade;
  private JComboBox<Integer> comboBox_editStudentGrade;
  private JButton btn_editStudentCancel, btn_editStudentSave;

  private JTable table_viewStudents;
  private JLabel lbl_viewStudentsTitle;
  private JTextField textField_addTeacherName;
  private JTable table_viewTeachers;
  private JPanel panel_viewTeachers;
  private JPanel panel_addTeacher;
  private JLabel lbl_editStudentAge;
  private JComboBox<Integer> comboBox_editStudentAge;
  private JLabel lbl_addTeacherSubject1;
  private JLabel lbl_addTeacherSubject2;
  private JComboBox comboBox_addTeacherSubject1;
  private JComboBox comboBox_addTeacherSubject2;
  private JLabel lbl_addTeacherTitle;
  private JLabel lbl_addTeacherName;
  private JLabel lbl_addTeacherAge;
  private JComboBox<Integer> comboBox_addTeacherAge;
  private JButton btn_addTeacherCancel;
  private JButton btn_addTeacherSave;
  private JPanel panel_editTeacher;
  private JLabel lbl_editeacherTitle;
  private JLabel lbl_editTeacherName;
  private JLabel lbl_editTeacherAge;
  private JTextField textField_editTeacherName;
  private JComboBox<Integer> comboBox_editTeacherAge;
  private JButton btn_editTeacherCancel;
  private JButton btn_editTeacherSave;
  private JLabel lbl_editTeacherSubject1;
  private JLabel lbl_editTeacherSubject2;
  private JComboBox<?> comboBox_editTeacherSubject1;
  private JComboBox<?> comboBox_editTeacherSubject2;
  private JPanel panel_addIntlStudent;
  private JLabel lbl_addIntlStudentTitle;
  private JLabel lbl_addIntlStudentName;
  private JLabel lbl_addIntlStudentAge;
  private JLabel lbl_addIntlStudentGrade;
  private JTextField textField_addIntlStudentName;
  private JComboBox<Integer> comboBox_addIntlStudentAge;
  private JComboBox<Integer> comboBox_addIntlStudentGrade;
  private JButton btn_addIntlStudentCancel;
  private JButton btn_addIntlStudentSave;
  private JPanel panel_viewIntlStudents;
  private JTable table_viewIntlStudents;
  private JLabel lbl_viewIntlStudentsTitle;
  private JLabel lbl_addIntlStudentCountry;
  private JComboBox<Integer> comboBox_addIntlStudentCountry;
  private JPanel panel_editIntlStudent;
  private JLabel lbl_editIntlStudentTitle;
  private JLabel lbl_editIntlStudentName;
  private JLabel lbl_editIntlStudentAge;
  private JLabel lbl_editIntlStudentGrade;
  private JTextField textField_editIntlStudentName;
  private JComboBox<Integer> comboBox_editIntlStudentAge;
  private JComboBox<Integer> comboBox_editIntlStudentGrade;
  private JButton btn_editIntlStudentCancel;
  private JButton btn_editIntlStudentSave;
  private JLabel lbl_editIntlStudentCountry;
  private JComboBox<Integer> comboBox_editIntlStudentCountry;

  public GUI() {
    initialize();
    attachListeners();
  }

  private void initialize() {
    frame = new JFrame();
    frame.setResizable(false);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new CardLayout(0, 0));

    panel_addStudent = new JPanel();
    frame.getContentPane().add(panel_addStudent, "panel_addStudent");
    panel_addStudent.setLayout(null);

    lbl_addStudentTitle = new JLabel("Create Student");
    lbl_addStudentTitle.setBounds(174, 12, 107, 17);
    panel_addStudent.add(lbl_addStudentTitle);

    lbl_addStudentName = new JLabel("Name:");
    lbl_addStudentName.setBounds(12, 48, 107, 17);
    panel_addStudent.add(lbl_addStudentName);

    lbl_addStudentAge = new JLabel("Age:");
    lbl_addStudentAge.setBounds(12, 114, 107, 17);
    panel_addStudent.add(lbl_addStudentAge);

    lbl_addStudentGrade = new JLabel("Grade:");
    lbl_addStudentGrade.setBounds(12, 185, 107, 17);
    panel_addStudent.add(lbl_addStudentGrade);

    textField_addStudentName = new JTextField();
    textField_addStudentName.setBounds(62, 46, 114, 21);
    panel_addStudent.add(textField_addStudentName);
    textField_addStudentName.setColumns(10);

    comboBox_addStudentAge = new JComboBox<Integer>();
    comboBox_addStudentAge.setBounds(62, 109, 31, 26);
    panel_addStudent.add(comboBox_addStudentAge);

    comboBox_addStudentGrade = new JComboBox<Integer>();
    comboBox_addStudentGrade.setBounds(62, 180, 31, 26);
    panel_addStudent.add(comboBox_addStudentGrade);

    btn_addStudentCancel = new JButton("Cancel");
    btn_addStudentCancel.setBounds(106, 231, 105, 27);
    panel_addStudent.add(btn_addStudentCancel);

    btn_addStudentSave = new JButton("Save");

    btn_addStudentSave.setBounds(223, 231, 105, 27);
    panel_addStudent.add(btn_addStudentSave);

    panel_editStudent = new JPanel();
    frame.getContentPane().add(panel_editStudent, "panel_edit");
    panel_editStudent.setLayout(null);

    lbl_editStudentTitle = new JLabel("Edit Student");
    lbl_editStudentTitle.setBounds(174, 12, 107, 17);
    panel_editStudent.add(lbl_editStudentTitle);

    lbl_editStudentName = new JLabel("Name:");
    lbl_editStudentName.setBounds(12, 48, 107, 17);
    panel_editStudent.add(lbl_editStudentName);

    lbl_editStudentGrade = new JLabel("Grade:");
    lbl_editStudentGrade.setBounds(12, 185, 107, 17);
    panel_editStudent.add(lbl_editStudentGrade);

    textField_editStudentName = new JTextField();
    textField_editStudentName.setColumns(10);
    textField_editStudentName.setBounds(62, 46, 114, 21);
    panel_editStudent.add(textField_editStudentName);

    comboBox_editStudentGrade = new JComboBox<Integer>();
    comboBox_editStudentGrade.setBounds(62, 180, 31, 26);
    panel_editStudent.add(comboBox_editStudentGrade);

    btn_editStudentCancel = new JButton("Cancel");
    btn_editStudentCancel.setBounds(106, 231, 105, 27);
    panel_editStudent.add(btn_editStudentCancel);

    btn_editStudentSave = new JButton("Save");
    btn_editStudentSave.setBounds(223, 231, 105, 27);
    panel_editStudent.add(btn_editStudentSave);
    
    lbl_editStudentAge = new JLabel("Age:");
    lbl_editStudentAge.setBounds(12, 114, 107, 17);
    panel_editStudent.add(lbl_editStudentAge);
    
    comboBox_editStudentAge = new JComboBox<Integer>();
    comboBox_editStudentAge.setBounds(62, 109, 31, 26);
    panel_editStudent.add(comboBox_editStudentAge);

    panel_viewStudents = new JPanel();
    frame.getContentPane().add(panel_viewStudents, "panel_view");
    panel_viewStudents.setLayout(null);

    table_viewStudents = new JTable();
    table_viewStudents.setBounds(0, 34, 440, 224);
    panel_viewStudents.add(table_viewStudents);

    lbl_viewStudentsTitle = new JLabel("All Students");
    lbl_viewStudentsTitle.setBounds(188, 12, 84, 17);
    panel_viewStudents.add(lbl_viewStudentsTitle);
    
    panel_addTeacher = new JPanel();
    panel_addTeacher.setLayout(null);
    frame.getContentPane().add(panel_addTeacher, "name_1974028917161");
    
    lbl_addTeacherTitle = new JLabel("Create Teacher");
    lbl_addTeacherTitle.setBounds(174, 12, 107, 17);
    panel_addTeacher.add(lbl_addTeacherTitle);
    
    lbl_addTeacherName = new JLabel("Name:");
    lbl_addTeacherName.setBounds(12, 48, 107, 17);
    panel_addTeacher.add(lbl_addTeacherName);
    
    lbl_addTeacherAge = new JLabel("Age:");
    lbl_addTeacherAge.setBounds(12, 91, 107, 17);
    panel_addTeacher.add(lbl_addTeacherAge);
    
    textField_addTeacherName = new JTextField();
    textField_addTeacherName.setColumns(10);
    textField_addTeacherName.setBounds(62, 46, 114, 21);
    panel_addTeacher.add(textField_addTeacherName);
    
    comboBox_addTeacherAge = new JComboBox<Integer>();
    comboBox_addTeacherAge.setBounds(62, 86, 31, 26);
    panel_addTeacher.add(comboBox_addTeacherAge);
    
    btn_addTeacherCancel = new JButton("Cancel");
    btn_addTeacherCancel.setBounds(106, 231, 105, 27);
    panel_addTeacher.add(btn_addTeacherCancel);
    
    btn_addTeacherSave = new JButton("Save");
    btn_addTeacherSave.setBounds(223, 231, 105, 27);
    panel_addTeacher.add(btn_addTeacherSave);
    
    lbl_addTeacherSubject1 = new JLabel("Subject 1:");
    lbl_addTeacherSubject1.setBounds(12, 141, 81, 17);
    panel_addTeacher.add(lbl_addTeacherSubject1);
    
    lbl_addTeacherSubject2 = new JLabel("Subject 2:");
    lbl_addTeacherSubject2.setBounds(12, 184, 81, 17);
    panel_addTeacher.add(lbl_addTeacherSubject2);
    
    comboBox_addTeacherSubject1 = new JComboBox();
    comboBox_addTeacherSubject1.setBounds(88, 136, 31, 26);
    panel_addTeacher.add(comboBox_addTeacherSubject1);
    
    comboBox_addTeacherSubject2 = new JComboBox();
    comboBox_addTeacherSubject2.setBounds(88, 179, 31, 26);
    panel_addTeacher.add(comboBox_addTeacherSubject2);
    
    panel_viewTeachers = new JPanel();
    panel_viewTeachers.setLayout(null);
    frame.getContentPane().add(panel_viewTeachers, "name_2076682974155");
    
    table_viewTeachers = new JTable();
    table_viewTeachers.setBounds(0, 34, 440, 224);
    panel_viewTeachers.add(table_viewTeachers);
    
    JLabel lbl_viewTeachersTitle = new JLabel("All Teacher");
    lbl_viewTeachersTitle.setBounds(188, 12, 84, 17);
    panel_viewTeachers.add(lbl_viewTeachersTitle);
    
    panel_editTeacher = new JPanel();
    panel_editTeacher.setLayout(null);
    frame.getContentPane().add(panel_editTeacher, "name_2810509183947");
    
    lbl_editeacherTitle = new JLabel("Edit Teacher");
    lbl_editeacherTitle.setBounds(174, 12, 107, 17);
    panel_editTeacher.add(lbl_editeacherTitle);
    
    lbl_editTeacherName = new JLabel("Name:");
    lbl_editTeacherName.setBounds(12, 48, 107, 17);
    panel_editTeacher.add(lbl_editTeacherName);
    
    lbl_editTeacherAge = new JLabel("Age:");
    lbl_editTeacherAge.setBounds(12, 91, 107, 17);
    panel_editTeacher.add(lbl_editTeacherAge);
    
    textField_editTeacherName = new JTextField();
    textField_editTeacherName.setColumns(10);
    textField_editTeacherName.setBounds(62, 46, 114, 21);
    panel_editTeacher.add(textField_editTeacherName);
    
    comboBox_editTeacherAge = new JComboBox<Integer>();
    comboBox_editTeacherAge.setBounds(62, 86, 31, 26);
    panel_editTeacher.add(comboBox_editTeacherAge);
    
    btn_editTeacherCancel = new JButton("Cancel");
    btn_editTeacherCancel.setBounds(106, 231, 105, 27);
    panel_editTeacher.add(btn_editTeacherCancel);
    
    btn_editTeacherSave = new JButton("Save");
    btn_editTeacherSave.setBounds(223, 231, 105, 27);
    panel_editTeacher.add(btn_editTeacherSave);
    
    lbl_editTeacherSubject1 = new JLabel("Subject 1:");
    lbl_editTeacherSubject1.setBounds(12, 141, 81, 17);
    panel_editTeacher.add(lbl_editTeacherSubject1);
    
    lbl_editTeacherSubject2 = new JLabel("Subject 2:");
    lbl_editTeacherSubject2.setBounds(12, 184, 81, 17);
    panel_editTeacher.add(lbl_editTeacherSubject2);
    
    comboBox_editTeacherSubject1 = new JComboBox();
    comboBox_editTeacherSubject1.setBounds(88, 136, 31, 26);
    panel_editTeacher.add(comboBox_editTeacherSubject1);
    
    comboBox_editTeacherSubject2 = new JComboBox();
    comboBox_editTeacherSubject2.setBounds(88, 179, 31, 26);
    panel_editTeacher.add(comboBox_editTeacherSubject2);
    
    panel_addIntlStudent = new JPanel();
    panel_addIntlStudent.setLayout(null);
    frame.getContentPane().add(panel_addIntlStudent, "name_3023881280242");
    
    lbl_addIntlStudentTitle = new JLabel("Create International Student");
    lbl_addIntlStudentTitle.setBounds(137, 12, 179, 17);
    panel_addIntlStudent.add(lbl_addIntlStudentTitle);
    
    lbl_addIntlStudentName = new JLabel("Name:");
    lbl_addIntlStudentName.setBounds(12, 48, 107, 17);
    panel_addIntlStudent.add(lbl_addIntlStudentName);
    
    lbl_addIntlStudentAge = new JLabel("Age:");
    lbl_addIntlStudentAge.setBounds(12, 95, 107, 17);
    panel_addIntlStudent.add(lbl_addIntlStudentAge);
    
    lbl_addIntlStudentGrade = new JLabel("Grade:");
    lbl_addIntlStudentGrade.setBounds(12, 138, 107, 17);
    panel_addIntlStudent.add(lbl_addIntlStudentGrade);
    
    textField_addIntlStudentName = new JTextField();
    textField_addIntlStudentName.setColumns(10);
    textField_addIntlStudentName.setBounds(62, 46, 114, 21);
    panel_addIntlStudent.add(textField_addIntlStudentName);
    
    comboBox_addIntlStudentAge = new JComboBox<Integer>();
    comboBox_addIntlStudentAge.setBounds(62, 90, 31, 26);
    panel_addIntlStudent.add(comboBox_addIntlStudentAge);
    
    comboBox_addIntlStudentGrade = new JComboBox<Integer>();
    comboBox_addIntlStudentGrade.setBounds(62, 133, 31, 26);
    panel_addIntlStudent.add(comboBox_addIntlStudentGrade);
    
    btn_addIntlStudentCancel = new JButton("Cancel");
    btn_addIntlStudentCancel.setBounds(106, 231, 105, 27);
    panel_addIntlStudent.add(btn_addIntlStudentCancel);
    
    btn_addIntlStudentSave = new JButton("Save");
    btn_addIntlStudentSave.setBounds(223, 231, 105, 27);
    panel_addIntlStudent.add(btn_addIntlStudentSave);
    
    lbl_addIntlStudentCountry = new JLabel("Country:");
    lbl_addIntlStudentCountry.setBounds(12, 182, 60, 17);
    panel_addIntlStudent.add(lbl_addIntlStudentCountry);
    
    comboBox_addIntlStudentCountry = new JComboBox<Integer>();
    comboBox_addIntlStudentCountry.setBounds(72, 177, 31, 26);
    panel_addIntlStudent.add(comboBox_addIntlStudentCountry);
    
    panel_viewIntlStudents = new JPanel();
    panel_viewIntlStudents.setLayout(null);
    frame.getContentPane().add(panel_viewIntlStudents, "name_3024962085836");
    
    table_viewIntlStudents = new JTable();
    table_viewIntlStudents.setBounds(0, 34, 440, 224);
    panel_viewIntlStudents.add(table_viewIntlStudents);
    
    lbl_viewIntlStudentsTitle = new JLabel("All International Students");
    lbl_viewIntlStudentsTitle.setBounds(139, 12, 170, 17);
    panel_viewIntlStudents.add(lbl_viewIntlStudentsTitle);
    
    panel_editIntlStudent = new JPanel();
    panel_editIntlStudent.setLayout(null);
    frame.getContentPane().add(panel_editIntlStudent, "name_3350108683546");
    
    lbl_editIntlStudentTitle = new JLabel("Edit International Student");
    lbl_editIntlStudentTitle.setBounds(137, 12, 179, 17);
    panel_editIntlStudent.add(lbl_editIntlStudentTitle);
    
    lbl_editIntlStudentName = new JLabel("Name:");
    lbl_editIntlStudentName.setBounds(12, 48, 107, 17);
    panel_editIntlStudent.add(lbl_editIntlStudentName);
    
    lbl_editIntlStudentAge = new JLabel("Age:");
    lbl_editIntlStudentAge.setBounds(12, 95, 107, 17);
    panel_editIntlStudent.add(lbl_editIntlStudentAge);
    
    lbl_editIntlStudentGrade = new JLabel("Grade:");
    lbl_editIntlStudentGrade.setBounds(12, 138, 107, 17);
    panel_editIntlStudent.add(lbl_editIntlStudentGrade);
    
    textField_editIntlStudentName = new JTextField();
    textField_editIntlStudentName.setColumns(10);
    textField_editIntlStudentName.setBounds(62, 46, 114, 21);
    panel_editIntlStudent.add(textField_editIntlStudentName);
    
    comboBox_editIntlStudentAge = new JComboBox<Integer>();
    comboBox_editIntlStudentAge.setBounds(62, 90, 31, 26);
    panel_editIntlStudent.add(comboBox_editIntlStudentAge);
    
    comboBox_editIntlStudentGrade = new JComboBox<Integer>();
    comboBox_editIntlStudentGrade.setBounds(62, 133, 31, 26);
    panel_editIntlStudent.add(comboBox_editIntlStudentGrade);
    
    btn_editIntlStudentCancel = new JButton("Cancel");
    btn_editIntlStudentCancel.setBounds(106, 231, 105, 27);
    panel_editIntlStudent.add(btn_editIntlStudentCancel);
    
    btn_editIntlStudentSave = new JButton("Save");
    btn_editIntlStudentSave.setBounds(223, 231, 105, 27);
    panel_editIntlStudent.add(btn_editIntlStudentSave);
    
    lbl_editIntlStudentCountry = new JLabel("Country:");
    lbl_editIntlStudentCountry.setBounds(12, 182, 60, 17);
    panel_editIntlStudent.add(lbl_editIntlStudentCountry);
    
    comboBox_editIntlStudentCountry = new JComboBox<Integer>();
    comboBox_editIntlStudentCountry.setBounds(72, 177, 31, 26);
    panel_editIntlStudent.add(comboBox_editIntlStudentCountry);
  }

  private void attachListeners() {
    btn_addStudentSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // add logic to validate inputs and store to database, then go back to
        // view
      }
    });

    btn_addStudentCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // add logic to abandon and go back to view
      }
    });
  }

  public JFrame getFrame() { return frame; }
}
