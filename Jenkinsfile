pipeline {
    agent any

    stages {
        stage('cleanWS') {
            steps {
                echo 'Hello World'
               // cleanWs()
                echo "Building ${env.JOB_NAME}..."
            }
        }
        // stage('Git Checkout') {
        //     steps {
        //         sh 'git clone https://github.com/harishk97/Minikube-SpringApp.git '
        //     }
        // }
        stage('Maven Stage') {
            steps {
                sh 'mvn -version'
                sh 'mvn clean install'
                sh 'mvn package'
            }
        }
        stage('Nexus Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'nexus-cred', passwordVariable: 'NEXUS_PWD', usernameVariable: 'NEXUS_USER')]) {
                    sh """mvn deploy -DaltDeploymentRepository=nexus::default::http://localhost:8081/repository/maven-releases/ -Dnexus.username=${NEXUS_USER} -Dnexus.password=${NEXUS_PASSWORD} """
                }
            }
        }
        stage('Docker Build and Push') {
            withDockerRegistry(credentialsId: 'nexus-admin-cred', toolName: 'docker', url: 'http://localhost:8081/repository/docker-private/'){
                sh 'docker build -t localhost:8083/spring-app .'
                sh 'docker push localhost:8083/spring-app'
            }
        }
        stage('Kubernetes Stage') {
            steps {
                echo 'Hello World'
            }
        }
    }
}
