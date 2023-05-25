def call (Map params){
    pipeline {
        agent any

        tools {
            nodejs 'NodeJS'
        }

        environment {
            DOCKERHUB_CREDENTIALS = credentials('docker_hub')
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

            stage('Scan SonarQube') {
                steps {
                    script {                        
                        def funScan = new com.devops.sonarqube()
                        funScan.scanner(key:params.projectKey, name:params.projectName, sonarHome:params.sonarHome, version:params.projectVersion)
                    }
                }
            }

            stage('Docker Image') {
                steps {
                    sh 'docker build -t reto .'
                }
            }

            /*stage('Docker run') {
                steps {
                    sh 'docker run '
                }
            }*/

            stage('Login') {
                steps {
                    sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
                }
            }

            stage('Push') {
                steps {
                    sh 'docker push mafe2/reto:latest'
                }
            }
        }
    }
}
