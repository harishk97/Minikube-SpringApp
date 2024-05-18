pipeline {
    agent any

    stages {
        stage('cleanWS') {
            steps {
                echo 'Hello World'
                cleanWs()
                echo "Building ${env.JOB_NAME}..."
            }
        }
        stage('Git Checkout') {
            steps {
                echo 'git clone https://github.com/harishk97/Minikube-SpringApp.git '
            }
        }
        stage('Maven Stage') {
            steps {
                echo 'mvn -version'
            }
        }
        stage('Nexus Push') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Docker Build and Push') {
            steps {
                echo 'Hello World'
            }
        }
        stage('Kubernetes Stage') {
            steps {
                echo 'Hello World'
            }
        }
    }
}
