pipeline {
    agent any
    stages {
        stage('build && SonarQube analysis') {
            steps {
                withSonarQubeEnv('SonarQube7'){
                    sh 'mvn clean sonar:sonar -Dsonar.host.url=http://52.247.4.47:9000 -Dsonar.projectKey="pipelineDemo1" -Dsonar.sources=. -Dsonar.java.binaries=.'
                }
            }
        }
        stage('Maven Build') {
            steps {
                 sh 'mvn clean package'
            }
        }
    }
}
