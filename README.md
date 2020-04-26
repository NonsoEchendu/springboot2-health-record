# springboot2-health-record
This is a Health Record application developed with Spring Boot 2

© 2020 Daniel Pinheiro Maia All Rights Reserved<br>
(see Copyright© License at the end of this text).

![testResultScreenshot](https://github.com/danielpm1982/springboot2-health-record/blob/master/src/main/java/com/danielpm1982/springboot2healthrecord/testResultScreenshot/testResultScreenshot1.png)
![testResultScreenshot](https://github.com/danielpm1982/springboot2-health-record/blob/master/src/main/java/com/danielpm1982/springboot2healthrecord/testResultScreenshot/testResultScreenshot2.png)
![testResultScreenshot](https://github.com/danielpm1982/springboot2-health-record/blob/master/src/main/java/com/danielpm1982/springboot2healthrecord/testResultScreenshot/testResultScreenshot3.png)

[**Description of this repository**]<br>
This is a Health Record application developed with Spring Boot 2. The objective of this project is to demonstrate how to use @Configuration and @Bean - instead of @Component or its extended annotations - for the creation of Spring beans and scope setting. Also, we show how to externalize bean properties to standard and custom-named .properties files, environment variables and .yaml files, and how to inject them into beans with @PropertySource and @Value annotations. Automated selection of externalized properties to be injected (same keys, different values), according to different active profiles, is also examplified. All initial bootstrap data about Patients, Professionals and Consultations, as well as hospital description and policy rules are injected from .properties files, environment variables and .yaml files, according to different active profiles settable at application.properties (either "en" or "ptbr"). Additional custom data can then be added from the Controllers and Service interfaces. No Web View has been implemented. And the DB used is simply a Java Collection-based in-memory one, with no JPA or JDBC, with manual @Repository and @Service classes implementations (no Spring Data used). Stereotype annotations used: @Configuration, @Bean, @Scope, @PropertySources, @PropertySource, @Value, @Component, @PostConstruct, @Controller, @Repository, @Service, @Autowired, @SpringBootApplication (@Configuration + @ComponentScan + @EnableAutoConfiguration). For more info, read the project comments at each class, starting from the @SpringBootApplication Main class. Worth mentioning here, there are at least 4 ways of creating beans in Spring: XML bean configuration, @Component Annotations, Java config classes - using @Configuration and @Bean - and Groovy scripts DSL configuration. And also, there are 7 different standard scopes Spring beans can be set with: singleton, prototype, request, session, global-session, application and websocket. You can create and define your own custom scope as well. For more, see Spring 5 and Spring Boot 2 documentations, at: <br> https://docs.spring.io/spring/docs/5.2.5.BUILD-SNAPSHOT/spring-framework-reference/ <br> and <br> https://docs.spring.io/spring-boot/docs/2.3.0.BUILD-SNAPSHOT/reference/html/getting-started.html#getting-started .

The backlog for this agile developed project is simulated through the sequence of its GitHub issues, and respective referred commits, available at: https://github.com/danielpm1982/springboot2-health-record/issues?q=is%3Aissue .

This repository is a single-project repo with Git version control.

Some of my repositories are for backup only, each of them being a collection of tens of projects inside one same repo (with no individual version control for each project), and others are single-project repositores (with effective version control for that single project). As a distinction between them, the backup repos are named in uppercase with underscores (e.g. SPRING3) while the single-project ones are named in lowercase with dashes (e.g. springboot2-ac-di).

See all my public repositories at:
https://github.com/danielpm1982?tab=repositories .

[**Copyright© License**]<br>
© 2020 Daniel Pinheiro Maia All Rights Reserved<br>
This GitHub repository - and all code (software) available inside - is exclusively for academic and individual learning purposes, and is **NOT AVAILABLE FOR COMMERCIAL USE**, nor has warranty of any type. You're authorized to fork, clone, run, test, modify, branch and merge it, at your own risk and using your own GitHub account, for individual learning purposes only, but you're **NOT ALLOWED to distribute, sublicense and/or sell copies of the whole or of parts of it** without explicit and written consent from its owner / author. You can fork this repository to your individual account at GitHub, clone it to your personal notebook or PC, analyse, run and test its code, modify and extend it locally or remotely (exclusively at your own GitHub account and as a forked repository), as well as send issues or pull-requests to this parent (original) repository for eventual approval. GitHub is in charge of explicitly showing whom this respository has been forked from. **If you wish to use any of this repository content in any way other than what is expressed above, or publish it anyway or anywhere other than as a forked repository at your own GitHub account, please contact this repository owner / author** using GitHub or the contact info below. For the meaning of the technical terms used at this license, please refer to GitHub documentation, at https://help.github.com/en/github .

[**Owner and Author of this GitHub Repository**]<br>
Daniel Pinheiro Maia<br>
[danielpm1982.com](http://www.danielpm1982.com)<br>
danielpm1982@gmail.com<br>
[linkedin.com/in/danielpm1982](https://www.linkedin.com/in/danielpm1982)<br>
Brazil<br>
.
