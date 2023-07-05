package com.oasisdrinks.app.models;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Rommel Rodriguez Perez<0812058@utp.edu.pe>
 */
public class Usuario extends Persona {
    private String login = null;
    private String password = null;

    public Usuario() {
    }

    public Usuario(int id) {
        super(id);
    }

    public Usuario(String nombres, String apellidos) {
        super(nombres, apellidos);
    }

    public Usuario(String nombres, String apellidos, String email) {
        super(nombres, apellidos, email);
    }

    public String hashPassword(String password) {
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        return hashedPassword;
    }

    public boolean validateLogin(String enteredPassword) {
        // Compare entered password with stored password hash
        return BCrypt.checkpw(enteredPassword, this.password);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPassword(password);
    }

    
}
