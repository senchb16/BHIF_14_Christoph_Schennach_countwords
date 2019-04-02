
import book.Book;
import consumer.CountConsumer;

import java.awt.GridLayout;
import javax.swing.JFrame;
import producer.CountProducer;
import queue.MyQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Christoph
 */
public class Main {
    public static void main(String[] args) {
        MyQueue<Book> queue = new MyQueue(3);
  
   
        CountProducer pro = new CountProducer(queue);
        CountConsumer con1 = new CountConsumer(queue);
        CountConsumer con2 = new CountConsumer(queue);
        
        pro.start();
        con1.start();
        con2.start();
       
    }
}
