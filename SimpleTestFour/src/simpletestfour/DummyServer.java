/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simpletestfour;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SE2018194
 */
public class DummyServer {
    
    ArrayList<TemperatureSample> samples = new ArrayList<TemperatureSample>();
    String fileName = "Sample.ser";

    public DummyServer() {
        try{
           loadFromFile(); 
        }catch(IOException | ClassNotFoundException ex){
            Logger.getLogger(DummyServer.class.getName()).log(Level.SEVERE,null, ex);
        }
    }
   
    
    private void loadFromFile() throws FileNotFoundException, IOException, ClassNotFoundException{
        System.out.println("[SERVER] - Loading samples from file " + fileName);
        //reading the objects from a file
        FileInputStream file = new FileInputStream(fileName);
        ObjectInputStream in = new ObjectInputStream(file);
        
        //method for deserialization of object
        samples = (ArrayList<TemperatureSample>)in.readObject();
        
        in.close();
        file.close();
    }
 
    
    private void saveToFile() throws FileNotFoundException, IOException
    {
        System.out.println("[SERVER] - saving " + " to file " + fileName);
        //reading the objects from a file
        FileOutputStream file = new FileOutputStream(fileName);
        ObjectOutputStream out = new ObjectOutputStream(file);
        
        //method for serialization of object
        out.writeObject(samples);
        
        out.close();
        file.close();
        
        System.out.println("Object has been Serialized");
    }
    
  
    public boolean isConnected(){
        System.out.println("[SERVER] - Testing if server is connected...");
        return true;
    }
    
    public void addSample(TemperatureSample s) throws IOException{
        System.out.println("[SERVER] - Adding " + s + " to " + samples);
        samples.add(s);
        System.out.println("[SERVER] - Samples are " + samples);
        saveToFile(); 
    }
}
