/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consumer;

import book.Book;
import gui.Zustand;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import queue.EmptyException;
import queue.MyQueue;

/**
 *
 * @author Christoph
 */
public class CountConsumer extends Thread {

    private final MyQueue<Book> bookQueue;
    private HashMap<String, Integer> map = new HashMap<>();
    private final Zustand zustand;

    public CountConsumer(MyQueue<Book> bookQueue, Zustand zustand) {
        this.bookQueue = bookQueue;
        this.zustand = zustand;
    }

    @Override
    public void run() {
        zustand.setToExecute();
        Book book = null;
        while (true) {
            synchronized (bookQueue) {
                try {
                    book = bookQueue.get();
                    bookQueue.notifyAll();
                } catch (EmptyException ex) {
                    try {
                        zustand.setToWait();
                        bookQueue.wait();
                        zustand.setToExecute();
                    } catch (InterruptedException ex1) {
                        Logger.getLogger(CountConsumer.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                    continue;
                }
                try {
                    Thread.sleep(2000);
                    System.out.println("Input: " + book.getFileName());
                    map = book.countWords();
                    File file = new File("output/" + book.getFileName() + "_output");
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                        for (String s : map.keySet()) {
                            writer.write(s + ": " + map.get(s) + "\n");
                            System.out.println(s + ": " + map.get(s));
                        }
                    } catch (Exception ex) {
                        Logger.getLogger(CountConsumer.class.getName()).log(Level.SEVERE, null, ex);
                    }

                } catch (InterruptedException ex) {
                    Logger.getLogger(CountConsumer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
