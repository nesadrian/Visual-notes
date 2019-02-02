/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VirtualPiano;

import java.io.File;

/**
 *
 * @author adria_000
 */
public class checkFileValid {
    
    public static File checkFile(File file) {
        if (file.isDirectory()) {
            System.out.println("You have selected a directory. Try again.");
            return null;
        }
        else if (file == null) {
            System.out.println("The file you have selected are not valid or does not exist");
            return null;
        }
        return file;
    }
} 
