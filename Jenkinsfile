pipeline {
    agent any
    tools{
        jdk 'jdk17'
        maven 'maven3'
    }


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
                 withMaven(globalMavenSettingsConfig: 'global-settings', jdk: 'jdk17', maven: 'maven3', mavenSettingsConfig: '', traceability: true) {
                    sh "mvn deploy"
                    //sh "mvn deploy:deploy-file -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Minikube.deploy-0.0.1-SNAPSHOT.jar -DgroupId=com.example -DartifactId=Minikube.deploy-Dpackaging=jar -Dversion=0.0.1-SNAPSHOT-DrepositoryId=maven-snapshots"
                    //mvn deploy:deploy-file -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Minikube.deploy-0.0.1-SNAPSHOT.jar -DgroupId=com.example -DartifactId=Minikube.deploy -Dpackaging=jar -Dversion=0.0.1 -DrepositoryId=my-repo-id
                }
             }
         }
        stage('Docker Build and Push') {
            steps{
            withDockerRegistry(credentialsId: 'nexus-admin-cred', url: 'http://localhost:8083/repository/docker-private/'){
                sh 'docker build -t localhost:8083/spring-app .'
                sh 'docker push localhost:8083/spring-app'
                }
            }
        }
        stage('Kubernetes Deploy') {
            steps {
                withKubeConfig(caCertificate: '', clusterName: 'minikube', contextName: '', credentialsId: 'k8s-cred', namespace: '', restrictKubeConfigAccess: false, serverUrl: 'https://192.168.49.2:8443') {
                    sh "kubectl get pods"
                     sh "sleep 5"
                    sh "kubectl apply -f K8s-files"
                    sh "kubectl get pods"
                    sh "kubectl get svc"
                    sh "minikube ip"
                    sh "minikube service app-service --url"
                }
            }
        }
    }
}
