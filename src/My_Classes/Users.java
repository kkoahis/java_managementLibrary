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
public class Users {

    private int id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
    private String usertype;

    public Users() {
    }

    public Users(int id, String firstname, String lastname, String username, String password, String usertype) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.usertype = usertype;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Func_Class getFunc() {
        return func;
    }

    public void setFunc(Func_Class func) {
        this.func = func;
    }

    My_Classes.Func_Class func = new My_Classes.Func_Class();

    public void addUser(String _firstName, String _lastName, String _userName, String _password, String _user_type) throws SQLException {
        String insertQuery = "INSERT INTO `user_table` (`firstname`, `lastname`, `username`, `password`, `user_type`) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

            ps.setString(1, _firstName);
            ps.setString(2, _lastName);
            ps.setString(3, _userName);
            ps.setString(4, _password);
            ps.setString(5, _user_type);

            if (ps.executeUpdate() != 0) {
                JOptionPane.showMessageDialog(null, "user is added", "add user", 1);
            } else {
                JOptionPane.showMessageDialog(null, "User is not added", "add user", 0);
            }

        } catch (SQLException e) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    //creat a func to get the user id to check if the user already exists
    public boolean checkUsernameExist(String _username) throws SQLException {
        ResultSet rs = func.getData("SELECT * FROM `user_table` WHERE `username` = '" + _username + "'");
        boolean exits = false;

        try {
            if (rs.next()) {
                exits = true;
            }
        } catch (SQLException sQLException) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, sQLException);
        }
        return exits;
    }

    public void editUser(int _id, String _firstName, String _lastName, String _username, String _password, String _user_type) throws SQLException {
        String insertQuery = "UPDATE `user_table` SET `firstname`= ?,`lastname`= ?,`password`= ?, `user_type` = ? WHERE `id` = ?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

            ps.setString(1, _firstName);
            ps.setString(2, _lastName);
            ps.setString(3, _password);
            ps.setString(4, _user_type);
            ps.setInt(5, _id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "User is edited", "edit user", 1);
            } else {
                JOptionPane.showMessageDialog(null, "User is not edit", "edit user", 0);
            }
        } catch (SQLException e) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void deleteUser(int _id) throws SQLException {
        String insertQuery = "DELETE FROM `user_table` WHERE `id` = ?";
        try {
            PreparedStatement ps = DB.getConnection().prepareStatement(insertQuery);

            ps.setInt(1, _id);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "User is deleted", "delete user", 1);
            } else {
                JOptionPane.showMessageDialog(null, "User is not delete", "delete user", 0);
            }
        } catch (SQLException e) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ArrayList<Users> usersList() {
        ArrayList<Users> userLists = new ArrayList<>();

        try {

            //don't show the owner data
            ResultSet rs = func.getData("SELECT * FROM `user_table` WHERE `user_type` <> 'Owner'");

            Users users;

            while (rs.next()) {
                users = new Users(rs.getInt("id"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("username"),
                        rs.getString("password"), rs.getString("user_type"));
                userLists.add(users);
            }

        } catch (SQLException sQLException) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, sQLException);
        }
        return userLists;
    }

    public Users TryLogin(String _username, String _password) {
        ResultSet rs = func.getData("SELECT * FROM `user_table` WHERE `username` = '"
                + _username + "' AND `password` = '" + _password + "'");

        Users user = null;

        try {
            if (rs.next()) {
                user = new Users(rs.getInt("id"), rs.getString("firstname"),
                        rs.getString("lastname"), rs.getString("username"),
                        rs.getString("password"), rs.getString("user_type"));
            }
        } catch (SQLException sQLException) {
            Logger.getLogger(Users.class.getName()).log(Level.SEVERE, null, sQLException);
        }
        return user;
    }

}
