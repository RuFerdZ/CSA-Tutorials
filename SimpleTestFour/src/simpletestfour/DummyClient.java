/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletestfour;

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SE2018194
 */
public class DummyClient {
    
    public static void main(String[] args) {
        DummyClient client = new DummyClient();
        client.executeTest();
    }
    
    public void executeTest()
    {
        DummyServer server = new DummyServer();
        if(server.isConnected()){
            System.out.println("[CLIENT] - The server is connected, the test can proceed...");
       
            
            TemperatureSample s1 = new TemperatureSample();
            s1.value = 10.3;
            s1.location = "London";
            s1.time = new Date();
            System.out.println("[CLIENT] - The sample is : " + s1);
            try{
                server.addSample(s1);
            }catch(IOException ex){
                Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE,null, ex);
            }
            
            TemperatureSample s2 = new TemperatureSample();
            s2.value = 9.1;
            s2.location = "London";
            s2.time = new Date();
            System.out.println("[CLIENT] - The sample is : " + s2);
            try{
                server.addSample(s2);
            }catch(IOException ex){
                Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE,null, ex);
            }
            
            TemperatureSample s3 = new TemperatureSample();
            s3.value = 5.1;
            s3.location = "London";
            s3.time = new Date();
            System.out.println("[CLIENT] - The sample is : " + s3);
            try{
                server.addSample(s3);
            }catch(IOException ex){
                Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE,null, ex);
            }
            
            TemperatureSample s4 = new TemperatureSample();
            s4.value = -1.1;
            s4.location = "London";
            s4.time = new Date();
            System.out.println("[CLIENT] - The sample is : " + s3);
            try{
                server.addSample(s4);
            }catch(IOException ex){
                Logger.getLogger(DummyClient.class.getName()).log(Level.SEVERE,null, ex);
            }
            
            System.out.println("[CLIENT] - The test has finished");
        }else{
            System.out.println("[CLIENT] - The server is connected, the test has failed...");
        }
    }
}
