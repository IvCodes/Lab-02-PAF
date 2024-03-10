// package com.lab04ii.lab04iiconsumer;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.client.RestTemplate;


// @SpringBootApplication
// public class GetgreetingsApplication {
    

//     private static RestTemplate httpClient = null; 

//     private static String baseURL = "http://localhost:8081/";  //prdoucer url

//     //endpoints for remote calls 
//     private static String defaultGreetingURL = "greeting";
//     private static String namedGreetingURL = "/greeting/name?=name=yourName";

//     //main method 
//     public static void main (String[] args ){
//         SpringApplication.run(GetgreetingsApplication.class, args);
//         makeCalls();  //call the makeCalls method to make the remote calls
//     }

//     //singlenton pattern i9mplemented to get a single instaneof the http client 
//     private static RestTemplate  getHttpClient(){

//         if (httpClient == null){
//             httpClient = new RestTemplate();
//         }
//         return httpClient;

//     }

//     //call the default endpoint and the get the response 
//     static Greetings getGreeting(String url) {
//         RestTemplate restmp = getHttpClient();
//         Greetings response = restmp.getForObject(baseURL + "/" + url, Greetings.class);

//         return response;

//     }


//     //call the named endpoint and get the response 
//     static Greetings getGreetingByName(String url ) { 
//         RestTemplate restmp = getHttpClient();
//         Greetings response = restmp.getForObject(baseURL + "/" + url, Greetings.class);

//         return response;


//         }


//     //call the endpoints, receive the responses and print them on the console
//     private static void makeCalls(){ 
//         Greetings receivedGreeting1 = GetgreetingsApplication.getGreeting(defaultGreetingURL);
//         Greetings receivedGreeting2 = GetgreetingsApplication.getGreetingByName(namedGreetingURL);

//         String content1 = receivedGreeting1.content();
//         System.out.println(content1); // must

//         String content2 = receivedGreeting2.content();
//         System.out.println(content2);

//         }

// }
