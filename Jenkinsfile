pipeline {
    agent any

    parameters {
        string(name: 'FOLDER_PATH', defaultValue: 'springboot2-health-record', description: 'Folder Path Directory')
        string(name: 'GROUP_ID', defaultValue: 'com.danielpm1982', description: 'Maven Group ID')
        string(name: 'ARTIFACT_ID', defaultValue: 'springboot2-health-record', description: 'Maven Artifact ID')
        string(name: 'VERSION', defaultValue: '0.0.1-SNAPSHOT', description: 'Project Version')
        string(name: 'GIT_REPO', defaultValue: 'https://github.com/danielpm1982/springboot2-health-record.git', description: 'Git Repository URL')
    }
    
    environment {
        SONARQUBE = 'Sonarqube'
        ARTIFACTORY_SERVER = 'artifactory1'
    }
    
    stages {
        stage('Clone Repository') {
            steps {
                script {
                    sh """
                        if [ ! -d "${params.FOLDER_PATH}" ]; then
                            git clone ${params.GIT_REPO}
                        fi
                    """
                }
            }
        }
        
        stage('Install Maven') {
            steps {
                echo 'Installing Maven...'
                script {
                    sh """
                        sudo apt-get update
                        sudo apt-get install -y maven
                        sudo rm -rf /var/lib/apt/lists/*
                        echo "export MAVEN_HOME=/usr/share/maven" >> ~/.bashrc
                        . ~/.bashrc
                    """
                }
            }
        }

        stage('SonarQube Analysis') {
            steps {
                echo 'Analysing with SonarQube...'
                script {
                    withSonarQubeEnv(SONARQUBE) {
                        sh """
                            cd ${params.FOLDER_PATH}
                            mvn clean verify sonar:sonar -DskipTests
                        """
                    }
                }
                
            }
        }
        
        stage('Build') {
            steps {
                echo 'Building app...'
                script {
                    sh """
                        cd ${params.FOLDER_PATH}
                        mvn clean package -DskipTests
                    """
                }
                
            }
        }
        
        stage('Quality Gate') {
            steps {
                // Wait for SonarQube analysis to complete and check Quality Gate status
                script {
                    timeout(time: 5, unit: 'MINUTES') {
                        waitForQualityGate abortPipeline: true
                    }
                }
            }
        }

        
        
        stage('Publish to Artifactory') {
            steps {
                script {
                    def server = Artifactory.server(ARTIFACTORY_SERVER)
                    def buildInfo = Artifactory.newBuildInfo()
                    
                    // First build with Maven
                    sh """
                        cd ${params.FOLDER_PATH}
                        mvn clean install -DskipTests
                    """
                    
                    // Create upload spec with your specific values
                    def uploadSpec = """{
                        "files": [{
                            "pattern": "${params.ARTIFACT_ID}/target/${params.ARTIFACT_ID}-${params.VERSION}.jar",
                            "target": "test001/${params.GROUP_ID.replace('.', '/')}/${params.ARTIFACT_ID}/${params.VERSION}/",
                            "props": "type=jar;status=ready",
                            "recursive": false
                        },
                        {
                            "pattern": "${params.ARTIFACT_ID}/pom.xml",
                            "target": "test001/${params.GROUP_ID.replace('.', '/')}/${params.ARTIFACT_ID}/${params.VERSION}/${params.ARTIFACT_ID}-${params.VERSION}.pom",
                            "props": "type=pom;status=ready",
                            "recursive": false
                        }]
                    }"""
                    
                    // Upload to Artifactory
                    server.upload spec: uploadSpec, buildInfo: buildInfo
                    server.publishBuildInfo buildInfo
                }
            }
        }
    }
}