/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Model.Application;
import Model.Customer;
import View.RegistrationCustomer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
/**
 *
 * @author Zero-Inside
 */
public class ControllerRegisCustomer implements ActionListener {
    private Application model = new Application();
    private RegistrationCustomer view;
    private Customer customer;
    
     public ControllerRegisCustomer() {
        this.model = model;
        view = new RegistrationCustomer();
        view.setVisible(true);
        view.addActionListener(this);       
    }
    
    public ControllerRegisCustomer(Application model) {
        this.model = model;
        view = new RegistrationCustomer();
        view.setVisible(true);
        view.addActionListener(this);       
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if(obj.equals(view.getBtnSave())){
            //ring password, String nama, String noktp, String alamat, int umur, String jenisKelamin, String noTelepon
            String jenisKelamin;
            if (view.getRbtnLaki().isSelected()) {
                jenisKelamin = "L";
            } else {
                jenisKelamin = "P";
            }
            
            int umur = parseInt(view.getTfUmur().getText());
            customer = new Customer(view.getTfNoKTP().getText(),view.getTfUsername().getText(),view.getTfPassword().getText(),view.getTfNama().getText(),  view.getTfAlamat().getText() , umur , jenisKelamin , view.getTfNoTelepon().getText());
            model.addCustomer(customer);
            //customer.insertCustomer(customer);
        } else if (obj.equals(view.getBtnCancel())) {
            new ControllerGuest(); //invoke controller to back
            view.dispose();
        }
    }
    
    
}
