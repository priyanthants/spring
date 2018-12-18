# spring

<pre>#spring-mvc-sample
  build : mvn clean install
  url   : http://localhost:8080/welcome</pre>
  
#spring-boot-sample
  build     : mvn spring-boot:run
  api url   : http://localhost:8080/welcome
  
#spring-boot-swagger-sample
  build     : mvn clean install
  api url   : http://localhost:8080/welcome
  swagger url: http://localhost:8080/swagger-ui.html
  
#spring-boot-multi-module-sample
  build     : mvn clean install
            : cd sample-web
            :mvn spring-boot:run
  api url   : http://localhost:8080/welcome  
  

