pipeline {
    agent any
    stages {
        stage('SonarQube Report') {
            steps {
                withSonarQubeEnv('SonarQube7'){
                    sh 'mvn clean sonar:sonar -Dsonar.host.url=http://13.77.120.66:9000 -Dsonar.projectKey="pipelineDemo1" -Dsonar.sources=. -Dsonar.java.binaries=.'
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
                rtUpload (
                    serverId: 'ARTIFACTORY_SERVER_6',
                    spec: '''{
                        "files": [
                         {
                            "pattern": "/var/lib/workspace/pipelineDemo1/target/maven-git-test*.jar",
                            "target": "jenkins-maven-project-snapshot/"
                         }
                        ]
                    }'''
                )
            }
        }
    }
}
