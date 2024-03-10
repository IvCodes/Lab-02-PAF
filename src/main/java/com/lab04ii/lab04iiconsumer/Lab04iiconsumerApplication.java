package com.lab04ii.lab04iiconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Lab04iiconsumerApplication {

	
    private static RestTemplate httpClient = null; 

    private static String baseURL = "http://localhost:8081/";

    //endpoints for remote calls 
    private static String defaultGreetingURL = "greeting";
    private static String namedGreetingURL = "/greeting/name?=name=yourName";

	public static void main(String[] args) {
		SpringApplication.run(Lab04iiconsumerApplication.class, args);

		makeCalls();
	}
	
    private static RestTemplate  getHttpClient(){

        if (httpClient == null){
            httpClient = new RestTemplate();
        }
        return httpClient;

    }

    //call the default endpoint and the get the response 
    private static Greetings getGreeting(String url) {
        RestTemplate restmp = getHttpClient();
        Greetings response = restmp.getForObject(baseURL + "/" + url, Greetings.class);

        return response;

    }


    //call the named endpoint and get the response 
    private static Greetings getGreetingByName(String url ) { 
        RestTemplate restmp = getHttpClient();
        Greetings response = restmp.getForObject(baseURL + "/" + url, Greetings.class);

        return response;


        }


    //call the endpoints, receive the responses and print them on the console
    private static void makeCalls(){ 
        Greetings receivedGreeting1 = Lab04iiconsumerApplication.getGreeting(defaultGreetingURL);
        Greetings receivedGreeting2 = Lab04iiconsumerApplication.getGreetingByName(namedGreetingURL);

        String content1 = receivedGreeting1.content();
        System.out.println(content1); // must

        String content2 = receivedGreeting2.content();
        System.out.println(content2);

        }

}



