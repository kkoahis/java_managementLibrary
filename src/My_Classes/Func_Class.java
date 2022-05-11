package My_Classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Statement;
import java.io.File;
import java.sql.PreparedStatement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Nguyễn Văn Khoa
 */
public class Func_Class {

    public void displayImage(int width, int height, byte[] imagebyte, String imagePath, JLabel lable) {
        //get the image
        ImageIcon imgIco;
        if (imagebyte != null) {    //get image using byte
            imgIco = new ImageIcon(imagebyte);
        } else {                    //get imgae using path
            try {
                //get the image from the project resoure
                imgIco = new ImageIcon(getClass().getResource(imagePath));
            } catch (Exception e) {
                //get the image from desktop
                imgIco = new ImageIcon(imagePath);
            }

        }
        //let the image fit the jlable
        Image image = imgIco.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        //set the image to jlable
        lable.setIcon(new ImageIcon(image));
    }

    //creat a function to select the image
    //the function will return the image path
    public String selectImage() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Profile Picture");

        fileChooser.setCurrentDirectory(new File("D:\\ONE DRIVE\\OneDrive"));

        FileNameExtensionFilter extentionFilter = new FileNameExtensionFilter("Image", ".png", ".jpg", ".jpeg");
        fileChooser.addChoosableFileFilter(extentionFilter);

        int fileState = fileChooser.showSaveDialog(null);
        String path = "";

        if (fileState == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().getAbsolutePath();
        }

        return path;
    }

    //creat a function to customize the jtable
    public void customTable(JTable jTable) {
        jTable.setSelectionBackground(new Color(255, 144, 10));
        jTable.setSelectionForeground(Color.white);
        jTable.setShowGrid(true);
        jTable.setRowHeight(30);
        jTable.setBackground(new Color(248, 248, 248));
        jTable.setGridColor(Color.pink);
    }

    //creat a function to customize the jtableheader
    public void customTableHeader(JTable jTable_header, Color font_Color, Integer font_Size) {
        jTable_header.getTableHeader().setForeground(font_Color);
        jTable_header.getTableHeader().setFont(new Font("Verdana", Font.BOLD, font_Size));
        jTable_header.getTableHeader().setOpaque(false);
    }

    //creat a function to return a resultset
    //we will use this func to reduce the code when populating the arraylist
    public ResultSet getData(String query) {
        PreparedStatement ps;
        ResultSet rs = null;
        
        try {
            ps = DB.getConnection().prepareStatement(query);
            rs = ps.executeQuery();
        } catch (SQLException sQLException) {
            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, sQLException);
        }
        return rs;
    }

    //creat a func to count the number of data
    public int countData(String tableName) {
        int total = 0;
        ResultSet rs;
        Statement st;
        
        try {
            st = DB.getConnection().createStatement();
            rs = st.executeQuery("SELECT COUNT(*) as total FROM `" + tableName + "`");
            if (rs.next()) {
                total = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Func_Class.class.getName()).log(Level.SEVERE, null, ex);
        }
        return total;
    }
}
