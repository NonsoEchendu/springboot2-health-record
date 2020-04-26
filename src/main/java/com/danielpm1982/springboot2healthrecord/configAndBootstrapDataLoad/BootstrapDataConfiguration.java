package com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad;
import com.danielpm1982.springboot2healthrecord.domain.Consultation;
import com.danielpm1982.springboot2healthrecord.domain.Patient;
import com.danielpm1982.springboot2healthrecord.domain.PatientRecord;
import com.danielpm1982.springboot2healthrecord.domain.Professional;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

@Configuration
public class BootstrapDataConfiguration {
    private ExternalizedPropertiesLoader externalizedPropertiesLoader;
    private ExternalizedPropertiesEnvironmentLoader externalizedPropertiesEnvironmentLoader;
    private ExternalizedPropertiesYAMLLoader externalizedPropertiesYAMLLoader;
    public BootstrapDataConfiguration(ExternalizedPropertiesLoader externalizedPropertiesLoader, ExternalizedPropertiesEnvironmentLoader externalizedPropertiesEnvironmentLoader, ExternalizedPropertiesYAMLLoader externalizedPropertiesYAMLLoader) {
        this.externalizedPropertiesLoader = externalizedPropertiesLoader;
        this.externalizedPropertiesEnvironmentLoader = externalizedPropertiesEnvironmentLoader;
        this.externalizedPropertiesYAMLLoader = externalizedPropertiesYAMLLoader;
    }
    @Scope("singleton")
    @Bean
    public PatientLoad patientLoad(){
        return new PatientLoad(mountPatientListFromPatientValuesList(externalizedPropertiesLoader.getAllPatientsValuesList()));
    }
    @Scope("singleton")
    @Bean
    public ProfessionalLoad professionalLoad(){
        return new ProfessionalLoad(mountProfessionalListFromProfessionalValuesList(externalizedPropertiesLoader.getAllProfessionalsValuesList()));
    }
    @Scope("singleton")
    @Bean
    public ConsultationLoad consultationLoad(){
        return new ConsultationLoad(mountConsultationMapFromConsultationValuesList(externalizedPropertiesLoader.getAllConsultationsValuesList()));
    }
    private List<Patient> mountPatientListFromPatientValuesList(List<List<String>> allPatientsValuesList){
        List<Patient> patientList = new ArrayList<>();
        allPatientsValuesList.forEach(x->patientList.add(new Patient(Long.parseLong(x.get(0)), x.get(1), x.get(2), new PatientRecord(new ArrayList<>()))));
        return patientList;
    }
    private List<Professional> mountProfessionalListFromProfessionalValuesList(List<List<String>> allProfessionalsValuesList){
        List<Professional> professionalList = new ArrayList<>();
        allProfessionalsValuesList.forEach(x->professionalList.add(new Professional(Long.parseLong(x.get(0)), x.get(1), x.get(2), Integer.parseInt(x.get(3)), x.get(4), x.get(5))));
        return professionalList;
    }
    private Map<Long, List<Consultation>> mountConsultationMapFromConsultationValuesList(List<List<String>> allConsultationsValuesList){
        Map<Long, List<Consultation>> consultationMap = new HashMap<>();
        for (List<String> consultationValues : allConsultationsValuesList) {
            if(consultationMap.containsKey(Long.parseLong(consultationValues.get(0)))){
                List<Consultation> consultationListForIndividualPatient = consultationMap.get(Long.parseLong(consultationValues.get(0)));
                List<Consultation> consultationListForIndividualPatientUpdated = new ArrayList<>(consultationListForIndividualPatient);
                consultationListForIndividualPatientUpdated.add(new Consultation(LocalDate.parse(consultationValues.get(1)), LocalTime.parse(consultationValues.get(2)), LocalTime.parse(consultationValues.get(3)), Long.parseLong(consultationValues.get(4)), consultationValues.get(5), consultationValues.get(6)));
                consultationMap.put(Long.parseLong(consultationValues.get(0)), consultationListForIndividualPatientUpdated);
            } else{
                consultationMap.put(Long.parseLong(consultationValues.get(0)), Arrays.asList(new Consultation(LocalDate.parse(consultationValues.get(1)), LocalTime.parse(consultationValues.get(2)), LocalTime.parse(consultationValues.get(3)), Long.parseLong(consultationValues.get(4)), consultationValues.get(5), consultationValues.get(6))));
            }
        }
        return consultationMap;
    }
    @Scope("singleton")
    @Bean(name="hospitalName")
    public String hospitalNameSetFromExternalEnvData(){
        return externalizedPropertiesEnvironmentLoader.getEnvironmentDataMap().get("hospitalName");
    }
    @Scope("singleton")
    @Bean(name="userName")
    public String userNameSetFromExternalEnvData(){
        return externalizedPropertiesEnvironmentLoader.getEnvironmentDataMap().get("userName");
    }
    @Scope("singleton")
    @Bean(name="policyRulesList")
    public List<String> policyRulesList(){
        return externalizedPropertiesYAMLLoader.getPolicyRulesList();
    }
}
