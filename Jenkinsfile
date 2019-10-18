pipeline {
    agent any
    stages {
        stage('SonarQube Report') {
            steps {
                withSonarQubeEnv('SonarQube7'){
                    sh 'mvn clean sonar:sonar -Dsonar.host.url=http://52.167.166.112:9000 -Dsonar.projectKey="pipelineDemo1" -Dsonar.sources=. -Dsonar.java.binaries=.'
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
                    serverId: 'Artifactoty 6.13',
                    spec: '''{
                        "files": [
                         {
                            "pattern": "/var/lib/jenkins/workspace/pipelineDemo1/target/maven-git-test*.jar",
                            "target": "jenkins-maven-project-snapshot/"
                         }
                        ]
                    }''', failNoOp: true
                )
            }
        }
        stage('Building Docker Image'){
            steps{
                script{
                    docker.withRegistry('https://registry.hub.docker.com','dockerhub'){
                    myImage=docker.build("megha8docker/maven-project-demo")
                    myImage.push()
                }    
            }
        } 
    }
}
}
