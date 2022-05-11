package My_Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Nguyễn Văn Khoa
 */
public class Author {

    private int id;
    private String firstName;
    private String lastName;
    private String about;
    private String field_Of_Expertise;

    public Author() {
    }

    public Author(int id, String firstName, String lastName, String field_Of_Expertise, String about) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.field_Of_Expertise = field_Of_Expertise;
        this.about = about;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getField_Of_Expertise() {
        return field_Of_Expertise;
    }

    public void setField_Of_Expertise(String field_Of_Expertise) {
        this.field_Of_Expertise = field_Of_Expertise;
    }

    public void addAuthor(String _firstName, String _lastName, String _expertise, String _about) throws SQLException {
        String insertQuery = "INSERT INTO `author`(`firstName`, `lastName`, `expertise`, `about`) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

            ps.setString(1, _firstName);
            ps.setString(2, _lastName);
            ps.setString(3, _expertise);
            ps.setString(4, _about);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Author is added", "add author", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Author is not added", "add authors", 0);
            }

        } catch (SQLException e) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void editAuthor(int _id, String _firstName, String _lastName, String _expertise, String _about) throws SQLException {
        String insertQuery = "UPDATE `author` SET `firstName`= ?,`lastName`= ?,`expertise`= ?,`about`= ? WHERE `id_author` = ?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

            ps.setString(1, _firstName);
            ps.setString(2, _lastName);
            ps.setString(3, _expertise);
            ps.setString(4, _about);
            ps.setInt(5, _id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Author is edited", "edit author", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Author is not edit", "edit authors", 0);
            }

        } catch (SQLException e) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void deleteAuthor(int _id) throws SQLException {
        String insertQuery = "DELETE FROM `author` WHERE `id_author` = ?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

            ps.setInt(1, _id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Author is deleted", "delete author", 1);
            } else {
                JOptionPane.showMessageDialog(null, "Author is not delete", "delete authors", 0);
            }

        } catch (SQLException e) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    My_Classes.Func_Class func = new Func_Class();

    public ArrayList<Author> authorsList(String query) {
        ArrayList<Author> auLists = new ArrayList<>();

        try {
            if (query.equals("")) {
                query = "SELECT * FROM `author`";  //if the user empty String then use defaut select
            }
            
            ResultSet rs = func.getData(query);

            Author author;

            while (rs.next()) {
                author = new Author(rs.getInt("id_author"), rs.getString("firstName"),
                        rs.getString("lastName"), rs.getString("expertise"), rs.getString("about"));
                auLists.add(author);
            }

        } catch (SQLException sQLException) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, sQLException);
        }

        return auLists;
    }

    //creat a func to get the author id
    public Author getAuthorByID(Integer id) throws SQLException {
        ResultSet rs = func.getData("SELECT * FROM `author` WHERE `id_author` = " + id);
        Author author = null;

        try {
            if (rs.next()) {
                author = new Author(rs.getInt("id_author"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("expertise"), rs.getString("about"));
            }
        } catch (SQLException sQLException) {
            Logger.getLogger(Author.class.getName()).log(Level.SEVERE, null, sQLException);
        }
        return author;
    }

}
