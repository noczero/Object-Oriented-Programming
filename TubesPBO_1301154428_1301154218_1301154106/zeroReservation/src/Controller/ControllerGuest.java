/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Application;
import View.GuestDashboard;
import View.Login;
import View.RegistrationCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Zero-Inside
 */
public class ControllerGuest implements ActionListener {
    // instance Model  
    private Application model = new Application();
    // Declare View
    private GuestDashboard view;
    
    //Constructor 

    public ControllerGuest() {
        view = new GuestDashboard();
        view.setVisible(true);
        view.addActionListener(this);
        
    }
  
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object pilih = e.getSource();
        
        if (pilih.equals(view.getjButton1_Register())) {
            // Register Button Handler
            new ControllerRegisCustomer(); // invoke Controller Registrasi
            view.dispose(); // exit this view.
        } if (pilih.equals(view.getjButton2_Login())) {
            // Register Button Handler
            new ControllerLogin(); // invoke Controller Login
            view.dispose(); // exit this view.
        } 
    }
}
