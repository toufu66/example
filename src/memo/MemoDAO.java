package memo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class MemoDAO {
    static final String URL =  "jdbc:mysql://localhost/memo?useSSL=false";
    static final String USER = "java";
    static final String PASS = "password";

    public ArrayList<Memo> findALL(){
        ArrayList<Memo> l = new ArrayList<Memo>();
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            //Class.fortitle("com.mysql.jdbc.Driver");

            final String sql = "select * from Memo";
            final PreparedStatement stmt = con.prepareStatement(sql);
            final ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                final int mid = rs.getInt("mid");
                final String title = rs.getString("title");
                final String body = rs.getString("body");

                final Memo e = new Memo( mid, title,body);
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
            // Class.fortitle("com.mysql.jdbc.Driver");

            final String sql = String.format("INSERT INTO Memo (title,body) VALUES('%s','%s')", n, a);
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
            // Class.fortitle("com.mysql.jdbc.Driver");
            final String sql = "UPDATE Memo set title = ? , body = ?  where mid = ?" ;
            final PreparedStatement stmt = con.prepareStatement(sql);

            stmt.executeUpdate();

            stmt.close();

        } catch (final SQLException e) {
            System.out.println("UPDATEエラー：" + e.getMessage());
        }
    }


    public Memo findByMid(int sid){
        Memo l = null;
        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            //Class.fortitle("com.mysql.jdbc.Driver");

            final String sql = String.format("select * from Memo where mid = %d",sid);

            final PreparedStatement stmt = con.prepareStatement(sql);
            final ResultSet rs = stmt.executeQuery();
            rs.next();
            final int mid = rs.getInt("mid");
            final String title = rs.getString("title");
            final String body = rs.getString("body");

            Memo e = new Memo( mid, title,body);




            stmt.close();
            return e;

        } catch (final SQLException e) {
            System.out.println("Find By SIDエラー：" + e.getMessage());
        }
        return l;
    }
    public void deleteByMid(int sid){

        try(Connection con = DriverManager.getConnection(URL,USER,PASS)){
            //Class.fortitle("com.mysql.jdbc.Driver");

            final String sql = String.format("delete  from Memo where mid = %d",sid);

            final PreparedStatement stmt = con.prepareStatement(sql);



            stmt.close();


        } catch (final SQLException e) {
            System.out.println("DELETE エラー：" + e.getMessage());
        }

    }

}
