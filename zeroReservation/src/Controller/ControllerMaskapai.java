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
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Zero-Inside
 */
public class ControllerMaskapai implements ActionListener, MouseListener {

    private Application model = new Application();
    private MaskapaiDashboard view;
    private Maskapai maskapai;
    // create array list
    ArrayList<Pesawat> listPesawat = new ArrayList();
    ArrayList<Bandara> listBandara = new ArrayList();
    ArrayList<Penerbangan> listPenerbangan = new ArrayList();
    ArrayList<Jadwal> listJadwal = new ArrayList();

    public ControllerMaskapai(Maskapai maskapai) {
        view = new MaskapaiDashboard();
        view.setVisible(true);
        view.addMouseListener(this);
        view.addActionListener(this);
        view.getTfIdJadwal().setEditable(false);
        view.getLblNamaMaskapai().setText(maskapai.getNama());
        this.maskapai = maskapai; //get info maskapai idMaskapai
        // Display all table
        showPenerbanganTabel();
        showBandaraTabel();
        showPesawatTabel();
        showJadwalTabel();
    }

    //get penerbangan data and display to table
    public void showPenerbanganTabel() {
        // invoke the model
        this.listPenerbangan = model.selectionPenerbangan(maskapai.getIdMaskapai()); // one maskapai one jadwal
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblPenerbangan().getModel();
        for (Penerbangan pecah : listPenerbangan) {
            Object[] row = {
                pecah.getIdPenerbangan(),
                pecah.getIdJadwal(),
                pecah.getIdPesawat(),
                pecah.getIdBandara(),
                pecah.getTujuan(),
                pecah.getAsal(),
                pecah.getHarga()
            };
            tmodel.addRow(row);
        }
    }

