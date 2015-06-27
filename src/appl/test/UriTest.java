package appl.test;

import org.apache.log4j.BasicConfigurator;
import org.junit.Test;

import appl.rest.UriRoute;

import com.jumppi.frwk.jump.CtlUriRoute;
import com.jumppi.frwk.util.Util;

public class UriTest {
	
	@Test
	public void testUriProcess() {
		BasicConfigurator.configure();
		
		String uri = "op2/x@y?x=a@b%20$";
		String uriTemplate = "op2/{id}?x={x}";
		
		String encodedUri = Util.getUriPathDecoded(uri);
		System.out.println(encodedUri);
		CtlUriRoute.setUriRoute(new UriRoute());
		String tpl = CtlUriRoute.getUriTemplate(encodedUri, "GET");
		System.out.println(tpl);
		String jmet = CtlUriRoute.getJavaMethod(tpl);
		System.out.println(jmet);
		System.out.println(Util.dumpHashMap(CtlUriRoute.getParamsMap(encodedUri, uriTemplate)));
	}	

}

