package com.danielpm1982.springboot2healthrecord;
import com.danielpm1982.springboot2healthrecord.controller.PatientController;
import com.danielpm1982.springboot2healthrecord.controller.ProfessionalController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class Springboot2HealthRecordApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Springboot2HealthRecordApplication.class, args);

        //showing data externalized to Environment variables - must be set at the IDE. Or, at the OS, and then read to the IDE
        try {
            String hospitalName = (String) ctx.getBean("hospitalName");
            System.out.println("Hospital Name: " + hospitalName);
            String userName = (String) ctx.getBean("userName");
            System.out.println("User Name: " + userName);
        } catch (ClassCastException ex){
            System.err.println("ERROR: one or more environment variable(s) could not be read !");
            System.err.println("Check if environment variables are really set at the IDE (Run/Edit Configurations/Environment variables...");
        }

        //showing data externalized to resources .properties files
        ProfessionalController professionalController = (ProfessionalController) ctx.getBean("professionalController");
        professionalController.showAllProfessionals();
        PatientController patientController = (PatientController) ctx.getBean("patientController");
        patientController.showPatient(194878L);
        patientController.showAllPatients();

        //showing data externalized to resources .yaml files
        List<String> policyRulesList = (List<String>)ctx.getBean("policyRulesList");
        policyRulesList.forEach(System.out::println);
    }
}

/*
At this main class we simply get the Application Context created beans to show the
externalized properties' values injected at them, at the configuration classes, from
the 3 external sources: environment variables, .properties files and .yaml files, as above specified.

The environmet varirables that should be set at menu Run/Edit Configurations/Environment variables,
are: HOSPITAL_NAME=danielpm1982 Hospitals;USER_NAME=happyManager . If not set, a ClassCastException
is thrown.

As with any typical MVC application, the entity classes, the repositories and services are located
at the domain, repository and service packages, while the controllers are located at the controller
package. Entities are used at the repository classes, including at the DB class; repository objects
are injected into Service classes, and the objects of these are, in turn, injected at the controller
classes, from which all operations over patients (and patient records) and professionals are to be called.

Regarding the domain entities relationship structure, both Patient and Profesional extends Person;
PatientRecord aggregates a list of Consultation - 1:n; and Patient aggregates PatientRecord - 1:1.
Each Patient thus has 1 PatientRecord with multiple Consultation instances.

Regarding the repositories, a generic Person oriented DB bean stores all person instances (both patients
and professionals), through the methods turned available from the PersonRepository, where the DB bean
is injected and manipulated. PatientRepository and ProfessionalRepository extend that PersonRepository,
specializing the available methods for the PatientServiceImpl and ProfessionalServiceImpl to use. And these
are injected at the controllers for the final users to use.

All bootstrap Data is managed by Configuration classes and later pushed into the DB through the @PostConstruct
methods at the controllers.

At the configuration package, each data source has a loader @Component bean class, which reads the properties' values
from the evironment variables, .properties files and .yaml files, injects that raw data into local fields (through @Value)
and turn it available to external beans or classes through public get methods.

Still at the configuration package, the BootstrapDataConfiguration class injects itself all loader beans,
in order to get all bootstrapped raw data, transform it into the correct final Objects and use these to create
the respective final beans that will be turned available to the main and to the controller classes.

In the case of the beans with the data from the evironemnt variables and .yaml sources, which are simple String
or List<String> beans whose data does not need to be added to the DB, it is done directly: after creation of these
simple beans, the main class just get them and shows their values. But in the case of the more complex data beans,
whose data is still to be added to the DB, it is done by using the load classes: PatientLoad, ConsultationLoad and
ProfessionalLoad (which themselves are lists of the respective objects). These load beans are then injected at the
controllers for the respective data to be added to the DB, at initialization (@PostConstruct). For retrieving and
showing that data at the main class, the same controllers have accessor "show" methods for that.

At the configuration package, the Db configuration class also creates the bean for the Db repository class,
just for showing how to create a bean through a java class with @Configuration, @Bean and @Scope annotations,
intead of with @Component or other extended annotations (as @Repository or @Service) at the base class itself
(as done with the other repository and service classes, except the Db one).

After all that, the main class can get the beans and show their values at the console. No GUI view has been
implemented here. The only goal was to show how beans can be created and how properties can have their values
loaded from (or externalized to) different external sources.

*/
