# spring-boot

<h2>setup and run</h2>
<pre>
mvn spring-boot:run
OR
1. mvn clean install
2. java -jar target/internship-spring-boot-live-1.0-SNAPSHOT.jar
</pre>

<h2>profiles</h2>
<pre>
define in application.properties
OR
programatically by SpringApplication.setAdditionalProfiles("dev");

run with: mvn spring-boot:run -Pprod
OR
1. mvn clean install -Pprod
2. java -jar target/internship-spring-boot-live-1.0-SNAPSHOT.jar
</pre>


