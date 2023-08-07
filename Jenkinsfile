pipeline {
    agent any
    tools{
        jdk ("jdk-17")
    }
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                sh 'chmod +x gradlew'
                sh './gradlew bootJar'
            }
        }

        stage('Docker build') {
            steps {
                script {
                    dockerImage = docker.build("deshy-back:latest")
                }
            }
        }

        stage('Recreate container') {
            steps {
                sh '''
                    docker stop deshy-back || true
                    docker rm deshy-back || true
                    docker run -d --name deshy-back -p 80:8080 deshy-back:latest
                '''
            }
        }
    }
}