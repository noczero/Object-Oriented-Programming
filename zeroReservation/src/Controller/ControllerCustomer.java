/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Customer;
import Model.*;
import View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Long.parseLong;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Zero-Inside
 */
public class ControllerCustomer implements ActionListener, MouseListener {

    private Application model = new Application();
    private CustomerDashboard view = null;
    private ArrayList<Tiket> listTiket = new ArrayList();
    private Customer customer;

    ControllerCustomer(Customer customer) {
        view = new CustomerDashboard();
        view.setVisible(true);
        view.addActionListener(this);
        view.addMouseListener(this);
        this.customer = customer;
        showTiketTable();
        setAllAtribute();
    }

    //show tiket table
    public void showTiketTable() {
        this.listTiket = model.getTiket(customer.getNoktp());
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblTiket().getModel();
        for (Tiket pecah : listTiket) {
            Object[] row = {
                pecah.getIdPesan(),
                pecah.getKodePesawat(),
                pecah.getAsal(),
                pecah.getTujuan(),
                pecah.getJadwalPenerbangan(),
                pecah.getStatus()
            };
            tmodel.addRow(row);
        }
    }

    //Refresh table tiket
    public void refreshTableTiket() {
        listTiket.clear(); //clear the array
        DefaultTableModel modelCustomer = (DefaultTableModel) view.getTblTiket().getModel(); //get table
        modelCustomer.setRowCount(0); //set to zero
        showTiketTable(); //display again from DB
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object pilih = e.getSource();
        
        //isiSaldoDulu
        if (pilih.equals(view.getBtnIsiSaldo())) {
            
            Long mySaldo = model.getSaldo(customer.getNoktp());
            
            model.updateSaldo(customer.getNoktp(), mySaldo + parseLong(view.getTfInputSaldo().getText()));
            
            
            view.getLblSaldoSaya().setText(mySaldo.toString());
        }
    }

    String idPesan;

    @Override
    public void mouseClicked(MouseEvent e) {
        Object pilih = e.getSource();
        if (pilih.equals(view.getTblTiket())) {
            //get index of selected row on table
            int i = view.getTblTiket().getSelectedRow();
            TableModel tModel = view.getTblTiket().getModel();

            //set the value of every text field in view
            idPesan = tModel.getValueAt(i, 0).toString();
            setAllAtribute();
        }
    }

    //search idx in tiket list
    public Integer searchIdPesan(String id) {
        int idx = 0;
        for (Tiket pecah : listTiket) {
            if (pecah.getIdPesan().equals(id)) {
                return idx;
            } else {
                idx++;
            }
        }
        return 0;
    }

    public void setAllAtribute() {
        int idx = searchIdPesan(idPesan);
        System.out.println(idx);
        view.getLbl1KodeBooking().setText(listTiket.get(idx).getKodeBooking());
        view.getLbl2Nama().setText(listTiket.get(idx).getNamaCustomer());
        view.getLbl3Rute().setText(listTiket.get(idx).getRutePenerbangan());
        view.getLbl4Jadwal().setText(listTiket.get(idx).getJadwalPenerbangan().toString());
        view.getLbl5WaktuBerangkat().setText(listTiket.get(idx).getWaktuBerangkat());
        view.getLbl6WaktuTiba().setText(listTiket.get(idx).getWaktuTiba());
        view.getLbl7KodePesawat().setText(listTiket.get(idx).getKodePesawat());
        view.getLbl8JenisPesawat().setText(listTiket.get(idx).getJenisPesawat());
        view.getLbl9Seat().setText(listTiket.get(idx).getSeat());
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
