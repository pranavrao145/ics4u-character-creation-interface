package app;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

  private JFrame frame;
  private JPanel panel_addStudent, panel_edit, panel_view;
  private JLabel lbl_addSchoolName, lbl_addGrade, lbl_addTitle, lbl_addName,
      lbl_addAge;
  private JTextField textField_addName, textField_addSchoolName;
  private JComboBox<Integer> comboBox_addAge, comboBox_addGrade;
  private JButton btn_addCancel, btn_addSave;

  private JTextField textField_editName, textField_editSchoolName;
  private JLabel lbl_editTitle, lbl_editName, lbl_editAge, lbl_editSchoolName,
      lbl_editGrade;
  private JComboBox<Integer> comboBox_editAge, comboBox_editGrade;
  private JButton btn_editCancel, btn_editSave;

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

    lbl_addTitle = new JLabel("Create Student");
    lbl_addTitle.setBounds(174, 12, 107, 17);
    panel_addStudent.add(lbl_addTitle);

    lbl_addName = new JLabel("Name:");
    lbl_addName.setBounds(12, 48, 107, 17);
    panel_addStudent.add(lbl_addName);

    lbl_addAge = new JLabel("Age:");
    lbl_addAge.setBounds(12, 91, 107, 17);
    panel_addStudent.add(lbl_addAge);

    lbl_addSchoolName = new JLabel("School Name:");
    lbl_addSchoolName.setBounds(12, 138, 107, 17);
    panel_addStudent.add(lbl_addSchoolName);

    lbl_addGrade = new JLabel("Grade:");
    lbl_addGrade.setBounds(12, 185, 107, 17);
    panel_addStudent.add(lbl_addGrade);

    textField_addName = new JTextField();
    textField_addName.setBounds(62, 46, 114, 21);
    panel_addStudent.add(textField_addName);
    textField_addName.setColumns(10);

    comboBox_addAge = new JComboBox<Integer>();
    comboBox_addAge.setBounds(62, 86, 31, 26);
    panel_addStudent.add(comboBox_addAge);

    textField_addSchoolName = new JTextField();
    textField_addSchoolName.setBounds(106, 136, 114, 21);
    panel_addStudent.add(textField_addSchoolName);
    textField_addSchoolName.setColumns(10);

    comboBox_addGrade = new JComboBox<Integer>();
    comboBox_addGrade.setBounds(62, 180, 31, 26);
    panel_addStudent.add(comboBox_addGrade);

    btn_addCancel = new JButton("Cancel");
    btn_addCancel.setBounds(106, 231, 105, 27);
    panel_addStudent.add(btn_addCancel);

    btn_addSave = new JButton("Save");

    btn_addSave.setBounds(223, 231, 105, 27);
    panel_addStudent.add(btn_addSave);

    panel_edit = new JPanel();
    frame.getContentPane().add(panel_edit, "panel_edit");
    panel_edit.setLayout(null);

    lbl_editTitle = new JLabel("Edit Student");
    lbl_editTitle.setBounds(174, 12, 107, 17);
    panel_edit.add(lbl_editTitle);

    lbl_editName = new JLabel("Name:");
    lbl_editName.setBounds(12, 48, 107, 17);
    panel_edit.add(lbl_editName);

    lbl_editAge = new JLabel("Age:");
    lbl_editAge.setBounds(12, 91, 107, 17);
    panel_edit.add(lbl_editAge);

    lbl_editSchoolName = new JLabel("School Name:");
    lbl_editSchoolName.setBounds(12, 138, 107, 17);
    panel_edit.add(lbl_editSchoolName);

    lbl_editGrade = new JLabel("Grade:");
    lbl_editGrade.setBounds(12, 185, 107, 17);
    panel_edit.add(lbl_editGrade);

    textField_editName = new JTextField();
    textField_editName.setColumns(10);
    textField_editName.setBounds(62, 46, 114, 21);
    panel_edit.add(textField_editName);

    comboBox_editAge = new JComboBox<Integer>();
    comboBox_editAge.setBounds(62, 86, 31, 26);
    panel_edit.add(comboBox_editAge);

    textField_editSchoolName = new JTextField();
    textField_editSchoolName.setColumns(10);
    textField_editSchoolName.setBounds(106, 136, 114, 21);
    panel_edit.add(textField_editSchoolName);

    comboBox_editGrade = new JComboBox<Integer>();
    comboBox_editGrade.setBounds(62, 180, 31, 26);
    panel_edit.add(comboBox_editGrade);

    btn_editCancel = new JButton("Cancel");
    btn_editCancel.setBounds(106, 231, 105, 27);
    panel_edit.add(btn_editCancel);

    btn_editSave = new JButton("Save");
    btn_editSave.setBounds(223, 231, 105, 27);
    panel_edit.add(btn_editSave);

    panel_view = new JPanel();
    frame.getContentPane().add(panel_view, "panel_view");
    panel_view.setLayout(null);
  }

  private void attachListeners() {
    btn_addSave.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // add logic to validate inputs and store to database, then go back to
        // view
      }
    });

    btn_addCancel.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        // add logic to abandon and go back to view
      }
    });
  }

  public JFrame getFrame() { return frame; }
}
