package Controller;

import Model.User.User;
import Model.User.UserDAO;
import View.FormCashier.FormCashier;
import View.FormSalesReport.FormSalesReport;
import View.FormStock.FormStock;
import View.LogIn.FormLogIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LogInController implements ActionListener {
    private FormLogIn view;
    private UserDAO model;

    public LogInController(FormLogIn view) throws SQLException {
        this.view = view;
        this.model = new UserDAO();

        this.view.getFormLogInDesigner().getBtnSubmit().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("submit")) {
            if (view.isValid()) {
                String username = view.getFormLogInDesigner().getTxtUsername().getText();
                char[] password = view.getFormLogInDesigner().getTxtPassword().getPassword();
                User user = new User();
                user.setNic(username);
                user.setPassword(new String(password));
                try {
                    user = model.isVerified(user);
                    if (user != null) {
                        switch (user.getType()) {
                            case "Cashier":
                                view.getFormLogInDesigner().dispose();
                                new FormCashier(user.getuID());
                                break;
                            case "TopBord":
                                view.getFormLogInDesigner().dispose();
                                new FormSalesReport();
                                break;
                            case "Inventory":
                                view.getFormLogInDesigner().dispose();
                                new FormStock();
                                break;
                        }
                    }
                    else {
                        view.messageBox("Username or Password is incorrect!");
                        view.clear();
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
