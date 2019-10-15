pipeline {
    agent any
    stages {
        stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv{
                    properties {
                        property "sonar.host.url", "http://52.247.4.47:9000" 
                        property "sonar.projectName", "pipeline demo 1"  
                        property "sonar.projectKey", "pipeline demo 1" 
                    }
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
