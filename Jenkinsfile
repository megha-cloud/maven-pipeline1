pipeline {
    agent any
    stages {
        sonarqube {
            properties {
                property "sonar.host.url", http://52.247.4.47:9000 
                property "sonar.projectName", "pipeline demo 1"   //  this name will appear in dashboard
                property "sonar.projectKey", "pipeline demo 1" // It sould be a keybased on this report is created
            }
        }
        stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv() {
                        sh 'mvn clean package sonar:sonar'
                }
            }
        }
        stage("Quality Gate") {
            steps {
                timeout(time: 1, unit: 'HOURS') {
                    waitForQualityGate abortPipeline: true
                }
            }
        }
    }
}
