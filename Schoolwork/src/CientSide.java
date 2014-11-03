/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATMMain;

import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;

/**
 *
 * @author Keith
 *NOTE: This is just an easy access repository for socket information
 * hopefully this can become an object in its own right.
 */
public class ClientSide {
     //Additional Varibale declaration to establish sockets
    private Socket primarySocket;
    private OutputStream outputSocket; 
    private InputStream inputSocket;
    private PrintWriter pw = null;
    private BufferedReader bf = null;
    

// Code for method which sets up connection
public void setUpConnections()
{
   //attempt to establish a connection with the ServerSide
        try{
            primarySocket = new Socket("localhost",1026);
            inputSocket = primarySocket.getInputStream();
            outputSocket=primarySocket.getOutputStream();
        }catch (Exception e){
}
}

public String acceptValues(String input) { //Temp method signature, not implementing the category yet
//private double acceptValues(String category, String input) { 
    double returnedFunds = 0;//temp change, variable not used
    String tempFunds = null;//temp changing from double to string for purposes of testing
        try{
            //establish print writer to transfer data.
            PrintWriter pw = new PrintWriter(outputSocket);
            //grab text from the address text field
            pw.println(input);//temp, not using categorical check
            //writer.println(category + input);//changed from writer.print
            //send it out via flush
            pw.flush();
            //creating a place to recieve infromation from the server
            BufferedReader br = new BufferedReader(new InputStreamReader(inputSocket));
            // display the result back to the
            tempFunds = br.readLine();
            //returnedFunds = Double.parseDouble(tempFunds);
               
        }catch (Exception e){
           //JOptionPane.showMessageDialog(rootPane, e.toString());   
        }
     return tempFunds; //temp changing from double to string for purposes of testing     
    }  
public void closeConnections()
{
   try
   {
      pw.close();
      bf.close();
      primarySocket.close();
   }
   catch(Exception e)
      {System.out.println("Problem closing down connections ");}
}

}



