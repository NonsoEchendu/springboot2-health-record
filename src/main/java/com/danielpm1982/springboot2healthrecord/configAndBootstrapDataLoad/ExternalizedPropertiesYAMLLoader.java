package com.danielpm1982.springboot2healthrecord.configAndBootstrapDataLoad;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.List;

@Component
public class ExternalizedPropertiesYAMLLoader {
    @Value(value="${policy.rule1}")
    private String policyRule1;
    @Value(value="${policy.rule2}")
    private String policyRule2;
    @Value(value="${policy.rule3}")
    private String policyRule3;
    private List<String> policyRulesList;
    @PostConstruct
    public void createAndSetPolicyRulesList(){
        policyRulesList = Arrays.asList(policyRule1, policyRule2, policyRule3);
    }
    public List<String> getPolicyRulesList() {
        return policyRulesList;
    }
}
