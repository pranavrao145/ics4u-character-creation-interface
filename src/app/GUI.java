/******************************************************************************
Program: GUI (Character Creation Interface)

Description: This is GUI for this app. This class contains all of the
methods to run the GUI of the app, such as to draw and update the GUI,
as well as to attach listeners.

Author: Pranav Rao

Date: March 1, 2022
*******************************************************************************/

package app;

// import all necessary Swing components

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

// import all models from the model package
import models.InternationalStudent;
import models.Student;
import models.Teacher;

public class GUI {
  // the following set of fields represent the various GUI components used in
  // this App. To simplify the identification of components, all components are
  // named using this convention: componentType_panelNameComponentName
  // For example, a button to save on the add student panel would be named
  // btn_addStudentSave

  private JFrame frame;
  private Container
      contentPane; // this is a special variable that will store the content
                   // pane of the frame so it does not need to be re-read every
                   // time we want to use it
  private CardLayout masterLayout; // this CardLayout is being stored because it
                                   // will be essential in switching views

  // rest of the components, grouped by the panel they are on and following the
  // naming convention above
  private JPanel panel_home;
  private JLabel lbl_homeChoose;
  private JButton btn_homeStudent, btn_homeIntlStudent, btn_homeTeacher,
      btn_homeQuit;

  private JPanel panel_addStudent, panel_editStudent,
      panel_editStudentSelection, panel_viewStudents, panel_deleteStudent;

  private JLabel lbl_addStudentName, lbl_addStudentTitle, lbl_addStudentGrade;
  private JButton btn_addStudentSave, btn_addStudentCancel;
  private JTextField textField_addStudentName;
  private JComboBox<Integer> comboBox_addStudentGrade;

  private JLabel lbl_editStudentSelection;
  private JComboBox<String> comboBox_editStudentSelection;
  private JButton btn_editStudentSelectionCancel, btn_editStudentSelectionEdit;

  private JTextField textField_editStudentName;
  private JLabel lbl_editStudentTitle, lbl_editStudentName,
      lbl_editStudentGrade;
  private JComboBox<Integer> comboBox_editStudentGrade;
  private JButton btn_editStudentCancel, btn_editStudentSave;
  private int currentlyEditingStudent;

  private JLabel lbl_viewStudentsTitle;
  private JTable table_viewStudents;
  private JButton btn_viewStudentsDelete, btn_viewStudentsCreate,
      btn_viewStudentsGoHome, btn_viewStudentsEditSelection;

  private JButton btn_deleteStudentCancel, btn_deleteStudentDelete;
  private JLabel lbl_deleteStudent;
  private JComboBox<String> comboBox_deleteStudent;

  private JPanel panel_addTeacher, panel_editTeacher, panel_viewTeachers,
      panel_deleteTeacher, panel_editTeacherSelection;

  private JLabel lbl_addTeacherName, lbl_addTeacherTitle,
      lbl_addTeacherSubject1, lbl_addTeacherSubject2;
  private JButton btn_addTeacherSave, btn_addTeacherCancel;
  private JTextField textField_addTeacherName;
  private JComboBox<String> comboBox_addTeacherSubject1,
      comboBox_addTeacherSubject2;

  private JButton btn_editTeacherSelectionCancel, btn_editTeacherSelectionEdit;
  private JComboBox<String> comboBox_editTeacherSelection;
  private JLabel lbl_editTeacherSelection;
  private int currentlyEditingTeacher;

  private JLabel lbl_editTeacherName, lbl_editTeacherTitle,
      lbl_editTeacherSubject1, lbl_editTeacherSubject2;
  private JButton btn_editTeacherSave, btn_editTeacherCancel;
  private JTextField textField_editTeacherName;
  private JComboBox<String> comboBox_editTeacherSubject1,
      comboBox_editTeacherSubject2;

  private JLabel lbl_viewTeachersTitle;
  private JTable table_viewTeachers;
  private JButton btn_viewTeachersCreate, btn_viewTeachersDelete,
      btn_viewTeachersGoHome, btn_viewTeachersEditSelection;

  private JButton btn_deleteTeacherDelete, btn_deleteTeacherCancel;
  private JLabel lbl_deleteTeacher;
  private JComboBox<String> comboBox_deleteTeacher;

  private JPanel panel_addIntlStudent, panel_editIntlStudent,
      panel_viewIntlStudents, panel_deleteIntlStudent,
      panel_editIntlStudentSelection;

