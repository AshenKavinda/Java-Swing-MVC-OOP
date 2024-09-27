package View.LogIn;

import Controller.LogInController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.sql.SQLException;

public class FormLogIn {
    private final FormLogInDesigner formLogInDesigner;

    public FormLogIn() throws SQLException {
        formLogInDesigner = new FormLogInDesigner();
        new LogInController(this);
    }

    public FormLogInDesigner getFormLogInDesigner() {
        return formLogInDesigner;
    }

    public boolean isValid() {
        boolean isValid = true;
        if (formLogInDesigner.txtUsername.getText().isEmpty()) {
            formLogInDesigner.txtUsername.setBorder(new LineBorder(Color.red));
            isValid = false;
        }
        else {
            formLogInDesigner.txtUsername.setBorder(new LineBorder(Color.black));
        }
        if (new String(formLogInDesigner.txtPassword.getPassword()).isEmpty()) {
            formLogInDesigner.txtPassword.setBorder(new LineBorder(Color.red));
            isValid = false;
        }
        else {
            formLogInDesigner.txtPassword.setBorder(new LineBorder(Color.black));
        }
        return isValid;
    }

    public void clear() {
        formLogInDesigner.getTxtUsername().setText("");
        formLogInDesigner.getTxtPassword().setText("");
    }

    public void messageBox(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
