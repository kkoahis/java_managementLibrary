package My_Classes;

import My_Forms.DashBoardForm;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.HashMap;
import javaswingdev.Notification;

/**
 *
 * @author Nguyễn Văn Khoa
 */
public class Genres {

    private int id;
    private String name;

    public Genres() {
    }

    public Genres(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addGenres(String _name) throws SQLException {
        String insertQuery = "INSERT INTO `book_genres`(`name_book`) VALUES (?)";
        
        DashBoardForm dashBoardForm = new DashBoardForm();
        
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

            ps.setString(1, _name);

            if (ps.executeUpdate() == 1) {
                //JOptionPane.showMessageDialog(null, "Genres is added", "add genres", 1);
                //DashBoardForm dashBoardForm = new DashBoardForm();
                Notification panel = new Notification(dashBoardForm, Notification.Type.SUCCESS, Notification.Location.TOP_CENTER, "Added Success");
                panel.showNotification();

            } else {
                //DashBoardForm dashBoardForm = new DashBoardForm();
                //JOptionPane.showMessageDialog(null, "Genres is not added", "add genres", 0);
                Notification panel = new Notification(dashBoardForm, Notification.Type.INFO, Notification.Location.TOP_CENTER, "Added unSuccess");
                panel.showNotification();
            }

        } catch (SQLException e) {
            Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //edit genres by id
    public void editGenres(int _id, String _name) throws SQLException {
        String editQuery = "UPDATE `book_genres` SET `name_book`= ? WHERE `id_book` = ?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);

            ps.setString(1, _name);
            ps.setInt(2, _id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Genres is edited", "edit genres", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Genres is not edit", "edit genres", 0);
            }

        } catch (SQLException e) {
            Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //delete genres
    public void deleteGenres(int _id) throws SQLException {
        String editQuery = "DELETE FROM `book_genres` WHERE `id_book` = ?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(editQuery);

            ps.setInt(1, _id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Genres is deleted", "delete genres", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Genres is not delete", "delete genres", 0);
            }

        } catch (SQLException e) {
            Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<Genres> genreList(String query) {
        ArrayList<Genres> gLists = new ArrayList<>();

        My_Classes.Func_Class func = new My_Classes.Func_Class();

        try {
            if (query.equals("")) {
                query = "SELECT * FROM `book_genres`";  //if the user empty String then use defaut select
            }

            ResultSet rs = func.getData(query);

            Genres genres;

            while (rs.next()) {
                genres = new Genres(rs.getInt("id_book"), rs.getString("name_book"));
                gLists.add(genres);
            }

        } catch (SQLException sQLException) {
            Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, sQLException);
        }

        return gLists;
    }

    //creat func to return a hashmap
    //String is the key 
    //Integer is the value
    public HashMap<String, Integer> getGenresMap() {
        HashMap<String, Integer> map = new HashMap<>();
        My_Classes.Func_Class func = new My_Classes.Func_Class();
        
        try {
            ResultSet rs = func.getData("SELECT * FROM `book_genres`");

            Genres genres;

            while (rs.next()) {
                genres = new Genres(rs.getInt("id_book"), rs.getString("name_book"));
                map.put(genres.getName(), genres.getId());
            }

        } catch (SQLException sQLException) {
            Logger.getLogger(Genres.class.getName()).log(Level.SEVERE, null, sQLException);
        }
        return map;
    }

    //creat a func to get the genre id
    public Genres getGenresID(Integer id) throws SQLException {
        My_Classes.Func_Class func = new My_Classes.Func_Class();
        ResultSet rs = func.getData("SELECT * FROM `book_genres` WHERE `id_book` = " + id);
        Genres genres = null;

        try {
            if (rs.next()) {
                genres = new Genres(rs.getInt("id_book"), rs.getString("name_book"));
            }
        } catch (SQLException sQLException) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, sQLException);
        }
        return genres;
    }
}
