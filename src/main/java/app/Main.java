/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class Main {
    public static void main(String[] args) {
        // Create instances of the model, view, and controller
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        // Set up any necessary initial configuration

        // Start the application
        view.setVisible(true);
    }
}