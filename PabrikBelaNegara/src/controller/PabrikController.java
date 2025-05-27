package controller;

import java.util.List;
import DAOImplement.PabrikImplement;
import DAOPabrik.PabrikDAO;
import models.*;
import views.MainView;

public class PabrikController {
    MainView frame;
    PabrikImplement impl;
    List<Pabrik> p;
    
    private int selectedId;

    public int getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }
    
    public PabrikController(MainView frame) {
        this.frame = frame;
        impl = new PabrikDAO();
        p = impl.getAll();
    }
    
    public void isiTable() {
        p = impl.getAll();
        PabrikTable pt = new PabrikTable(p);
        frame.getjTablePabrik().setModel(pt);
    }
    
    public void insert() {
        Pabrik p = new Pabrik();
        p.setNamaProduk(frame.getjTxtNamaProduk().getText().trim());
        p.setJumlahUnit(Integer.parseInt(frame.getjTxtJumlahUnit().getText().trim()));
        p.setJamKerja(Integer.parseInt(frame.getjTxtJamKerja().getText().trim()));
        p.setJumlahTenagaKerja(Integer.parseInt(frame.getjTxtJumlahTenagaKerja().getText().trim()));
        p.setBiayaBahanBaku(Integer.parseInt(frame.getjTxtBiayaBahanBaku().getText().trim()));
        p.setBiayaTenagaKerja(p.getJamKerja() * p.getJumlahTenagaKerja() * 1500);
        p.setEfisiensiProduksi((p.getJumlahUnit() / p.getJamKerja() * p.getJumlahTenagaKerja()) * 100);
        p.setTotalBiayaProduksi(p.getBiayaBahanBaku() + p.getBiayaTenagaKerja());
        impl.insert(p);
    }
    
    public void update() {
        Pabrik p = new Pabrik();
        p.setNamaProduk(frame.getjTxtNamaProduk().getText().trim());
        p.setJumlahUnit(Integer.parseInt(frame.getjTxtJumlahUnit().getText().trim()));
        p.setJamKerja(Integer.parseInt(frame.getjTxtJamKerja().getText().trim()));
        p.setJumlahTenagaKerja(Integer.parseInt(frame.getjTxtJumlahTenagaKerja().getText().trim()));
        p.setBiayaBahanBaku(Integer.parseInt(frame.getjTxtBiayaBahanBaku().getText().trim()));
        p.setBiayaTenagaKerja(p.getJamKerja() * p.getJumlahTenagaKerja() * 15000);
        p.setEfisiensiProduksi((p.getJumlahUnit() / p.getJamKerja() * p.getJumlahTenagaKerja()) * 100);
        if (p.getEfisiensiProduksi() < 20) {
            p.setEfisiensiProduksi(0 - 20);
        }
        p.setTotalBiayaProduksi(p.getBiayaBahanBaku() + p.getBiayaTenagaKerja());
        p.setId(selectedId);
        impl.update(p);
    }
    
    public void delete() {
        int id = selectedId;
        impl.delete(id);
    }
}
