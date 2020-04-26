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
