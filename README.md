# springboot2-health-record
This is a Health Record application developed with Spring Boot 2. 

A Jenkinsfile has been added for CI/CD. The Jenkins pipeline automates the build, test, and deployment process for the Spring Boot Health Record application. The pipeline also includes source control management, code quality analysis with SonarQube, and artifact publishing to JFrog's Artifactory.

I've also written an article that gives an in-depth step-by-step breakdown of the stages and steps in the pipeline:
[Check here](https://dev.to/nonso_echendu_001/deploying-jenkins-in-aws-with-integration-to-artifactory-and-sonarqube-2348)

**Prerequisites to run the pipeline script:**

These tools need to be installed:

- Maven 
- Artifactory 
- Sonarqube 
- they both need to be configured on your jenkins server

For a comprehensive guide on how to install these tools, and configure your jenkins with AWS, check this [article](https://dev.to/nonso_echendu_001/deploying-jenkins-on-aws-installing-and-configuring-artifactory-and-sonarqube-on-seperate-ec2-nm9) i wrote on it. 



<br/>
<br/> 


**To run the pipeline script:**

- create a Jenkins job (pipeline)
- select Pipeline script from SCM
- paste in this git repo link
- then build

These are examples of the Sonarqube analysis report done, and uploaded artifacts on JFrog's Artifactory:

Sonarqube:

<img width="1512" alt="Screenshot 2025-01-07 at 01 18 17" src="https://github.com/user-attachments/assets/c2e690f3-87e5-4b4d-adab-aefc2a583b5f" />


<br/>
<br/> 

Artifactory:

<img width="1512" alt="Screenshot 2025-01-06 at 13 29 47" src="https://github.com/user-attachments/assets/8052233f-4414-4279-a9ba-f49665732d3a" />


<br/>

<hr/>


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
