/******************************************************************************
Program: App Class (Character Creation Interface)

Description: This is the driver code for this character creation interface.
This class' main method will start the entire program.

Author: Pranav Rao

Date: March 1, 2022

LOCATIONS OF FULFILLED REQUIREMENTS:
- Add/Edit/View/Delete GUI and Listeners: app/GUI.java
- Text File methods: app/Engine.java:77 (save method) and app/Engine.java:162
- Inheritance:
  - Parent Class: models/Person.java
  - Child Classes: models/Student.java, models/Teacher.java
  - Grandchild Class: models/InternationalStudent.java (inherits from Student)
- Overload: Contructors in all models/*.java files. Example:
models/Student.java:25 and models/Student.java:35
- Override: Description methods for all models, and all action listeners.
Example: models/Student.java:47
- Array of Records: ArrayList used instead, app/Engine.java:33
- Creation of Objects: Used for all models. Example: app/GUI.java:1015
- Usage of Objects and Attributes: Getters and setters used everywhere, such as
in the models' edit methods. Example: Getter at app/GUI.java:1042 and setter
at app/GUI.java:1086
*******************************************************************************/

package app; // declare this class as part of the app package

import java.awt.EventQueue;

public class App {

  /**
   * This method is the driver code for the entire program. It creates a new
   * GUI and runs the engine.
   *
   * @param args - command line arguments for this program
   */
  public static void main(final String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Engine.run(new GUI());
        } catch (final Exception e) {
          e.printStackTrace();
        }
      }
    });
  }
}
