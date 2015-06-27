package appl.rest;

import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiBodyObject;
import org.jsondoc.core.annotation.ApiErrors;
import org.jsondoc.core.annotation.ApiError;
import org.jsondoc.core.annotation.ApiHeader;
import org.jsondoc.core.annotation.ApiHeaders;
import org.jsondoc.core.annotation.ApiMethod;
import org.jsondoc.core.annotation.ApiParams;
import org.jsondoc.core.annotation.ApiResponseObject;
import org.jsondoc.core.pojo.ApiVerb;
import org.jsondoc.core.annotation.ApiQueryParam;
import org.jsondoc.core.annotation.ApiPathParam;

import appl.model.ModelSample;

import com.jumppi.frwk.json.JSON;
import com.jumppi.frwk.jump.RequestContext;
import com.jumppi.frwk.log.Log;


@Api(name = "Appl", description = "To call:  http://server:port/app/sv/{op}/{param}. You can use the playground or tools like RESTClient or Postman to POST a JSON body. " +
                                  "Errors format is inspired by Twitter API conventions (https://dev.twitter.com/overview/api/response-codes)")
public class Services {

	//////////////////////////////////////////////////////////////////////////////////////////
	@ApiMethod(
	        path = "op/{id}",
	    	summary = "op/{id}",
	        description = "Simple GET operation with path param:<br>" + 
	    	"<a href='samples/out/Services_opGet.json' target='_blank'>Example output</a><br>",
	    	produces = {"application/json"},
	        verb = ApiVerb.GET
	)
	@ApiHeaders(headers={
	        @ApiHeader(name="IDENTITY_KEY", description="The api identifier")
	})
	@ApiParams(
			pathparams = {
					@ApiPathParam(name = "id", description = "Test value: 123", clazz = Integer.class)
			}
	)
	@ApiResponseObject (clazz = JSON.class)
	@ApiErrors(apierrors={
	        @ApiError(code="99", description="Unespecified error")
	})	
	public static JSON opGet(RequestContext ctx) {
		JSON res = JSON.getInstanceObject();
		ModelSample ms = ModelSample.getInstance();
		res.add("uriParams", ctx.getUriParams());
		res.add("id", ctx.getUriParams().get("id"));
		res.add("res", ms.op());
		res.add("tok", ctx.getToken());
		return res;
	}
	

	//////////////////////////////////////////////////////////////////////////////////////////
	@ApiMethod(
	        path = "op",
	    	summary = "op",
   	        description = "Simple POST operation with path param:<br>" + 
	    	    	      "<a href='samples/in/Services_opPost.json' target='_blank'>Example input</a><br>" +
	    	    	      "<a href='samples/out/Services_opPost.json' target='_blank'>Example output</a><br>",
	    	produces = {"application/json"},
	        consumes = {"application/json"},
	        verb = ApiVerb.POST
	)
	@ApiHeaders(headers={
	        @ApiHeader(name="IDENTITY_KEY", description="The api identifier")
	})
	@ApiBodyObject(clazz = JSON.class)
	@ApiResponseObject (clazz = JSON.class)
	public static JSON opPost(RequestContext ctx) {
		JSON res = JSON.getInstanceObject();
		JSON jsonIn = JSON.parse(ctx.getBodyInput());
		ModelSample ms = ModelSample.getInstance();
		res.add("uriParams", ctx.getUriParams());
		res.add("jsonIn", jsonIn);
		res.add("code", jsonIn.get("code").getString());
		res.add("res", ms.op());
		res.add("tok", ctx.getToken());
		return res;
	}


	//////////////////////////////////////////////////////////////////////////////////////////
	@ApiMethod(
	        path = "op/{id}",
	        summary = "op/{id}",
   	        description = "POST with path params operation with path param:<br>" + 
	    	    	      "<a href='samples/in/Services_opPost.json' target='_blank'>Example input</a><br>" +
	    	    	      "<a href='samples/out/Services_opPost.json' target='_blank'>Example output</a><br>",
	    	produces = {"application/json"},
	        consumes = {"application/json"},
	        verb = ApiVerb.POST
	)
	@ApiHeaders(headers={
	        @ApiHeader(name="IDENTITY_KEY", description="The api identifier")
	})
	@ApiParams(
			pathparams = {
					@ApiPathParam(name = "id", description = "Test value: 123", clazz = Integer.class)
			}
	)
	@ApiBodyObject(clazz = JSON.class)
	@ApiResponseObject (clazz = JSON.class)
	public static JSON opPostWithPathParams(RequestContext ctx) {
		JSON res = JSON.getInstanceObject();
		JSON jsonIn = JSON.parse(ctx.getBodyInput());
		ModelSample ms = ModelSample.getInstance();
		res.add("uriParams", ctx.getUriParams());
		res.add("jsonIn", jsonIn);
		res.add("code", jsonIn.get("code").getString());
		res.add("res", ms.op());
		res.add("tok", ctx.getToken());
		return res;
	}

	
	//////////////////////////////////////////////////////////////////////////////////////////
	@ApiMethod(
	        path = "op2/{id}",
	    	summary = "op2/{id}?x={x}",
	        description = "Simple GET operation with path param and query param<br>" +
  	    	      "<a href='samples/out/Services_op2Post.json' target='_blank'>Example output</a><br>",
	        produces = {"application/json"},
	        verb = ApiVerb.GET
	)
	@ApiParams(
			pathparams = {
					@ApiPathParam(name = "id", description = "Test value: 123", clazz = Integer.class)
			},
			queryparams = {
					@ApiQueryParam(name = "x", description = "Test value: 987", clazz = Integer.class)
			}
	)
	@ApiResponseObject (clazz = JSON.class)
	public static JSON op2(RequestContext ctx) {
		JSON res = JSON.getInstanceObject();
		JSON jsonIn = JSON.parse(ctx.getBodyInput());
		ModelSample ms = ModelSample.getInstance();
		res.add("uriParams", ctx.getUriParams());
		res.add("id", ctx.getUriParams().get("id"));
		res.add("x", ctx.getUriParams().get("x"));
		res.add("res", ms.op());
		return res;
	}

	//////////////////////////////////////////////////////////////////////////////////////////
	@ApiMethod(
	        path = "op/{id}/subop",
	    	summary = "op/{id}/subop",
	        description = "Simple GET sub operation with path param<br>" +
	  	    	      "<a href='samples/out/Services_subop.json' target='_blank'>Example output</a><br>",
	        produces = {"application/json"},
	        verb = ApiVerb.GET
	)
	@ApiParams(
			pathparams = {
					@ApiPathParam(name = "id", description = "Test value: 123", clazz = Integer.class)
			}
	)
	@ApiResponseObject (clazz = JSON.class)
	public static JSON subop(RequestContext ctx) {
		JSON res = JSON.getSample(ctx, "out/Services_subop.json");
		res.add("id", ctx.getUriParams().get("id"));
		return res;
	}
}

