/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producer;

import book.Book;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import queue.FullException;
import queue.MyQueue;

/**
 *
 * @author Christoph
 */
public class CountProducer extends Thread {

    private final MyQueue<Book> bookQueue;

    public CountProducer(MyQueue bookQueue) {
        this.bookQueue = bookQueue;

    }

    @Override
    public void run() {

        File[] files = new File("src/files/").listFiles();
        for (File file : files) {
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String text = "";
                String line = "";
                while ((line = br.readLine()) != null) {
                    text += line;
                }
                Book book = new Book(file.getName(), text);
                synchronized (bookQueue) {
                    try {
                        bookQueue.put(book);
                        bookQueue.notifyAll();
                    } catch (FullException ex) {

                        bookQueue.wait();

                    }
                }
            } catch (Exception ex) {

            }
        }

    }

}
