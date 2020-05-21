package db_club;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
    static final String URL =  "jdbc:mysql://localhost/club?useSSL=false";
    static final String USER = "java";
    static final String PASS = "password";

    public ArrayList<Member> findALL(){
        ArrayList<Member> l = new ArrayList<Member>();
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            //Class.forName("com.mysql.jdbc.Driver");

            final String sql = "select * from member";
            final PreparedStatement stmt = con.prepareStatement(sql);
            final ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                final int mid = rs.getInt("mid");
                final String name = rs.getString("name");
                final String address = rs.getString("adress");

                final Member e = new Member( mid, name,address);
                l.add(e);
            }

            stmt.close();

        } catch (final SQLException e) {
            System.out.println("Find ALLエラー：" + e.getMessage());
        }
        return l;
    }

    public void insert(final String n, final String a) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            // Class.forName("com.mysql.jdbc.Driver");

            final String sql = String.format("INSERT INTO member (name,adress) VALUES('%s','%s')", n, a);
            System.out.print(sql);
            final PreparedStatement stmt = con.prepareStatement(sql);

            stmt.executeUpdate();

            stmt.close();

        } catch (final SQLException e) {
            System.out.println("INSERTエラー：" + e.getMessage());
        }
    }

    public void update(final int i, final String n, final String a) {
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
            // Class.forName("com.mysql.jdbc.Driver");
            final String sql = "UPDATE member set name = ? , adress = ?  where mid = ?" ;
            final PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, n);//System.out.println("1");
            stmt.setString(2, a);//System.out.println("2");
            stmt.setInt(3, i);//System.out.println("3");

            stmt.executeUpdate();

            stmt.close();

        } catch (final SQLException e) {
            System.out.println("UPDATEエラー：" + e.getMessage());
        }
    }


    public Member findByMid(int sid){
        Member l = null;
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            //Class.forName("com.mysql.jdbc.Driver");

            final String sql = String.format("select * from member where mid = %d",sid);

            final PreparedStatement stmt = con.prepareStatement(sql);
            final ResultSet rs = stmt.executeQuery();
            rs.next();
            final int mid = rs.getInt("mid");
            final String name = rs.getString("name");
            final String address = rs.getString("adress");

            Member e = new Member( mid, name,address);




            stmt.close();
            return e;

        } catch (final SQLException e) {
            System.out.println("Find By SIDエラー：" + e.getMessage());
        }
        return l;
    }
    public void deleteByMid(int sid){

        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            //Class.forName("com.mysql.jdbc.Driver");

            final String sql = String.format("delete  from member where mid = %d",sid);

            final PreparedStatement stmt = con.prepareStatement(sql);



            stmt.close();


        } catch (final SQLException e) {
            System.out.println("DELETE エラー：" + e.getMessage());
        }

    }
}