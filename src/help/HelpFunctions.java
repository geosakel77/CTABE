/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author george
 */
public class HelpFunctions {

    public static void writeLogstoFile(Logger logger) {
        
        
    }
    public static String getProperty(String property_name, String filename) {
        Properties property = new Properties();
        Properties property_config = new Properties();
        String configfilename = "config.properties";
        InputStream fileconfig = null;
        InputStream file = null;
        String property_string = null;

        try {
            fileconfig = HelpFunctions.class.getClassLoader().getResourceAsStream(configfilename);
            if (fileconfig == null) {
                System.out.print("Unable to find the file: " + filename);
                return property_string;
            }
            property_config.load(fileconfig);
            file = HelpFunctions.class.getClassLoader().getResourceAsStream(property_config.getProperty(filename.split("\\.")[0]));
            property.load(file);
            property_string = property.getProperty(property_name);
        } catch (IOException e) {
           Logger.getLogger(HelpFunctions.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if(file!=null){
                try {
                    file.close();
                } catch (IOException ex) {
                    Logger.getLogger(HelpFunctions.class.getName()).log(Level.SEVERE, null, ex);
                }
            if(fileconfig!=null){
                    try {
                        fileconfig.close();
                    } catch (IOException ex) {
                        Logger.getLogger(HelpFunctions.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            }
        }
        return property_string;
    }

}
