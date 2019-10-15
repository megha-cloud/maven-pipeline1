pipeline {
    agent any
    stages {
        stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv(sonarQube){
                    sh 'mvn clean package sonar:sonar -Dsonar.host.url=http://52.247.4.47:9000 -Dsonar.projectKey="pipeline demo 1" -Dsonar.sources=. -Dsonar.tests=. '
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
