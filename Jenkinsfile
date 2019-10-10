pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn clean package sonar:sonar'
            }
        }
        stage ("SonarQube analysis") {
            steps {
                withSonarQubeEnv('SonarQube') {
                    sh "../../../sonar-scanner-2.9.0.670/bin/sonar-scanner"   
                }
                waitForQualityGate abortPipeline: true
            }
        }
    }
}
