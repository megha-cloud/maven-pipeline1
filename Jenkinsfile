pipeline {
    agent any
    stages {
        stage('SonarQube Report') {
            steps {
                withSonarQubeEnv('SonarQube7'){
                    sh 'mvn clean sonar:sonar -Dsonar.host.url=http://52.247.4.47:9000 -Dsonar.projectKey="pipelineDemo1" -Dsonar.sources=. -Dsonar.java.binaries=.'
                }
            }
        }
        stage('Junit with JOCOCO') {
            steps {
                jacoco( 
                    execPattern: 'target/*.exec',
                    classPattern: 'target/classes',
                    sourcePattern: 'java/com/devops/practice',
                    exclusionPattern: 'java/com/devops/practice/test*'
                )
            }
        }
        stage('Maven Build') {
            steps {
                 sh 'mvn clean package'
            }
        }
    }
}
