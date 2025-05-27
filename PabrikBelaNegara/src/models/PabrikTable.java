package models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class PabrikTable extends AbstractTableModel{
    
    List<Pabrik> p;
    public PabrikTable(List<Pabrik> p) {
        this.p = p;
    }

    @Override
    public int getRowCount() {
        return p.size();
    }

    @Override
    public int getColumnCount() {
        return 9;
    }
    
    @Override
    public String getColumnName(int column) {
        return switch (column) {
            case 0 -> "ID";
            case 1 -> "Nama Produk";
            case 2 -> "Jumlah Unit";
            case 3 -> "Jam Kerja";
            case 4 -> "Jumlah Tenaga Kerja";
            case 5 -> "Biaya Bahan Baku";
            case 6 -> "Biaya Tenaga Kerja";
            case 7 -> "Efisiensi Produksi";
            case 8 -> "Total Biaya Produksi";
            default -> null;
        };
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       return switch (columnIndex) {
            case 0 -> p.get(rowIndex).getId();
            case 1 -> p.get(rowIndex).getNamaProduk();
            case 2 -> p.get(rowIndex).getJumlahUnit();
            case 3 -> p.get(rowIndex).getJamKerja();
            case 4 -> p.get(rowIndex).getJumlahTenagaKerja();
            case 5 -> p.get(rowIndex).getBiayaBahanBaku();
            case 6 -> p.get(rowIndex).getBiayaTenagaKerja();
            case 7 -> p.get(rowIndex).getEfisiensiProduksi();
            case 8 -> p.get(rowIndex).getTotalBiayaProduksi();
            default -> null;
        };
    }
}
