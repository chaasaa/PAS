/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import tampilan.mahasiswa;
import java.sql.SQLException;

public interface controller {
    public void Simpan (mahasiswa sw) throws SQLException;
    public void Batal (mahasiswa sw) throws SQLException;
    public void Keluar (mahasiswa sw) throws SQLException;
    public void Tampil (mahasiswa sw) throws SQLException;
}
