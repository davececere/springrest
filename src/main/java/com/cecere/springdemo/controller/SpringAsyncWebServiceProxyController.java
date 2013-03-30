package com.cecere.springdemo.controller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.async.DeferredResult;

import com.cecere.springdemo.service.SpringRestDemoService;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.Response;

@Controller
public class SpringAsyncWebServiceProxyController {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringAsyncWebServiceProxyController.class);
	
	public SpringAsyncWebServiceProxyController(){
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(
			value = "/async/webservicecall", 
			method = RequestMethod.GET,
			produces = {MediaType.TEXT_HTML_VALUE}
	)
	public @ResponseBody DeferredResult<String> getDemoById() throws IOException {
	    final DeferredResult<String> deferredResult = new DeferredResult<String>();
	    AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
	    asyncHttpClient.prepareGet("http://www.yahoo.com/").execute(new AsyncCompletionHandler<Integer>(){

	        @Override
	        public Integer onCompleted(Response response) throws Exception{
	            deferredResult.setResult(response.getResponseBody());
	            return response.getStatusCode();
	        }

	        @Override
	        public void onThrowable(Throwable t){
	            // Something wrong happened.
	        }
	    });
	    return deferredResult;
	}
}
