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
        String[] parts = text.split(" ");
        for (String part : parts) {
            if(!map.containsKey(part)){
                map.put(part,1);
            }
            else{
                int count = map.get(part);
                count++;
                map.put(part, count);
            }
            
        }
        
        LinkedList<String> keys = new LinkedList<String>();
        for (String key : map.keySet()) {
            if(map.get(key) < 2){
                keys.add(key);
            }
        }
        for(String key : keys){
            map.remove(key);
        }
        
        return map;
    }
    
    public String getFileName(){
        return filename;
    }
    
    
}
