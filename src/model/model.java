/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.koneksi;
import tampilan.mahasiswa;
import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;


public class model implements controller {

    @Override
    public void Simpan(mahasiswa sw) throws SQLException {
        try {
            Connection con = koneksi.getcon();
            String sql = "Insert Into listmahasiswa Values(?,?,?,?,?)";
            PreparedStatement prepare = con.prepareStatement(sql);
            prepare.setString(1, sw.txtNama.getText());
            prepare.setString(2, sw.txtNim.getText());
            prepare.setString(3, (String) sw.cbxJurusan.getSelectedItem());
            prepare.setString(4, sw.txtAlamat.getText());
            prepare.setString(5, sw.txtPhone.getText());
            prepare.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil diSimpan");
            prepare.close();
            Batal(sw);
        } catch (SQLException ex){
            System.out.println(ex);
        } finally {
            Tampil(sw);
        }
    }

    @Override
    public void Batal(mahasiswa sw) throws SQLException {
        sw.txtNama.setText("");
        sw.txtNim.setText("");
        sw.cbxJurusan.setSelectedItem("");
        sw.txtAlamat.setText("");
        sw.txtPhone.setText("");
    }

    @Override
    public void Keluar(mahasiswa sw) throws SQLException {
        
    }

    @Override
    public void Tampil(mahasiswa sw) throws SQLException {
        sw.tblmahasiswa.getDataVector().removeAllElements();
        sw.tblmahasiswa.fireTableDataChanged();
        
        try {
            Connection con = koneksi.getcon();
            Statement stt = con.createStatement();
            String sql = "SELECT * FROM listmahasiswa";
            ResultSet rs = stt.executeQuery(sql);
            while (rs.next()) {                
                Object[] ob = new Object[8];
                ob[0] = rs.getString(1);
                ob[1] = rs.getString(2);
                ob[2] = rs.getString(3);
                ob[3] = rs.getString(4);
                sw.tblmahasiswa.addRow(ob);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
    
