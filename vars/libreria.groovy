def call (Map params){
    pipeline {
        agent any

        tools {
            nodejs 'NodeJS'
        }

        stages {
            stage('Construcción de la aplicación') {
                steps {
                    script {     
                        def buildNpm = new com.devops.build()
                        buildNpm.build()
                    }
                }
            }

            /*stage('Scan SonarQube') {
                steps {
                    script {                        
                        def funScan = new com.devops.sonarqube()
                        funScan.scanner(key:params.projectKey, name:params.projectName, sonarHome:params.sonarHome, version:params.projectVersion)
                    }
                }
            }*/

            stage('Docker Image') {
                steps {
                    sh 'docker build -t reto .'
                }
            }

            stage('Push image') {
                steps {
                    withDockerRegistry([ credentialsId: "dockerhub", url: "https://index.docker.io/v1/" ]) {
                        sh 'docker tag reto mafe2/reto:latest'
                        sh 'docker push mafe2/reto:latest'
                    }
                }
             } 

            stage('Docker run') {
                steps {
                    sh 'docker run -d --name prueba6282 -p 8888:8888 reto'
                }
            }
        }
    }
}
