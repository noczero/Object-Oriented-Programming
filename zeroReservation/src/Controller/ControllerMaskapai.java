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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Zero-Inside
 */
public class ControllerMaskapai implements ActionListener, MouseListener {

    private Application model = new Application();
    private MaskapaiDashboard view;

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

        view.getLblNamaMaskapai().setText(maskapai.getNama());

        // Display all table
        showPenerbanganTabel();
        showBandaraTabel();
        showPesawatTabel();
        showJadwalTabel();
    }

    //get penerbangan data and display to table
    public void showPenerbanganTabel() {
        // invoke the model
        this.listPenerbangan = model.getPenerbangan();
        DefaultTableModel tmodel = (DefaultTableModel) view.getTblPenerbangan().getModel();
        for (Penerbangan pecah : listPenerbangan) {
            Object[] row = {pecah.getIdPenerbangan(),
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

    }

    // get pesawat data and display to tabel 
    public void showPesawatTabel() {
        // invoke the model

    }

    // get jadwal data and display to tabel
    public void showJadwalTabel() {
        // invoke the model

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // listen for button event
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // handle for table event

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