  private JLabel lbl_addIntlStudentName, lbl_addIntlStudentTitle,
      lbl_addIntlStudentGrade, lbl_addIntlStudentCountry;
  private JButton btn_addIntlStudentSave, btn_addIntlStudentCancel;
  private JTextField textField_addIntlStudentName;
  private JComboBox<Integer> comboBox_addIntlStudentGrade;
  private JComboBox<String> comboBox_addIntlStudentCountry;

  private JLabel lbl_editIntlStudentSelectionCancel;
  private JComboBox<String> comboBox_editIntlStudentSelection;
  private JButton btn_editIntlStudentSelectionCancel,
      btn_editIntlStudentSelectionEdit;
  private int currentlyEditingInternationalStudent;

  private JLabel lbl_editIntlStudentTitle, lbl_editIntlStudentName,
      lbl_editIntlStudentGrade, lbl_editIntlStudentCountry;
  private JTextField textField_editIntlStudentName;
  private JButton btn_editIntlStudentCancel, btn_editIntlStudentSave;
  private JComboBox<Integer> comboBox_editIntlStudentGrade;
  private JComboBox<String> comboBox_editIntlStudentCountry;

  private JTable table_viewIntlStudents;
  private JLabel lbl_viewIntlStudentsTitle;
  private JButton btn_viewIntlStudentsCreate, btn_viewIntlStudentsDelete,
      btn_viewIntlStudentsGoHome, btn_viewIntlStudentsEditSelection;

  private JButton btn_deleteIntlStudentCancel, btn_deleteIntlStudentDelete;
  private JLabel lbl_deleteIntlStudent;
  private JComboBox<String> comboBox_deleteIntlStudent;

  // these are special variables that represent the models used to power the
  // comboBox components in this program

  DefaultComboBoxModel<String> subject1Options, subject2Options, countryOptions,
      defaultDeletionOptions, defaultEditOptions;
  DefaultComboBoxModel<Integer> gradeOptions;

  /**
   * This is a constructor for the GUI. When the GUI is made in the App class,
   * this method will be called.
   */
  public GUI() {
    initializeValues();     // assigns initial values to some variables declared
                            // above
    setupGUI();             // sets up and draws the GUI
    attachListeners();      // attaches the listeners to various GUI components
    frame.setVisible(true); // sets the frame to visible so the user can see it
  }

  /**
   * This method is responsible for setting intial values for some variables
   * above, specifically the option models for the comboBox components.
   */
  private void initializeValues() {
    subject1Options = new DefaultComboBoxModel<String>(
        new String[] {"Math", "Business", "Computer Science", "English",
                      "Phys Ed", "Science"});

    subject2Options = new DefaultComboBoxModel<String>(
        new String[] {"Math", "Business", "Computer Science", "English",
                      "Phys Ed", "Science"});

    gradeOptions =
        new DefaultComboBoxModel<Integer>(new Integer[] {9, 10, 11, 12});

    countryOptions = new DefaultComboBoxModel<String>(new String[] {
        "India", "China", "Russia", "United Kingdom", "France", "Germany",
        "South Africa", "Argentina", "Brazil", "United States of America"});

    // these are empty because deletion options are intially empty and set on
    // the go
    defaultDeletionOptions = new DefaultComboBoxModel<String>();
    defaultEditOptions = new DefaultComboBoxModel<String>();
  }

  /**
   * This method is a GUI utility method to temporarily change a given label
   * to have the new text, and then change it back. Useful for displaying
   * errors. Overloaded below for a JButton instead of a label.
   *
   * @param label - the label to temporarily change
   * @param newText - the text to change the label to
   */
  public static void tempChangeLabel(final JLabel label, final String newText) {
    final String oldText =
        label.getText();    // get the current text of the label, which we will
                            // need to revert the label to later
    label.setText(newText); // set the label's text to the new text supplied

    // using a SwingWorker object, asynchronously wait for 1 second and then
    // reset the text of the button the old text
    final SwingWorker<Object, Object> worker =
        new SwingWorker<Object, Object>() {
          /**
           * This method sleeps for 1000 milliseconds in a separate thread
           *
           * @return - this method returns a generic Object
           * @throws - this method throws an exception if it fails
           */
          @Override
          protected Object doInBackground() throws Exception {
            Thread.sleep(1000);
            return null;
          }

          /**
           * This method will automatically fire when the above background
           * task is done. It will set the label back to the old text.
           */
          @Override
          protected void done() {
            label.setText(oldText);
            super.done();
          }
        };

    worker.execute(); // this method call executes the SwingWorker and the
                      // declared methods
  }

