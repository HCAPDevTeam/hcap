package ExperimentResources;

import org.eclipse.californium.core.CoapResource;
import org.eclipse.californium.core.coap.Response;
import org.eclipse.californium.core.coap.CoAP.ResponseCode;
import org.eclipse.californium.core.server.resources.CoapExchange;

public class ConstructResourcesEx1 
{
	public CoapResource[] construct()
	{
		CoapResource[] res = new CoapResource[2];
		
		for(int i = 0; i <=1; i++)
		{
			CoapResource inDemoResource  = new CoapResource("demoResource" + i)
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
