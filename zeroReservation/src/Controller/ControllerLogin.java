/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Admin;
import Model.Customer;
import Model.*;
import Model.Application;
import View.GuestDashboard;
import View.Login;
import View.RegistrationCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Zero-Inside
 */
// implement Action Listener
public class ControllerLogin implements ActionListener {

    private Application model = new Application();
    private Login view;

    public ControllerLogin() {
        view = new Login();
        view.setVisible(true);
        view.addActionListener((ActionListener) this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object pilih = e.getSource();

        if (pilih.equals(view.getBtnLogin())) {
            // cek blank username&password or not
            System.out.println(view.getTfPassword().getText());
            System.out.println(view.getTfUsername().getText());
            if (view.getTfPassword().getText().equals("") && view.getTfUsername().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan isi username dan password!");
            } else {
 
                String username = view.getTfUsername().getText();
                String password = view.getTfPassword().getText();
                if (model.cekLoginAdmin(username, password) != null) {
                    //invoke controller admin dashboard
                    Admin admin = model.cekLoginAdmin(username, password);
                    
                    new ControllerAdmin(admin);
                    view.dispose();
                } else if (model.cekLoginCustomer(view.getTfUsername().getText(), view.getTfPassword().getText()) != null) {
                    // invoke controller customer dashboard
                    Customer customer = model.cekLoginCustomer(username, password);
                    

                } else if (model.cekLoginMaskapai(view.getTfUsername().getText(), view.getTfPassword().getText()) != null) {
                    // invoke controller maskapai dashboard
                    Maskapai maskapai = model.cekLoginMaskapai(username, password);
                
                    new ControllerMaskapai(maskapai);
                    view.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username atau password salah");

                }
            }

        } else if (pilih.equals(view.getBtnCancel())) {
            new ControllerGuest();
            view.dispose();
        }

    }

}
