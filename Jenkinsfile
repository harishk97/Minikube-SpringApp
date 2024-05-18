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
                echo 'Hello World'
            }
        }
        stage('Maven Stage') {
            steps {
                echo 'Hello World'
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
