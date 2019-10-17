pipeline {
    agent any
    stages {
        stage('SonarQube Report') {
            steps {
                withSonarQubeEnv('SonarQube7'){
                    sh 'mvn clean sonar:sonar -Dsonar.host.url=http://52.179.214.135:9000 -Dsonar.projectKey="pipelineDemo1" -Dsonar.sources=. -Dsonar.java.binaries=.'
                }
            }
        }
        stage('Junit with JOCOCO') {
            steps {
                step([$class: 'JacocoPublisher', 
                    execPattern: 'target/*.exec',
                    classPattern: 'target/classes',
                    sourcePattern: 'src/main/java',
                    exclusionPattern: 'src/test*'
                ])
            }
        }
        stage('Maven Build') {
            steps {
                 sh 'mvn clean package'
            }
        }
        stage('Artifactory Upload'){
            steps {
                rtMavenRun (
                    serverId: "Artifactoty 6.13",
                    goals: 'clean install',
                    snapshotRepo: "jenkins-maven-project-snapshot"
                )
            }
        }
    }
}