  /**
   * This method is a GUI utility method to temporarily change a given label
   * to have the new text, and then change it back. Useful for displaying
   * errors. Overloaded above for a JLabel instead of a button. See above
   * overload for more detailed documentation.
   *
   * @param button - the button to temporarily change
   * @param newText - the text to change the button to
   */
  public static void tempChangeLabel(final JButton button,
                                     final String newText) {
    final String oldText = button.getText();
    button.setText(newText);

    final SwingWorker<Object, Object> worker =
        new SwingWorker<Object, Object>() {
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

  /**
   * This method is a GUI utility method that will take an arbitrary class
   * and table update the table on the GUI according to the records stored of
   * that class.
   *
   * @param cls - the class which should be accessed to update the given table
   * @param table - the actual table to update
   */
  public void updateViewTable(final Class<?> cls, final JTable table) {
    // get the table model of the given table (needed to manipulate table data)
    final DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
    // remove all elements from the table (including the title row)
    tableModel.getDataVector().removeAllElements();

    if (cls == Student.class) { // if the given class is the Student class
      tableModel.addRow(new Object[] {
          "Name", "Grade"}); // add the title row for student to the table
      for (final Student student :
           Engine.getStudents()) { // for each of the students currently stored
        tableModel.addRow(new Object[] {
            student.getName(),
            student.getGrade()}); // add a row to the table which contains the
                                  // information for that particular student
      }
    } else if (cls ==
               Teacher.class) { // else if the given class is the Teacher class
      tableModel.addRow(new Object[] {
          "Name", "Subject 1",
          "Subject 2"}); // add the title row for teacher to the table
      for (final Teacher teacher :
           Engine.getTeachers()) { // for each of the teachers currently stored
        tableModel.addRow(new Object[] {
            teacher.getName(), teacher.getSubject1(),
            teacher
                .getSubject2()}); // add a row to the table which contains the
                                  // information for that particular teacher
      }
    } else if (cls ==
               InternationalStudent.class) { // else if the given class is the
                                             // InternationalStudent class
      tableModel.addRow(new Object[] {
          "Name", "Grade", "Country"}); // add the title row for international
                                        // student to the table
      for (final InternationalStudent internationalStudent :
           Engine.getInternationalStudents()) { // for each of the international
                                                // students currently stored
        tableModel.addRow(new Object[] {
            internationalStudent.getName(), internationalStudent.getGrade(),
            internationalStudent.getCountry()}); // add a row to the table which
                                                 // contains the information
        // for that particular international student
      }
    }
  }

  /**
   * This method is a GUI utility method that will take an arbitrary class
   * and comboBox update the comboBox on the GUI according to the records stored
   * of that class.
   *
   * @param cls - the class to access to update the comboBox
   * @param comboBox - the actual comboBox to update
   */
  private void updateComboBox(final Class<?> cls,
                              final JComboBox<String> comboBox) {
    // get the combo box model of the given combo box (needed to manipulate
    // combo box data)
    final DefaultComboBoxModel<String> comboBoxModel =
        (DefaultComboBoxModel<String>)comboBox.getModel();
    // remove all elements from the combo box (including the title row)
    comboBoxModel.removeAllElements();

    if (cls == Student.class) { // if the given class is the Student class
      for (final Student student :
           Engine.getStudents()) { // for each of the students currently stored
        comboBoxModel.addElement(
            student.getName()); // add the name of the student to the comboBox
      }
    } else if (cls ==
               Teacher.class) { // else if the given class is the Teacher class
      for (final Teacher teacher :
           Engine.getTeachers()) { // for each of the teachers currently stored
        comboBoxModel.addElement(
            teacher.getName()); // add the name of the teacher to the comboBox
      }
    } else if (cls ==
               InternationalStudent.class) { // else if the given class is the
      for (final InternationalStudent internationalStudent :
           Engine.getInternationalStudents()) { // for each of the international
                                                // students currently stored
        comboBoxModel.addElement(
            internationalStudent
                .getName()); // add the name of the international student to the
                             // comboBox
      }
    }
  }

  /**
   * This method draws the GUI itself (i.e. it initializes the components
   * above). It will essentially create various panels for each view and put
   * them all into a CardLayout (masterLayout variable above) so that it is
   * possible to easily switch between the panels
   */
  private void setupGUI() {
    frame = new JFrame();
    contentPane = frame.getContentPane();
    masterLayout = new CardLayout();

    frame.setResizable(false);
    frame.setBounds(100, 100, 450, 300);
    frame.setDefaultCloseOperation(
        JFrame.DO_NOTHING_ON_CLOSE); // overriding default close behaviour so
                                     // custom close methods can run
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

    comboBox_addTeacherSubject1 = new JComboBox<String>(subject1Options);
    comboBox_addTeacherSubject1.setBounds(88, 107, 107, 26);
    panel_addTeacher.add(comboBox_addTeacherSubject1);

    comboBox_addTeacherSubject2 = new JComboBox<String>(subject2Options);
    comboBox_addTeacherSubject2.setBounds(88, 171, 107, 26);
    panel_addTeacher.add(comboBox_addTeacherSubject2);

    panel_viewTeachers = new JPanel();
    panel_viewTeachers.setLayout(null);
    contentPane.add(panel_viewTeachers, "panel_viewTeachers");

    final DefaultTableModel viewTeacherModel = new DefaultTableModel(
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
    btn_viewTeachersCreate.setBounds(12, 232, 153, 27);
    panel_viewTeachers.add(btn_viewTeachersCreate);

    btn_viewTeachersDelete = new JButton("Delete Teacher");
    btn_viewTeachersDelete.setBounds(313, 232, 123, 27);
    panel_viewTeachers.add(btn_viewTeachersDelete);

    btn_viewTeachersGoHome = new JButton("Go Home");
    btn_viewTeachersGoHome.setBounds(323, 9, 105, 22);
    panel_viewTeachers.add(btn_viewTeachersGoHome);

    btn_viewTeachersEditSelection = new JButton("Edit Teacher");
    btn_viewTeachersEditSelection.setBounds(167, 232, 144, 27);
    panel_viewTeachers.add(btn_viewTeachersEditSelection);

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

    comboBox_editTeacherSubject1 = new JComboBox<String>(subject1Options);
    comboBox_editTeacherSubject1.setBounds(88, 107, 107, 26);
    panel_editTeacher.add(comboBox_editTeacherSubject1);

    comboBox_editTeacherSubject2 = new JComboBox<String>(subject2Options);
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

    final DefaultTableModel viewStudentsModel =
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
    btn_viewStudentsCreate.setBounds(10, 232, 154, 27);
    panel_viewStudents.add(btn_viewStudentsCreate);

    btn_viewStudentsDelete = new JButton("Delete Student");
    btn_viewStudentsDelete.setBounds(298, 232, 130, 27);
    panel_viewStudents.add(btn_viewStudentsDelete);

    btn_viewStudentsGoHome = new JButton("Go Home");
    btn_viewStudentsGoHome.setBounds(323, 9, 105, 22);
    panel_viewStudents.add(btn_viewStudentsGoHome);

    btn_viewStudentsEditSelection = new JButton("Edit Student");
    btn_viewStudentsEditSelection.setBounds(165, 232, 132, 27);
    panel_viewStudents.add(btn_viewStudentsEditSelection);

    panel_viewIntlStudents = new JPanel();
    panel_viewIntlStudents.setLayout(null);
    contentPane.add(panel_viewIntlStudents, "panel_viewIntlStudents");

    final DefaultTableModel viewIntlStudentsModel =
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
    btn_viewIntlStudentsCreate.setBounds(10, 232, 154, 27);
    panel_viewIntlStudents.add(btn_viewIntlStudentsCreate);

    btn_viewIntlStudentsDelete = new JButton("Delete Student");
    btn_viewIntlStudentsDelete.setBounds(298, 232, 130, 27);
    panel_viewIntlStudents.add(btn_viewIntlStudentsDelete);

    btn_viewIntlStudentsGoHome = new JButton("Go Home");
    btn_viewIntlStudentsGoHome.setBounds(323, 9, 105, 22);
    panel_viewIntlStudents.add(btn_viewIntlStudentsGoHome);

    btn_viewIntlStudentsEditSelection = new JButton("Edit Student");
    btn_viewIntlStudentsEditSelection.setBounds(165, 232, 132, 27);
    panel_viewIntlStudents.add(btn_viewIntlStudentsEditSelection);

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

    btn_homeQuit = new JButton("Quit");
    btn_homeQuit.setBounds(159, 217, 125, 27);
    panel_home.add(btn_homeQuit);

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

    panel_editStudentSelection = new JPanel();
    panel_editStudentSelection.setLayout(null);
    frame.getContentPane().add(panel_editStudentSelection,
                               "panel_editStudentSelection");

    btn_editStudentSelectionCancel = new JButton("Cancel");
    btn_editStudentSelectionCancel.setBounds(108, 231, 105, 27);
    panel_editStudentSelection.add(btn_editStudentSelectionCancel);

    btn_editStudentSelectionEdit = new JButton("Edit");
    btn_editStudentSelectionEdit.setBounds(225, 231, 105, 27);
    panel_editStudentSelection.add(btn_editStudentSelectionEdit);

    comboBox_editStudentSelection = new JComboBox<String>(defaultEditOptions);
    comboBox_editStudentSelection.setBounds(146, 109, 133, 26);
    panel_editStudentSelection.add(comboBox_editStudentSelection);

    lbl_editStudentSelection = new JLabel("Choose a student to edit:");
    lbl_editStudentSelection.setBounds(126, 80, 171, 17);
    panel_editStudentSelection.add(lbl_editStudentSelection);

    panel_editTeacherSelection = new JPanel();
    panel_editTeacherSelection.setLayout(null);
    frame.getContentPane().add(panel_editTeacherSelection,
                               "panel_editTeacherSelection");

    btn_editTeacherSelectionCancel = new JButton("Cancel");
    btn_editTeacherSelectionCancel.setBounds(108, 231, 105, 27);
    panel_editTeacherSelection.add(btn_editTeacherSelectionCancel);

    btn_editTeacherSelectionEdit = new JButton("Edit");
    btn_editTeacherSelectionEdit.setBounds(225, 231, 105, 27);
    panel_editTeacherSelection.add(btn_editTeacherSelectionEdit);

    comboBox_editTeacherSelection = new JComboBox<String>(defaultEditOptions);
    comboBox_editTeacherSelection.setBounds(146, 109, 133, 26);
    panel_editTeacherSelection.add(comboBox_editTeacherSelection);

    lbl_editTeacherSelection = new JLabel("Choose a teacher to edit:");
    lbl_editTeacherSelection.setBounds(126, 80, 171, 17);
    panel_editTeacherSelection.add(lbl_editTeacherSelection);

    panel_editIntlStudentSelection = new JPanel();
    panel_editIntlStudentSelection.setLayout(null);
    frame.getContentPane().add(panel_editIntlStudentSelection,
                               "panel_editIntlStudentSelection");

    btn_editIntlStudentSelectionCancel = new JButton("Cancel");
    btn_editIntlStudentSelectionCancel.setBounds(108, 231, 105, 27);
    panel_editIntlStudentSelection.add(btn_editIntlStudentSelectionCancel);

    btn_editIntlStudentSelectionEdit = new JButton("Edit");
    btn_editIntlStudentSelectionEdit.setBounds(225, 231, 105, 27);
    panel_editIntlStudentSelection.add(btn_editIntlStudentSelectionEdit);

    comboBox_editIntlStudentSelection =
        new JComboBox<String>(defaultEditOptions);
    comboBox_editIntlStudentSelection.setBounds(146, 109, 133, 26);
    panel_editIntlStudentSelection.add(comboBox_editIntlStudentSelection);

    lbl_editIntlStudentSelectionCancel =
        new JLabel("Choose an international student to edit:");
    lbl_editIntlStudentSelectionCancel.setBounds(92, 77, 252, 17);
    panel_editIntlStudentSelection.add(lbl_editIntlStudentSelectionCancel);
  }

  /**
   * This method attaches the appropriate listeners to all components defined
   * above
   */
  private void attachListeners() {
    /*************************************************************************
     * GENERAL LISTENERS
     *************************************************************************/

    // listeners for the home screen

    // add an action listener to the student button on the home page to go to
    // the view students panel
    btn_homeStudent.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewStudents");
      }
    });

    // add an action listener to the teacher button on the home page to go to
    // the view teachers panel
    btn_homeTeacher.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewTeachers");
      }
    });

    // add an action listener to the international student button on the home
    // page to go to the view international students panel
    btn_homeIntlStudent.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewIntlStudents");
      }
    });

    // add an action listener to do actions when the quit button is clicked
    btn_homeQuit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        Engine.saveDataToFile();
        frame.dispose();
        System.exit(0);
      }
    });

    // listener for window events

    // add an action listener to do actions just before the window closes
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(final WindowEvent e) {
        Engine.saveDataToFile();
        frame.dispose();
        System.exit(0);
      }
    });

    /*************************************************************************
     * STUDENT LISTENERS
     *************************************************************************/

    // listners for the view students screen

    // add an action listener to the Go Home button on the view students
    // panel which will go back to the home screen on click
    btn_viewStudentsGoHome.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_home");
      }
    });

    // add an action listener to the Create button on the view students
    // panel which will go to the create student screen on click
    btn_viewStudentsCreate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_addStudent");
      }
    });

    // add an action listener to the Edit button on the view students
    // panel which will go to the edit student selection screen on click
    btn_viewStudentsEditSelection.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        // if there are no students
        if (Engine.getStudents().size() == 0) {
          tempChangeLabel(btn_viewStudentsEditSelection,
                          "No students yet!"); // display an error message
        } else { // if there are students to display
          // update the student selection combobox and switch to the edit
          // student selection screen
          updateComboBox(Student.class, comboBox_editStudentSelection);
          masterLayout.show(contentPane, "panel_editStudentSelection");
        }
      }
    });

    // add an action listener to the Delete button on the view students
    // panel which will go to the delete student screen on click
    btn_viewStudentsDelete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        // if there are no students
        if (Engine.getStudents().size() == 0) {
          tempChangeLabel(btn_viewStudentsDelete,
                          "No students yet!"); // display an error message
        } else { // if there are students to display
          // update the student selection combobox and switch to the delete
          // student selection screen
          updateComboBox(Student.class, comboBox_deleteStudent);
          masterLayout.show(contentPane, "panel_deleteStudent");
        }
      }
    });

    // listeners for the add student screen

    // add an action listener to the Cancel button on the add student
    // panel which will go back to the view student screen on click
    btn_addStudentCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewStudents");
      }
    });

    // add an action listener to the Cancel button on the add student
    // panel which will save a new student with the current entered information
    btn_addStudentSave.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        // if the text field for the name on the add student screen is empty
        // when the save button is clicked, display an error message and prevent
        // saving
        if (textField_addStudentName.getText().equals("")) {
          tempChangeLabel(lbl_addStudentTitle, "Please enter a name!");
        } else { // if there is a name (and all info is valid), add a new
                 // student with the given information
          Engine.getStudents().add(
              new Student(textField_addStudentName.getText(),
                          (int)comboBox_addStudentGrade.getSelectedItem()));
          // update the students table for with the new students and go back to
          // the students view panel
          updateViewTable(Student.class, table_viewStudents);
          masterLayout.show(contentPane, "panel_viewStudents");
        }
      }
    });

    // listeners for the student edit selection screen

    // add an action listener to the Edit button on the edit student selection
    // panel which will go to the edit panel with the info filled in for the
    // selected student
    btn_editStudentSelectionEdit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        // get the index for the currently selected student (the student to
        // edit)
        currentlyEditingStudent =
            comboBox_editStudentSelection.getSelectedIndex();
        // get the student from the current selection list based on the index
        // and store it in a global variable for later use
        final Student student =
            Engine.getStudents().get(currentlyEditingStudent);
        // fill in the edit fields with the existent information
        textField_editStudentName.setText(student.getName());
        comboBox_editStudentGrade.setSelectedItem((Object)student.getGrade());
        // go to the edit student panel with the newly filled in information
        masterLayout.show(contentPane, "panel_editStudent");
      }
    });

    // add an action listener to the Cancel button on the edit student selection
    // panel which will go back to the view students panel
    btn_editStudentSelectionCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewStudents");
      }
    });

    // listeners for the edit student screen

    // add an action listener to the Cancel button on the edit student
    // panel which will go back to the view students panel
    btn_editStudentCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewStudents");
      }
    });

    // add an action listener to the Save button on the edit student
    // panel which edit the current student with the given information and
    // return to the view students screen
    btn_editStudentSave.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (textField_editStudentName.getText().equals(
                "")) { // if there is no name in the name field
          tempChangeLabel(
              lbl_editStudentTitle,
              "Please enter a name!"); // display an error message to let the
                                       // user know they must enter a name
        } else {                       // if there is a name supplied
          final Student currentStudent = Engine.getStudents().get(
              currentlyEditingStudent); // get the current student using the
                                        // currentlyEditingStudent variable set
                                        // in the edit student selection screen
          currentStudent.setName(
              textField_editStudentName
                  .getText()); // change the name of the current student to the
                               // new name
          currentStudent.setGrade(
              (int)comboBox_editStudentGrade
                  .getSelectedItem()); // change the grade of the current
                                       // student to the new grade
          updateViewTable(Student.class,
                          table_viewStudents); // update the students view table
                                               // with the new information
          masterLayout.show(
              contentPane,
              "panel_viewStudents"); // go back to the view students panel
        }
      }
    });

    // listeners for the delete student screen

    // add an action listener to the Cancel button on the delete student
    // panel which will go back to the view students panel
    btn_deleteStudentCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewStudents");
      }
    });

    // add an action listener to the Delete button on the delete student
    // panel which delete the selected student
    btn_deleteStudentDelete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        final int index =
            comboBox_deleteStudent
                .getSelectedIndex(); // get the index of the selected student
        Engine.getStudents().remove(Engine.getStudents().get(
            index)); // remove the selected student from the students array
        // update the students table and go back to the view students panel
        updateViewTable(Student.class, table_viewStudents);
        masterLayout.show(contentPane, "panel_viewStudents");
      }
    });

    /*************************************************************************
     * TEACHER LISTENERS - these listeners are NOT COMMENTED because they work
     * the exact same way as the student listeners, with minor change to
     * variables and what is being stored. Refer to student listeners for
     * documentation on how these methods work.
     *************************************************************************/

    // listners for the view teachers screen

    btn_viewTeachersGoHome.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_home");
      }
    });

    btn_viewTeachersCreate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_addTeacher");
      }
    });

    btn_viewTeachersEditSelection.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {

        if (Engine.getTeachers().size() == 0) {
          tempChangeLabel(btn_viewTeachersEditSelection, "No teachers yet!");
        } else {

          updateComboBox(Teacher.class, comboBox_editTeacherSelection);
          masterLayout.show(contentPane, "panel_editTeacherSelection");
        }
      }
    });

    btn_viewTeachersDelete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {

        if (Engine.getTeachers().size() == 0) {
          tempChangeLabel(btn_viewTeachersDelete, "No teachers yet!");
        } else {

          updateComboBox(Teacher.class, comboBox_deleteTeacher);
          masterLayout.show(contentPane, "panel_deleteTeacher");
        }
      }
    });

    // listeners for the add teacher screen

    btn_addTeacherCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewTeachers");
      }
    });

    btn_addTeacherSave.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {

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

    // listeners for the teacher edit selection screen

    btn_editTeacherSelectionEdit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {

        currentlyEditingTeacher =
            comboBox_editTeacherSelection.getSelectedIndex();
        final Teacher teacher =
            Engine.getTeachers().get(currentlyEditingTeacher);

        textField_editTeacherName.setText(teacher.getName());
        comboBox_editTeacherSubject1.setSelectedItem(
            (Object)teacher.getSubject1());
        comboBox_editTeacherSubject1.setSelectedItem(
            (Object)teacher.getSubject2());

        masterLayout.show(contentPane, "panel_editTeacher");
      }
    });

    btn_editTeacherSelectionCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewTeachers");
      }
    });

    // listeners for the edit teacher screen

    btn_editTeacherCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewTeachers");
      }
    });

    btn_editTeacherSave.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (textField_editTeacherName.getText().equals("")) {
          tempChangeLabel(lbl_editTeacherTitle, "Please enter a name!");

        } else {
          final Teacher currentTeacher =
              Engine.getTeachers().get(currentlyEditingTeacher);

          currentTeacher.setName(textField_editTeacherName.getText());
          currentTeacher.setSubject1(
              (String)comboBox_editTeacherSubject1.getSelectedItem());

          currentTeacher.setSubject2(
              (String)comboBox_editTeacherSubject2.getSelectedItem());

          updateViewTable(Teacher.class, table_viewTeachers);

          masterLayout.show(contentPane, "panel_viewTeachers");
        }
      }
    });

    // listeners for the delete teacher screen

    btn_deleteTeacherCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewTeachers");
      }
    });

    btn_deleteTeacherDelete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        final int index = comboBox_deleteTeacher.getSelectedIndex();
        Engine.getTeachers().remove(Engine.getTeachers().get(index));

        updateViewTable(Teacher.class, table_viewTeachers);
        masterLayout.show(contentPane, "panel_viewTeachers");
      }
    });

    /*************************************************************************
     * INTERNATIONAL STUDENT LISTENERS - these listeners are NOT COMMENTED
     * because they work the exact same way as the student listeners, with minor
     * change to variables and what is being stored. Refer to student listeners
     * for documentation on how these methods work.
     *************************************************************************/

    // listeners for the view international students screen

    btn_viewIntlStudentsGoHome.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_home");
      }
    });

    btn_viewIntlStudentsCreate.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_addIntlStudent");
      }
    });

    btn_viewIntlStudentsEditSelection.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        // if there are no international students
        if (Engine.getInternationalStudents().size() == 0) {
          tempChangeLabel(btn_viewIntlStudentsEditSelection,
                          "No students yet!");
        } else {
          updateComboBox(InternationalStudent.class,
                         comboBox_editIntlStudentSelection);
          masterLayout.show(contentPane, "panel_editIntlStudentSelection");
        }
      }
    });

    btn_viewIntlStudentsDelete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        // if there are no international students
        if (Engine.getInternationalStudents().size() == 0) {
          tempChangeLabel(btn_viewIntlStudentsDelete, "No students yet!");
        } else {
          updateComboBox(InternationalStudent.class,
                         comboBox_deleteIntlStudent);
          masterLayout.show(contentPane, "panel_deleteIntlStudent");
        }
      }
    });

    // listeners for the add international students screen

    btn_addIntlStudentCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewIntlStudents");
      }
    });

    btn_addIntlStudentSave.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
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

    // listeners for the international student edit selection screen

    btn_editIntlStudentSelectionEdit.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        currentlyEditingInternationalStudent =
            comboBox_editIntlStudentSelection.getSelectedIndex();
        final InternationalStudent internationalStudent =
            Engine.getInternationalStudents().get(
                currentlyEditingInternationalStudent);
        textField_editIntlStudentName.setText(internationalStudent.getName());
        comboBox_editIntlStudentGrade.setSelectedItem(
            (Object)internationalStudent.getGrade());
        comboBox_addIntlStudentCountry.setSelectedItem(
            (Object)internationalStudent.getCountry());
        masterLayout.show(contentPane, "panel_editIntlStudent");
      }
    });

    btn_editIntlStudentSelectionCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewInternationalStudents");
      }
    });

    // listeners for the edit international student screen

    btn_editIntlStudentCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewInternationalStudents");
      }
    });

    btn_editIntlStudentSave.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        if (textField_editIntlStudentName.getText().equals("")) {
          tempChangeLabel(lbl_editIntlStudentTitle, "Please enter a name!");
        } else {
          final InternationalStudent currentInternationalStudent =
              Engine.getInternationalStudents().get(
                  currentlyEditingInternationalStudent);
          currentInternationalStudent.setName(
              textField_editIntlStudentName.getText());
          currentInternationalStudent.setGrade(
              (int)comboBox_addIntlStudentGrade.getSelectedItem());
          currentInternationalStudent.setCountry(
              (String)comboBox_editIntlStudentCountry.getSelectedItem());
          updateViewTable(InternationalStudent.class, table_viewIntlStudents);
          masterLayout.show(contentPane, "panel_viewIntlStudents");
        }
      }
    });

    // listeners for the delete international students screen

    btn_deleteIntlStudentCancel.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        masterLayout.show(contentPane, "panel_viewIntlStudents");
      }
    });

    btn_deleteIntlStudentDelete.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(final ActionEvent e) {
        final int index = comboBox_deleteIntlStudent.getSelectedIndex();
        Engine.getInternationalStudents().remove(
            Engine.getInternationalStudents().get(index));
        updateViewTable(InternationalStudent.class, table_viewIntlStudents);
        masterLayout.show(contentPane, "panel_viewIntlStudents");
      }
    });
  }

  // getters and setters

  public JTable getTableViewStudents() { return table_viewStudents; }

  public JTable getTableViewTeachers() { return table_viewTeachers; }

  public JTable getTableViewIntlStudents() { return table_viewIntlStudents; }
}
