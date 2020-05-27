# spring


<h>spring-mvc-sample</h>
<pre>
  note  : change pom tomcat directory location
  build : mvn clean install
  url   : http://localhost:8080/welcome
</pre>
 
 
<h>spring-boot-sample</h>
<pre>
  build     : mvn spring-boot:run
  api url   : http://localhost:8080/welcome
</pre>  
  
<h>spring-boot-swagger-sample</h>
<pre>
  build     : mvn clean install
  api url   : http://localhost:8080/welcome
  swagger url: http://localhost:8080/swagger-ui.html
</pre>
  
<h>spring-boot-multi-module-sample</h>
<pre>
  build     : mvn clean install
            : cd sample-web
            : mvn spring-boot:run
  api url   : http://localhost:8080/welcome  
</pre>

<h>spring-boot-versioning-sample</h>
<pre>
  build     : mvn spring-boot:run
  api url   : http://localhost:8080/v1/welcome 
            : http://localhost:8080/v2/welcome 
</pre>

<h>spring-boot-data-jpa-sample</h>
<pre>
  build     : mvn spring-boot:run
  api url   : http://localhost:8080/product
</pre>

<h>spring-boot-cloud-function-sample</h>
<pre>
  build     : mvn spring-boot:run
  api url   : GET  http://localhost:8080/helloworld 
            : post http://localhost:8080/welcome (body: pass any text)
</pre>

<h>spring-boot-curd-rest-sample</h>
<pre>
  note      : have used lambok(https://projectlombok.org/) library, install IDE addon
  build     : mvn spring-boot:run
  api url   : get http://localhost:8080/employee
	    : get http://localhost:8080/employee/1
            : post http://localhost:8080/employee
	    : put http://localhost:8080/employee/1
            : delete http://localhost:8080/employee/1
 sample body: {
                "firstName": "John",
                "lastName": "Smith"
               }                   
</pre>

<h>spring-boot-cache-sample</h>
<pre>
  note      : check the console log to see whether result came from cache or not
  	    : edit an employee & check the result	
  build     : mvn spring-boot:run
  api url   :  same api's of spring-boot-curd-rest-sample             
</pre>


<h>spring-boot-swagger-advance-sample</h>
<pre>
  note      : have used lambok(https://projectlombok.org/) library, install IDE addon
  build     : mvn spring-boot:run
  api url   : get http://localhost:8080/employee
  swagger url: http://localhost:8080/swagger-ui.html            
</pre>

<h>spring-boot-multi-profile-sample</h>
<pre>
  note      : 2 profiles(prod,dev)
  	    : change application.properties file active profile to 'dev' or 'prod'
	    : or else use specific maven cmd (mvn spring-boot:run -Drun.profiles=prod/mvn spring-boot:run -Drun.profiles=dev)
  build     : mvn spring-boot:run
  api url   : get http://localhost:8080/welcome     
</pre>

  
#updated
