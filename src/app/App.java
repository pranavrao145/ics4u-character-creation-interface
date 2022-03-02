/******************************************************************************
Program: App Class (Character Creation Interface)

Description: This is the driver code for this character creation interface.
This class' main method will start the entire program.

Author: Pranav Rao

Date: March 1, 2022
*******************************************************************************/

package app; // declare this class as part of the app package

import java.awt.EventQueue;

public class App {

  /**
   * This function is the driver code for the entire program. It creates a new
   * GUI and runs the engine.
   *
   * @param args
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
