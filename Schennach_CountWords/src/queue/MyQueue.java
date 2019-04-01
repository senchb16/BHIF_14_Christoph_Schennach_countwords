/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package queue;

import java.util.LinkedList;

/**
 *
 * @author Christoph
 */
public class MyQueue<T> {
    
    private LinkedList<T> data = new LinkedList();
    private int maxsize=3;

    public MyQueue(int maxsize) {
        this.maxsize=maxsize;
    }
    
    public void put(T newElement)throws FullException{
        if(data.size()<this.maxsize){
            data.add(newElement);
        }
        else{
            throw new FullException();
        }
    }
    
    public T get() throws EmptyException{
        if(data.isEmpty()){
            throw new EmptyException();
        }
        else{
            return data.poll();
        }
    }
    
    
}
