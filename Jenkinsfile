pipeline {
    agent any
    stages {
        stage('build && SonarQube analysis') {
            steps {
                sh 'mvn clean package sonar:sonar'
            }
        }
        stage("Quality Gate") {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }
    }
}
