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

<h>spring-boot-retry-sample</h>
<pre>
  build     : mvn spring-boot:run
  api url   : http://localhost:8080/v1/welcome 
            : http://localhost:8080/v2/welcome 
</pre>

<h>spring-boot-retry-sample</h>
<pre>
  note      : change application.property database config
            : run query.sql on db
  build     : mvn spring-boot:run
  api url   : http://localhost:8080/product
</pre>

  

