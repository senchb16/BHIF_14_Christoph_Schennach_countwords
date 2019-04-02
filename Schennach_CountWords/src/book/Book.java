/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package book;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Christoph
 */
public class Book {
    private String filename;
    private String text;
    private HashMap<String, Integer> map = new HashMap<>();

    public Book(String filename, String text) {
        this.filename = filename;
        this.text = text;
    }
    
    public HashMap<String, Integer> countWords(){
       //implement counting
        return map;
    }
    
    public String getFileName(){
        return filename;
    }
    
    
}
