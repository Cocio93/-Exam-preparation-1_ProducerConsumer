/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam.preparation.pkg1_producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer extends Thread
{

    BlockingQueue<Long> s2;
    long result;
    long data;

    public Consumer(BlockingQueue<Long> s2)
    {
        this.s2 = s2;
    }

    @Override
    public void run()
    {
        while (!s2.isEmpty())
        {
            try
            {
                data = s2.take();
                result += data;

                if (s2.isEmpty())
                {
                    Thread.sleep(2000);
                    if (s2.isEmpty())
                    {
                        break;
                    }
                }
            } catch (InterruptedException ex)
            {
                ex.printStackTrace();
            }
        }
        System.out.println("Result: " + result);
        System.out.println("Consumer Thread has finished!");
    }
}