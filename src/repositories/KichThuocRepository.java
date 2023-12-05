package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.KichThuoc;
import utils.DbConnect;

public class KichThuocRepository {
    private Connection conn;
    
    public KichThuocRepository()
    {
        this.conn = DbConnect.getConnection();
    }

    public ArrayList<KichThuoc> searchAndPaging(int page, int limit, String keyword, int trangThai) {
        String sql = "SELECT * FROM KichThuoc WHERE TrangThai = ? ";
        int paramIndex = 1;

        if (keyword.trim().length() != 0) {
            sql += " AND ( Ma LIKE ? OR Ten LIKE ? ) ";
        }
        
        sql += " ORDER BY ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
        
        ArrayList<KichThuoc> ds = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setInt(paramIndex++, trangThai);
            
            if (keyword.trim().length() != 0) {
                ps.setString(paramIndex++, "%" + keyword + "%");
                ps.setString(paramIndex++, "%" + keyword + "%");
            }
            
            ps.setInt(paramIndex++, (page - 1) * limit);
            ps.setInt(paramIndex++, limit);
            
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int trangThai1 = rs.getInt("TrangThai");
                KichThuoc kt = new KichThuoc(id, ma, ten, trangThai1);
                ds.add(kt);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ds;
    }
    
    public int countPage(int page, int limit, String keyword, int trangThai) {
        String sql = "SELECT COUNT(*) AS Total FROM KichThuoc WHERE TrangThai = ? ";
        int paramIndex = 1;

        if (keyword.trim().length() != 0) {
            sql += " AND ( Ma LIKE ? OR Ten LIKE ? ) ";
        }
        
        ArrayList<KichThuoc> ds = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(paramIndex++, trangThai);
            if (keyword.trim().length() != 0) {
                ps.setString(paramIndex++, "%" + keyword + "%");
                ps.setString(paramIndex++, "%" + keyword + "%");
            }
            
            ps.execute();
            ResultSet rs = ps.getResultSet();
            rs.next();
            int total = rs.getInt("Total");
            return (int) Math.ceil(total/limit) + 1;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return -1;
    }
    
    public void create(KichThuoc kt) throws Exception
    {
        String sql = "INSERT INTO KichThuoc(Ma, Ten, TrangThai) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, kt.getMa());
            ps.setString(2, kt.getTen());
            ps.setInt(3, kt.getTrangThai());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public void update(KichThuoc kt) throws Exception
    {
        String sql = "UPDATE KichThuoc SET Ma = ?, Ten = ?, TrangThai = ? WHERE ID = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, kt.getMa());
            ps.setString(2, kt.getTen());
            ps.setInt(3, kt.getTrangThai());
            ps.setInt(4, kt.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
