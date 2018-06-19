package SecureAdmin.SecureAdmin;

import java.lang.Process;
import java.lang.ProcessBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
	//String propFileLocation = "E:\\HCAPv2\\hcap-master\\PropertiesFiles\\Client1.properties";
	//String propFileLocation = "/home/pi/HCAP/hcap-master/PropertiesFiles/Client.properties";
	String propFileLocation  = "/D:/uCalgary/HCAP/hcap/delete/hcap-master/PropertiesFiles/Client.properties";
    public static void main( String[] args )
    {
    	String check;
    	//check = args[0].toString();
    	check = "addClient";
    	
       if(check.contentEquals("addClient")) {
    	   //Inputs
    	   //args[1] ----- client ID
    	   //args[2] ----- principle ID
    	   new App().addClient("C=CA,L=Ottawa,O=Eclipse IoT,OU=Californium,CN=cf-client",null);
    	   //new App().addClient("C=CA,L=Ottawa,O=Eclipse IoT,OU=Californium,CN=cf-client",args[2]);
	/*   try{
		   Process p = new ProcessBuilder("/home/pi/HCAP/hcap-master/Keystores/create-keystores.sh",args[1]).start();
	   }catch(Exception e){
	       e.printStackTrace();
	       System.out.println("Failed to create a certificate");
	   }
	  */ 
       }
       else if(check.contentEquals("removeClient")){
    	   
       }
       else if(check.contentEquals("addResource")) {
    	   
       }
       else if(check.contentEquals("removeResource")) {
    	   
       }
       //Help option
       else {
    	   
       }
        
    }
    /***
     * addClient
     * Parameters
     * 	ClientID
     * 	PrincipleID
     * Purpose: Adds a client to the Authorization server
     */
    public void addClient(String clientID, String principleID) {
    	
    	AdminBuilder admin = new AdminBuilder(propFileLocation);
    	
    	if(admin.addClientToAuth(clientID)) {
    		System.out.println("Client added to the Authorization Server");
    	}
    }
    /***
     * removeClient
     * Parameters
     * 	ClientID
     * Purpose: Removes a client to the Authorization server
     */
    public void removeClient(String clientID) {
    	
    	AdminBuilder admin = new AdminBuilder(propFileLocation);
    	
    	if(admin.removeClientToAuth(clientID)) {
    		System.out.println("Client successfully removed");
    	}
    }
}