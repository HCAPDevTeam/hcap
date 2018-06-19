package ExperimentResources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.server.resources.CoapExchange;

/*
 * This class creates the CoapResources which act in place of the actual IoT devices.
 * The only one method here takes in the number of IoT devices for this specific resource server and creates "demoResource" followed by a number.
 * */
public class ConstructResourcesTestMachine 
{
	/*
	 * The number in the argument is the number of resources to be made. 
	 * The array contains all the CoapResources which may be accessed by the handlePost method. 
	 * */
	public CoapResource[] construct(int numResources)
		{
			CoapResource[] res = new CoapResource[numResources];
			
			for(int i = 0; i < numResources; i++)
			{
				CoapResource inDemoResource  = new CoapResource("demoResource" + (i+1))
				{
					@Override
					public void handleGET(CoapExchange exchange)
					{
						System.out.println("Got something in GET.");
						exchange.respond(ResponseCode.CONTENT, "This is authorization server, currently it doesn't support GET.");
					}
					
					@Override
					public void handlePOST(CoapExchange exchange)
					{
						byte[] requestPayload = exchange.getRequestPayload();
						
						Response response = new Response(ResponseCode.CONTENT);
						response.setPayload(requestPayload);
						response.getOptions().setSize2(requestPayload.length);
						exchange.respond(response);
					}
				};
				
				res[i] = inDemoResource;
			}
			return res;
		}
}
