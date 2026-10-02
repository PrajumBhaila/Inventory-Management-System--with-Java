/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import dao.InventoryUtils;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class OpenPdf {

    public static void OpenById(String id) {
        try {
            String filePath = InventoryUtils.billPath + id + ".pdf";
            System.out.println("Looking for PDF at: " + filePath);
            File file = new File(filePath);
            System.out.println("File exists: " + file.exists());
            if (file.exists()) {
                Runtime.getRuntime().exec(
                        "rundll32 url.dll,FileProtocolHandler " + filePath
                );
            } else {
                JOptionPane.showMessageDialog(
                        null,
                        "File Does not Exist.\n\nPath:\n" + filePath
                );
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

}
