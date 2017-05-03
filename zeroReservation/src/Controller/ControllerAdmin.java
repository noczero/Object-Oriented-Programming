/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Zero-Inside
 */
public class ControllerAdmin implements ActionListener, MouseListener {

    private Application model = new Application(); //Aggregation
    private AdminDashboard view;

    //Customer List
    ArrayList<Customer> customerList = new ArrayList();

    public ControllerAdmin(Admin admin) {
        //this.model = model;
        view = new AdminDashboard();
        view.setVisible(true);
        view.addActionListener((ActionListener) this);
        view.addMouseListener((MouseListener) this); //get event on table
        // get data from admin
        view.getLblAdmin().setText(admin.getUsername());

        // show table
        showCustomerTable();

    }

    // get data from model and display to tblCustomer
    public void showCustomerTable() {
        this.customerList = model.getCustomer();
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblCustomer().getModel();
        for (Customer pecah : customerList) {
            Object[] row = {pecah.getNoktp(),
                pecah.getUsername(),
                pecah.getPassword(),
                pecah.getNama(),
                pecah.getAlamat(),
                pecah.getUmur(),
                pecah.getJenisKelamin(),
                pecah.getNoTelepon(),
                pecah.getSaldo()
            };
            tmodel.addRow(row);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object pilih = e.getSource();

        if (pilih.equals(view.getBtnUpdateCustomer())) {
            // update button
            // get the no.ktp
            if (view.getTfNoKTP().getText().trim() == "") {
                JOptionPane.showMessageDialog(null, "Silahkan pilih customer terlebih dahulu pada tabel customer");
            } else {
                Customer customer = new Customer(
                        view.getTfNoKTP().getText(),
                        view.getTfUsername().getText(),
                        view.getTfPassword().getText(),
                        view.getTfNamaCustomer().getText(),
                        view.getTfAlamat().getText(),
                        parseInt(view.getTfUmur().getText()),
                        view.getTfJenisKelamin().getText(),
                        view.getTfNoTelepon().getText(),
                        parseLong(view.getTfSaldo().getText())
                );

                model.updateCustumer(customer);
                refreshTable();
            }

        }
        if (pilih.equals(view.getBtnDeleteCustomer())) {
            // delete button

            model.deleteCustomer(view.getTfNoKTP().getText());
            refreshTable();

        }

    }

    public void refreshTable() {
        customerList.clear(); //clear the array
        DefaultTableModel modelCustomer = (DefaultTableModel) view.getTblCustomer().getModel(); //get table
        modelCustomer.setRowCount(0); //set to zero
        showCustomerTable(); //display again from DB
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int i = view.getTblCustomer().getSelectedRow();
        TableModel modelCustomer = view.getTblCustomer().getModel();

        //set the value of every text field in view
        view.getTfNoKTP().setText(modelCustomer.getValueAt(i, 0).toString());
        view.getTfUsername().setText(modelCustomer.getValueAt(i, 1).toString());
        view.getTfPassword().setText(modelCustomer.getValueAt(i, 2).toString());
        view.getTfNamaCustomer().setText(modelCustomer.getValueAt(i, 3).toString());
        view.getTfAlamat().setText(modelCustomer.getValueAt(i, 4).toString());
        view.getTfUmur().setText(modelCustomer.getValueAt(i, 5).toString());
        view.getTfJenisKelamin().setText(modelCustomer.getValueAt(i, 6).toString());
        view.getTfNoTelepon().setText(modelCustomer.getValueAt(i, 7).toString());
        view.getTfSaldo().setText(modelCustomer.getValueAt(i, 8).toString());

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