    // get bandara and display to tabel
    public void showBandaraTabel() {
        // invoke the model
        this.listBandara = model.getBandara();
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblBandara().getModel();
        for (Bandara pecah : listBandara) {
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

    // get pesawat data and display to tabel 
    public void showPesawatTabel() {
        // invoke the model
        this.listPesawat = model.getPesawat(maskapai.getIdMaskapai());
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblPesawat().getModel();
        DefaultTableModel tmodel2 = (DefaultTableModel) view.getTblPesawat2().getModel();
        for (Pesawat pecah : listPesawat) {
            Object[] row = {
                pecah.getIdPesawat(),
                pecah.getIdMaskapai(),
                pecah.getKeterangan(),
                pecah.getRute(),
                pecah.getJumlahSeat(),
                pecah.getTipe()
            };
            tmodel.addRow(row);
            tmodel2.addRow(row);
        }
    }

    // get jadwal data and display to tabel
    public void showJadwalTabel() {
        // invoke the model
        this.listJadwal = model.getJadwal();
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblJadwal().getModel();
        DefaultTableModel tmodel2 = (DefaultTableModel) view.getTblJadwal2().getModel();
        for (Jadwal pecah : listJadwal) {
            Object[] row = {
                pecah.getIdJadwal(),
                pecah.getWaktuBerangkat(),
                pecah.getWaktuTiba(),
                pecah.getTglPenerbangan()
            };
            tmodel.addRow(row);
            tmodel2.addRow(row);
        }

    }

    // refresh penerbangan tabel
    public void refreshPenerbanganTabel() {
        listPenerbangan.clear(); //clear the array
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblPenerbangan().getModel(); //get table
        tmodel.setRowCount(0); //set to zero
        showPenerbanganTabel(); //display again from DB
    }

    // refresh penerbangan tabel
    public void refreshJadwalTabel() {
        listJadwal.clear(); //clear the array
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblJadwal().getModel(); //get table
        DefaultTableModel tmodel2 = (DefaultTableModel) view.getTblJadwal2().getModel(); //get table
        tmodel.setRowCount(0); //set to zero
        tmodel2.setRowCount(0); //set to zero
        showJadwalTabel(); //display again from DB
    }

    // refresh penerbangan tabel
    public void refreshPesawatTabel() {
        listPesawat.clear(); //clear the array
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblPesawat().getModel(); //get table
        DefaultTableModel tmodel2 = (DefaultTableModel) view.getTblPesawat2().getModel(); //get table
        tmodel.setRowCount(0); //set to zero
        tmodel2.setRowCount(0); //set to zero
        showPesawatTabel(); //display again from DB
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // listen for button event
        Object pilih = e.getSource();

        if (pilih.equals(view.getBtnInsertPenerbangan())) {
            // insert Button
            // cek blank idjadwal , idbandara dan pesawat
            if (view.getTfidJadwal().getText().equals("") || view.getTfKodeBandara().getText().equals("") || view.getTfKodePesawat().getText().equals("")) {
                if (view.getTfidJadwal().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Silahkan pilih jadwal terlebih dahulu pada tabel jadwal");
                }

                if (view.getTfKodeBandara().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Silahkan pilih bandara terlebih dahulu pada tabel bandara");
                }

                if (view.getTfKodePesawat().getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Silahkan pilih pesawat terlebih dahulu pada tabel pesawat");
                }
            } else {
                Penerbangan penerbangan = new Penerbangan(
                        parseInt(view.getTfidJadwal().getText()),
                        view.getTfKodePesawat().getText(),
                        view.getTfKodeBandara().getText(),
                        view.getTfTujuan().getText(),
                        view.getTfAsal().getText(),
                        parseLong(view.getTfHarga().getText())
                );

                model.insertPenerbangan(penerbangan);
                refreshPenerbanganTabel();
            }
        } else if (pilih.equals(view.getBtnUpdatePenerbangan())) {
            //Update
            // cek blank idJadwal
            if (view.getTfidJadwal().getText().equals("")) {
                JOptionPane.showMessageDialog(view, "Silahkan pilih Jadwal Penerbangan dahulu pada tabel Jadwal Penerbangan");
            } else {
                Penerbangan penerbangan = new Penerbangan(
                        parseInt(view.getTfidJadwal().getText()),
                        view.getTfKodePesawat().getText(),
                        view.getTfKodeBandara().getText(),
                        view.getTfTujuan().getText(),
                        view.getTfAsal().getText(),
                        parseLong(view.getTfHarga().getText())
                );

                penerbangan.setIdPenerbangan(idPenerbangan);
                model.updatePenerbangan(penerbangan);
                refreshPenerbanganTabel();

            }
        } else if (pilih.equals(view.getBtnDeletePenerbangan())) {
            //Delete
            if (view.getTfidJadwal().getText().equals("")) {
                JOptionPane.showMessageDialog(view, "Silahkan pilih Jadwal Penerbangan dahulu pada tabel Jadwal Penerbangan");
            } else {
                model.deletePenerbangan(idPenerbangan);
                refreshPenerbanganTabel();
            }
            // Kelola Pesawat
        } else if (pilih.equals(view.getBtnInsertPesawat())) {
            if (view.getTf1KodePeswat().getText().equals("")) {
                JOptionPane.showMessageDialog(view, "Silahkan isi kode pesawat");
            } else {
                Pesawat pesawat = new Pesawat(
                        view.getTf1KodePeswat().getText(),
                        view.getTf2KodeMaskapai().getText(),
                        view.getTf3Keterangan().getText(),
                        view.getTf4Rute().getText(),
                        parseInt(view.getTf5JumlahSeat().getText()),
                        view.getTf6Tipe().getText()
                );

                model.insertPesawat(pesawat);
                refreshPesawatTabel();
            }
        } else if (pilih.equals(view.getBtnUpdatePesawat())) {
            if (view.getTf1KodePeswat().getText().equals("")) {
                JOptionPane.showMessageDialog(view, "Silahkan Pilih Pesawat pada tabel Pesawat");
            } else {
                Pesawat pesawat = new Pesawat(
                        view.getTf1KodePeswat().getText(),
                        view.getTf2KodeMaskapai().getText(),
                        view.getTf3Keterangan().getText(),
                        view.getTf4Rute().getText(),
                        parseInt(view.getTf5JumlahSeat().getText()),
                        view.getTf6Tipe().getText()
                );

                model.updatePesawat(pesawat);
                refreshPesawatTabel();
            }
        } else if (pilih.equals(view.getBtnDeletePesawat())) {
            if (view.getTf1KodePeswat().getText().equals("")) {
                JOptionPane.showMessageDialog(view, "Silahkan Pilih Pesawat pada tabel Pesawat");
            } else {
                model.deletePesawat(view.getTf1KodePeswat().getText());
                refreshPesawatTabel();
            }
            // Kelola Jadwal     
        } else if (pilih.equals(view.getBtnInsertJadwal())) {
            java.util.Date utilStartDate = view.getDateTanggalPenerbangan().getDate();
            java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

            Jadwal jadwal = new Jadwal(
                    view.getTfWaktuBerangkat().getText(),
                    view.getTfWaktuTiba().getText(),
                    sqlStartDate
            );

            model.insertJadwal(jadwal);
            refreshJadwalTabel();

        } else if (pilih.equals(view.getBtnUpdateJadwal())) {
            if (view.getTfIdJadwal().equals("")) {
                JOptionPane.showMessageDialog(view, "Silahkan Pilih Jadwal pada tabel Jadwal");
            } else {
                java.util.Date utilStartDate = view.getDateTanggalPenerbangan().getDate();
                java.sql.Date sqlStartDate = new java.sql.Date(utilStartDate.getTime());

                Jadwal jadwal = new Jadwal(
                        parseInt(view.getTfIdJadwal().getText()),
                        view.getTfWaktuBerangkat().getText(),
                        view.getTfWaktuTiba().getText(),
                        sqlStartDate
                );

                model.updateJadwal(jadwal);
                refreshJadwalTabel();
            }
        } else if (pilih.equals(view.getBtnDeleteJadwal())) {
            if (view.getTfIdJadwal().equals("")) {
                JOptionPane.showMessageDialog(view, "Silahkan Pilih Jadwal pada tabel Jadwal");
            } else {
                model.deleteJadwal(parseInt(view.getTfIdJadwal().getText()));
            }
        }
    }
    
    private int idPenerbangan;

    @Override
    public void mouseClicked(MouseEvent e) {
        // handle for table event
        Object pilih = e.getSource();

        if (pilih.equals(view.getTblPenerbangan())) {
            int row = view.getTblPenerbangan().getSelectedRow();
            TableModel tModel = view.getTblPenerbangan().getModel();
            //set the value of every text field in view
            view.getTfidJadwal().setText(tModel.getValueAt(row, 1).toString());
            view.getTfKodePesawat().setText(tModel.getValueAt(row, 2).toString());
            view.getTfKodeBandara().setText(tModel.getValueAt(row, 3).toString());
            view.getTfTujuan().setText(tModel.getValueAt(row, 4).toString());
            view.getTfAsal().setText(tModel.getValueAt(row, 5).toString());
            view.getTfHarga().setText(tModel.getValueAt(row, 6).toString());

            idPenerbangan = parseInt(tModel.getValueAt(row, 0).toString()); //get id_penerbangan from tabel, use in updatePenerbangan.
        } else if (pilih.equals(view.getTblPesawat())) {
            int row = view.getTblPesawat().getSelectedRow();
            TableModel tModel = view.getTblPesawat().getModel();
            view.getTfKodePesawat().setText(tModel.getValueAt(row, 0).toString());

        } else if (pilih.equals(view.getTblBandara())) {
            int row = view.getTblBandara().getSelectedRow();
            TableModel tModel = view.getTblBandara().getModel();
            view.getTfKodeBandara().setText(tModel.getValueAt(row, 0).toString());

        } else if (pilih.equals(view.getTblJadwal())) {
            int row = view.getTblJadwal().getSelectedRow();
            TableModel tModel = view.getTblJadwal().getModel();
            view.getTfidJadwal().setText(tModel.getValueAt(row, 0).toString());
        } else if (pilih.equals(view.getTblPesawat2())) {
            int row = view.getTblPesawat2().getSelectedRow();
            TableModel tModel = view.getTblPesawat2().getModel();

            view.getTf1KodePeswat().setText(tModel.getValueAt(row, 0).toString());
            view.getTf2KodeMaskapai().setText(tModel.getValueAt(row, 1).toString());
            view.getTf3Keterangan().setText(tModel.getValueAt(row, 2).toString());
            view.getTf4Rute().setText(tModel.getValueAt(row, 3).toString());
            view.getTf5JumlahSeat().setText(tModel.getValueAt(row, 4).toString());
            view.getTf6Tipe().setText(tModel.getValueAt(row, 5).toString());
        } else if (pilih.equals(view.getTblJadwal2())) {
            int row = view.getTblJadwal2().getSelectedRow();
            TableModel tModel = view.getTblJadwal2().getModel();

            view.getTfIdJadwal().setText(tModel.getValueAt(row, 0).toString());
            view.getTfWaktuBerangkat().setText(tModel.getValueAt(row, 1).toString());
            view.getTfWaktuTiba().setText(tModel.getValueAt(row, 2).toString());
            view.setDateJadwal(tModel.getValueAt(row, 3).toString());

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
