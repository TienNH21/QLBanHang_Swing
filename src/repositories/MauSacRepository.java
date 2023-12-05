package repositories;

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
            
            System.out.println(ds.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ds;
    }
    
    public ArrayList<MauSac> paging(int page, int limit)
    {
        ArrayList<MauSac> ds = new ArrayList<>();
        
        String sql = "SELECT * FROM MauSac ORDER BY ID"
            + " OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
        
            int offset = (page-1) * limit;
            
            ps.setInt(1, offset);
            ps.setInt(2, limit);
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
            
            System.out.println(ds.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ds;
    }
    
    public int countPage(int limit, String keyword, int trangThai)
    {
        int paramIndex = 0;
        String sql = "SELECT COUNT(ID) AS Total FROM MauSac";
        if (keyword.length() > 0) {
            sql += " WHERE (Ma LIKE ? OR Ten LIKE ?) ";
        }

        if (trangThai != -1) {
            sql += (sql.contains("WHERE") ? " AND " : " WHERE ") + " TrangThai = ? ";
        }

        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            if (keyword.length() > 0) {
                ps.setString(++paramIndex, "%" + keyword + "%");
                ps.setString(++paramIndex, "%" + keyword + "%");
            }
            
            if (trangThai != -1) {
                ps.setInt(++paramIndex, trangThai);
            }
            
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            rs.next();
            int total = rs.getInt("Total");
            return (int) Math.ceil(total/limit) + 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    
    public void create(MauSac ms) throws SQLException
    {
        String sql = "INSERT INTO MauSac(Ma, Ten, TrangThai) VALUES (?, ?, ?)";
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());
            ps.setInt(3, ms.getTrangThai());
            ps.execute();
            return ;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public void update(MauSac ms) throws SQLException
    {
        String sql = "UPDATE MauSac SET Ma = ?, Ten = ?, TrangThai = ? WHERE ID = ?";
        
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, ms.getMa());
            ps.setString(2, ms.getTen());
            ps.setInt(3, ms.getTrangThai());
            ps.setInt(4, ms.getId());
            ps.execute();
            return ;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    public ArrayList<MauSac> searchAndPaging(int page, int limit, String keyword, int trangThai)
    {
        int paramIndex = 0;
        ArrayList<MauSac> ds = new ArrayList<>();
        
        String sql = "SELECT * FROM MauSac WHERE TrangThai = ? ";
        
        if (keyword.length() > 0) {
            sql += " AND (Ma LIKE ? OR Ten LIKE ?) ";
        }
            
        sql += " ORDER BY ID OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
        try {
            PreparedStatement ps = this.conn.prepareStatement(sql);
        
            int offset = (page-1) * limit;
            
            if (keyword.length() > 0) {
                ps.setString(++paramIndex, "%" + keyword + "%");
                ps.setString(++paramIndex, "%" + keyword + "%");
            }
            
            if (trangThai != -1) {
                ps.setInt(++paramIndex, trangThai);
            }
            
            ps.setInt(++paramIndex, offset);
            ps.setInt(++paramIndex, limit);
            ps.execute();
            
            ResultSet rs = ps.getResultSet();
            
            while (rs.next()) {
                int id = rs.getInt("ID");
                String ma = rs.getString("Ma");
                String ten = rs.getString("Ten");
                int trangThai1 = rs.getInt("TrangThai");
                
                MauSac ms = new MauSac(id, ma, ten, trangThai1);
                ds.add(ms);
            }
            
            System.out.println(ds.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return ds;
    }
}
