package DAOPabrik;

import DAOImplement.PabrikImplement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import koneksi.connector;
import models.*;

public class PabrikDAO implements PabrikImplement{
    Connection conn;
    
    final String select = "SELECT * FROM pabrik";
    final String insert = "INSERT INTO pabrik (nama_produk, jumlah_unit, jam_kerja, jumlah_tenaga_kerja, biaya_bahan_baku, biaya_tenaga_kerja, efisiensi_produksi, total_biaya_produksi) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    final String update = "UPDATE pabrik SET nama_produk = ?, jumlah_unit = ?, jam_kerja = ?, jumlah_tenaga_kerja = ?, biaya_bahan_baku = ?, biaya_tenaga_kerja = ?, efisiensi_produksi = ?, total_biaya_produksi = ? WHERE id = ?";
    final String delete = "DELETE FROM pabrik WHERE id = ?";
    
    public PabrikDAO() {
        conn = connector.connection();
    }

    @Override
    public void insert(Pabrik p) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, p.getNamaProduk());
            stmt.setInt(2, p.getJumlahUnit());
            stmt.setInt(3, p.getJamKerja());
            stmt.setInt(4, p.getJumlahTenagaKerja());
            stmt.setInt(5, p.getBiayaBahanBaku());
            stmt.setInt(6, p.getBiayaTenagaKerja());
            stmt.setFloat(7, p.getEfisiensiProduksi());
            stmt.setInt(8, p.getTotalBiayaProduksi());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            while(rs.next()) {
                p.setId(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void update(Pabrik p) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(update);
            stmt.setString(1, p.getNamaProduk());
            stmt.setInt(2, p.getJumlahUnit());
            stmt.setInt(3, p.getJamKerja());
            stmt.setInt(4, p.getJumlahTenagaKerja());
            stmt.setInt(5, p.getBiayaBahanBaku());
            stmt.setInt(6, p.getBiayaTenagaKerja());
            stmt.setFloat(7, p.getEfisiensiProduksi());
            stmt.setInt(8, p.getTotalBiayaProduksi());
            stmt.setInt(9, p.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(delete);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<Pabrik> getAll() {
        List<Pabrik> p = null;
        try {
            p = new ArrayList<>();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {                
                Pabrik pabrik = new Pabrik();
                pabrik.setId(rs.getInt("id"));
                pabrik.setNamaProduk(rs.getString("nama_produk"));
                pabrik.setJumlahUnit(rs.getInt("jumlah_unit"));
                pabrik.setJamKerja(rs.getInt("jam_kerja"));
                pabrik.setJumlahTenagaKerja(rs.getInt("jumlah_tenaga_kerja"));
                pabrik.setBiayaBahanBaku(rs.getInt("biaya_bahan_baku"));
                pabrik.setBiayaTenagaKerja(rs.getInt("biaya_tenaga_kerja"));
                pabrik.setEfisiensiProduksi(rs.getFloat("efisiensi_produksi"));
                pabrik.setTotalBiayaProduksi(rs.getInt("total_biaya_produksi"));
                p.add(pabrik);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return p;
    }
}
