def call (Map params){
    pipeline {
        agent any

        tools {
            nodejs 'NodeJS'
        }

        environment {
            repo_name = "${env.GIT_URL}".replaceAll('.+/(.+)\\.git', '$1').toLowerCase()
        }

        stages {

            /*stage('Build application') {
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
                        funScan.scanner( "${repo_name}" )
                    }
                }
            }*/
            
            stage('Docker Image') {
                steps {
                    script {                        
                        def funImage = new com.devops.docker()
                        funImage.buildimage( "${repo_name}" )
                    }
                }
            }
            /*
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
            }*/
        }
    }
}
