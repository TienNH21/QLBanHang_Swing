package repositories;

// B1:
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.MauSac;
import utils.DbConnect;

public class MauSacRepository {
    private Connection conn;
    
    public MauSacRepository()
    {
        this.conn = DbConnect.getConnection();
    }
    
    public ArrayList<MauSac> findAll()
    {
        ArrayList<MauSac> ds = new ArrayList<>();
        
        String sql = "SELECT * FROM MauSac";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int trangThai = rs.getInt("TrangThai");
                
                MauSac ms = new MauSac(id, ma, ten, trangThai);
                ds.add(ms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ds;
    }
    
    public void delete(int id)
    {
        String sql = "DELETE FROM MauSac WHERE id = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void create(MauSac ms)
    {
        String sql = "INSERT INTO MauSac(Ma, Ten, TrangThai) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());
            ps.setInt(3, ms.getTrangThai());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void update(MauSac ms)
    {
        String sql = "UPDATE MauSac SET Ma = ?, Ten = ?, TrangThai = ? WHERE ID = ?";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());
            ps.setInt(3, ms.getTrangThai());
            ps.setInt(4, ms.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    
    public ArrayList<MauSac> search(String keyword, int trangThai)
    {
        ArrayList<MauSac> ds = new ArrayList<>();
        
        String sql = "SELECT * FROM MauSac WHERE TrangThai = ?";
        
        if (keyword.length() != 0) {
            sql += " AND (Ma LIKE ? OR Ten LIKE ?) ";
        }
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setInt(1, trangThai);
            if (keyword.length() != 0) {
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
            }
            
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int stt = rs.getInt("TrangThai");
                
                MauSac ms = new MauSac(id, ma, ten, stt);
                ds.add(ms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ds;
    }
    
    public ArrayList<MauSac> searchAndPaging(String keyword, int trangThai, int page, int limit)
    {
        ArrayList<MauSac> ds = new ArrayList<>();
        
        String sql = "SELECT * FROM MauSac WHERE TrangThai = ?";
        
        if (keyword.length() != 0) {
            sql += " AND (Ma LIKE ? OR Ten LIKE ?) ";
        }
        
        sql += " ORDER BY ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ps.setInt(1, trangThai);
            int offset = ((page - 1) * limit) + 1;
            if (keyword.length() != 0) {
                ps.setString(2, "%" + keyword + "%");
                ps.setString(3, "%" + keyword + "%");
                ps.setInt(4, offset);
                ps.setInt(5, limit);
            } else {
                ps.setInt(2, offset);
                ps.setInt(3, limit);
            }
            
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int stt = rs.getInt("TrangThai");
                
                MauSac ms = new MauSac(id, ma, ten, stt);
                ds.add(ms);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return ds;
    }
}
