
import book.Book;
import consumer.CountConsumer;
import gui.Zustand;
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
        JFrame frame = new JFrame();
        frame.setLayout(new GridLayout(3,1));
        
        Zustand producer1 = new Zustand("producer1");
        frame.add(producer1);
        
        Zustand consumer1 = new Zustand("consumer1");
        frame.add(consumer1);
        
        Zustand consumer2 = new Zustand("consumer2");
        frame.add(consumer2);
        
        frame.setVisible(true);
        frame.setSize(400, 600);
        CountProducer pro = new CountProducer(queue, producer1);
        CountConsumer con1 = new CountConsumer(queue, consumer1);
        CountConsumer con2 = new CountConsumer(queue, consumer2);
        
        pro.start();
        con1.start();
        con2.start();
       
    }
}
