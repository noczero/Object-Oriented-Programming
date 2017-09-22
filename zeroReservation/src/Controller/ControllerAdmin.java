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
    //Maskapai List
    ArrayList<Maskapai> maskapaiList = new ArrayList();
    //Konfirmasi Transaksi
    ArrayList<KonfirmasiTransaksi> transaksiList = new ArrayList();
    ArrayList<Bandara> bandaraList = new ArrayList();

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
        showMaskapaiTable();
        showTransaksiTable();
        showBandaraTable();
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

    // get maskapai data and display to tblMaskapai
    public void showMaskapaiTable() {
        this.maskapaiList = model.getMaskapai();
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblMaskapai().getModel();
        for (Maskapai pecah : maskapaiList) {
            Object[] row = {pecah.getIdMaskapai(),
                pecah.getUsername(),
                pecah.getPassword(),
                pecah.getNama(),
                pecah.getJumlahPesawat()
            };
            tmodel.addRow(row);
        }
    }

    // get konfirmasi transaksi data and display to tblTransaksi
    public void showTransaksiTable() {
        this.transaksiList = model.getKonfirmasiTransaksi();
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblKonfirmasiTransaksi().getModel();
        for (KonfirmasiTransaksi pecah : transaksiList) {
            Object[] row = {
                pecah.getIdPesan(),
                pecah.getNoKTP(),
                pecah.getNamaCustomer(),
                pecah.getNoSeat(),
                pecah.getStatus(),
                pecah.getKodeBooking()
            };
            tmodel.addRow(row);
        }
    }
    
    // get konfirmasi transaksi data and display to tblTransaksi
    public void showBandaraTable() {
        this.bandaraList = model.getBandara();
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblBandara().getModel();
        for (Bandara pecah : bandaraList) {
            Object[] row = {
                pecah.getIdBandara(),
                pecah.getNama(),
                pecah.getLatitude(),
                pecah.getLongitude(),
                pecah.getKota(),
                pecah.getNegara()
            };
            tmodel.addRow(row);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object pilih = e.getSource();

        if (pilih.equals(view.getBtnUpdateCustomer())) {
            // update button customer

            if (view.getTfNoKTP().getText().equals("")) {
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
                refreshTableCustomer();
            }

        } else if (pilih.equals(view.getBtnDeleteCustomer())) {
            // delete button customer
            if (view.getTfNoKTP().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih customer terlebih dahulu pada tabel customer");
            } else {
                model.deleteCustomer(view.getTfNoKTP().getText());
                refreshTableCustomer();
            }

        } else if (pilih.equals(view.getBtnInsertMaskapai())) {
            // insert button maskapai
            if (view.getTfKodeMaskapai().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih maskapai terlebih dahulu pada tabel maskapai");
            } else {
                Maskapai maskapai = new Maskapai(
                        view.getTfKodeMaskapai().getText(),
                        view.getTfMasUsername().getText(),
                        view.getTfMasPassword().getText(),
                        view.getTfMasNama().getText(),
                        parseInt(view.getTfJumPesawat().getText())
                );

                model.addMaskapai(maskapai);
                refreshTableMaskapai();
            }

        } else if (pilih.equals(view.getBtnUpdateMaskapai())) {
            // update button maskapai
            if (view.getTfKodeMaskapai().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih maskapai terlebih dahulu pada tabel maskapai");
            } else {
                Maskapai maskapai = new Maskapai(
                        view.getTfKodeMaskapai().getText(),
                        view.getTfMasUsername().getText(),
                        view.getTfMasPassword().getText(),
                        view.getTfMasNama().getText(),
                        parseInt(view.getTfJumPesawat().getText())
                );

                model.updateMaskapai(maskapai);
                refreshTableMaskapai();
            }
        } else if (pilih.equals(view.getBtnDeleteMaskapai())) {
            // delete button Maskapai
            // update button maskapai
            if (view.getTfKodeMaskapai().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih maskapai terlebih dahulu pada tabel maskapai");
            } else {
                model.deleteMaskapai(view.getTfKodeMaskapai().getText());
                refreshTableMaskapai();
            }
        } else if (pilih.equals(view.getBtnUpdateKonfirmasi())) {
            // update button konfirmasi
            if (view.getTfIdPesan().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih Transaksi terlebih dahulu pada tabel Transaksi");
            } else {
                KonfirmasiTransaksi tk = new KonfirmasiTransaksi(
                        parseInt(view.getTfIdPesan().getText()),
                        view.getTfTransNoKTP().getText(),
                        view.getTfTransNama().getText(),
                        view.getTfNoSeat().getText(),
                        view.getTfStatus().getText(),
                        view.getTfKodeBooking().getText()
                );

                model.updateKonfirmasiTransaksi(tk);
                refreshTableKonTransaksi();
            }

        } else if (pilih.equals(view.getBtnDeleteKonfirmasi())) {
            // delete button konfrimasi 
            if (view.getTfIdPesan().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih Transaksi terlebih dahulu pada tabel Transaksi");
            } else {
                model.deleteKonfirmasiTransaksi(parseInt(view.getTfIdPesan().getText()));
                refreshTableKonTransaksi();
            }

        } else if (pilih.equals(view.getBtnLogOut())) {
            // logout button
            new ControllerLogin();
            view.dispose();
        } else if (pilih.equals(view.getBtnInsertBandara())) {
            // delete button bandara
            if (view.getTfKodeBandara().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan isi data Bandara terlebih dahulu");
            } else {

                Bandara bandara = new Bandara();
                bandara.setIdBandara(view.getTfKodeBandara().getText());
                bandara.setKota(view.getTfKota().getText());
                bandara.setLatitude(view.getTfLatitude().getText());
                bandara.setLongitude(view.getTfLongitude().getText());
                bandara.setNama(view.getTfNamaBandara().getText());
                bandara.setNegara(view.getTfNegara().getText());
                
                model.insertBandara(bandara);
                refreshTableBandara();
            }
        } else if (pilih.equals(view.getBtnUpdateBandara())) {
            // delete button bandara
            if (view.getTfKodeBandara().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih data Bandara terlebih dahulu");
            } else {

                Bandara bandara = new Bandara();
                bandara.setIdBandara(view.getTfKodeBandara().getText());
                bandara.setKota(view.getTfKota().getText());
                bandara.setLatitude(view.getTfLatitude().getText());
                bandara.setLongitude(view.getTfLongitude().getText());
                bandara.setNama(view.getTfNamaBandara().getText());
                bandara.setNegara(view.getTfNegara().getText());
                
                model.updateBandara(bandara);
                refreshTableBandara();
            }
        } else if (pilih.equals(view.getBtnDeleteBandara())) {
            //e button bandara
            if (view.getTfKodeBandara().getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Silahkan pilih data Bandara terlebih dahulu");
            } else {
                model.deleteBandara(view.getTfKodeBandara().getText());
                refreshTableBandara();
            }
        }

    }

    // Refresh
    public void refreshTableCustomer() {
        customerList.clear(); //clear the array
        DefaultTableModel modelCustomer = (DefaultTableModel) view.getTblCustomer().getModel(); //get table
        modelCustomer.setRowCount(0); //set to zero
        showCustomerTable(); //display again from DB
    }

    public void refreshTableMaskapai() {
        maskapaiList.clear(); //clear the array
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblMaskapai().getModel(); //get table
        tmodel.setRowCount(0); //set to zero
        showMaskapaiTable(); //display again from DB
    }

    public void refreshTableKonTransaksi() {
        transaksiList.clear(); //clear the array
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblKonfirmasiTransaksi().getModel(); //get table
        tmodel.setRowCount(0); //set to zero
        showTransaksiTable(); //display again from DB
    }
    
    public void refreshTableBandara() {
        bandaraList.clear(); //clear the array
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblBandara().getModel(); //get table
        tmodel.setRowCount(0); //set to zero
        showBandaraTable(); //display again from DB
    }

    // Event Listener
    @Override
    public void mouseClicked(MouseEvent e) {
        Object pilih = e.getSource();

        if (pilih.equals(view.getTblCustomer())) {
            //get index of selected row on table
            int i = view.getTblCustomer().getSelectedRow();
            TableModel tModel = view.getTblCustomer().getModel();

            //set the value of every text field in view
            view.getTfNoKTP().setText(tModel.getValueAt(i, 0).toString());
            view.getTfUsername().setText(tModel.getValueAt(i, 1).toString());
            view.getTfPassword().setText(tModel.getValueAt(i, 2).toString());
            view.getTfNamaCustomer().setText(tModel.getValueAt(i, 3).toString());
            view.getTfAlamat().setText(tModel.getValueAt(i, 4).toString());
            view.getTfUmur().setText(tModel.getValueAt(i, 5).toString());
            view.getTfJenisKelamin().setText(tModel.getValueAt(i, 6).toString());
            view.getTfNoTelepon().setText(tModel.getValueAt(i, 7).toString());
            view.getTfSaldo().setText(tModel.getValueAt(i, 8).toString());

        } else if (pilih.equals(view.getTblMaskapai())) {
            //get index of selected row on table
            int i = view.getTblMaskapai().getSelectedRow();
            TableModel tModel = view.getTblMaskapai().getModel();

            //set the value of every text field in view
            view.getTfKodeMaskapai().setText(tModel.getValueAt(i, 0).toString());
            view.getTfMasUsername().setText(tModel.getValueAt(i, 1).toString());
            view.getTfMasPassword().setText(tModel.getValueAt(i, 2).toString());
            view.getTfMasNama().setText(tModel.getValueAt(i, 3).toString());
            view.getTfJumPesawat().setText(tModel.getValueAt(i, 4).toString());
        } else if (pilih.equals(view.getTblKonfirmasiTransaksi())) {
            int i = view.getTblKonfirmasiTransaksi().getSelectedRow();
            TableModel tModel = view.getTblKonfirmasiTransaksi().getModel();

            //set the value of every text field in view
            view.getTfIdPesan().setText(tModel.getValueAt(i, 0).toString());
            view.getTfTransNoKTP().setText(tModel.getValueAt(i, 1).toString());
            view.getTfTransNama().setText(tModel.getValueAt(i, 2).toString());
            view.getTfNoSeat().setText(tModel.getValueAt(i, 3).toString());
            view.getTfStatus().setText(tModel.getValueAt(i, 4).toString());
            view.getTfKodeBooking().setText(tModel.getValueAt(i, 5).toString());
        } else if (pilih.equals(view.getTblBandara())){
            int i = view.getTblBandara().getSelectedRow();
            TableModel tModel = view.getTblBandara().getModel();

            //set the value of every text field in view
            view.getTfKodeBandara().setText(tModel.getValueAt(i, 0).toString());
            view.getTfNamaBandara().setText(tModel.getValueAt(i, 1).toString());
            view.getTfLatitude().setText(tModel.getValueAt(i, 2).toString());
            view.getTfLongitude().setText(tModel.getValueAt(i, 3).toString());
            view.getTfKota().setText(tModel.getValueAt(i, 4).toString());
            view.getTfNegara().setText(tModel.getValueAt(i, 5).toString());
            
        }
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
