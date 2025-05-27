package models;

public class Pabrik {
    private int id, jumlahUnit, jumlahTenagaKerja, biayaBahanBaku, biayaTenagaKerja, totalBiayaProduksi, jamKerja;
    private String namaProduk;
    private float efisiensiProduksi;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJumlahUnit() {
        return jumlahUnit;
    }

    public void setJumlahUnit(int jumlahUnit) {
        this.jumlahUnit = jumlahUnit;
    }

    public int getJumlahTenagaKerja() {
        return jumlahTenagaKerja;
    }

    public void setJumlahTenagaKerja(int jumlahTenagaKerja) {
        this.jumlahTenagaKerja = jumlahTenagaKerja;
    }

    public int getBiayaBahanBaku() {
        return biayaBahanBaku;
    }

    public void setBiayaBahanBaku(int biayaBahanBaku) {
        this.biayaBahanBaku = biayaBahanBaku;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public int getBiayaTenagaKerja() {
        return biayaTenagaKerja;
    }

    public void setBiayaTenagaKerja(int biayaTenagaKerja) {
        this.biayaTenagaKerja = biayaTenagaKerja;
    }

    public float getEfisiensiProduksi() {
        return efisiensiProduksi;
    }

    public void setEfisiensiProduksi(float efisiensiProduksi) {
        this.efisiensiProduksi = efisiensiProduksi;
    }

    public int getTotalBiayaProduksi() {
        return totalBiayaProduksi;
    }

    public void setTotalBiayaProduksi(int totalBiayaProduksi) {
        this.totalBiayaProduksi = totalBiayaProduksi;
    }

    public int getJamKerja() {
        return jamKerja;
    }

    public void setJamKerja(int jamKerja) {
        this.jamKerja = jamKerja;
    }
    
    
}
