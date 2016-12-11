/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.preparation.pkg1_producerconsumer;

/**
 *
 * @author John
 */
import java.util.concurrent.BlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread
{

    BlockingQueue<Long> s1;
    BlockingQueue<Long> s2;

    public Producer(BlockingQueue s1, BlockingQueue s2)
    {
        this.s1 = s1;
        this.s2 = s2;
    }

    private long fib(long n)
    {
        if ((n == 0) || (n == 1))
        {
            return n;
        } else
        {
            return fib(n - 1) + fib(n - 2);
        }
    }

    @Override
    public void run()
    {
        try
        {
            while (!s1.isEmpty())
            {
                s2.put(fib(s1.poll()));
            }
        } catch (InterruptedException ex)
        {
            Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(this.getName() + " has finished!");
    }

}
