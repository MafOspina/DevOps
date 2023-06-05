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
            }
            
            stage('Docker Image') {
                steps {
                    script {                        
                        def funImage = new com.devops.docker()
                        funImage.buildimage( "${repo_name}" )
                    }
                }
            }
            
            stage('Push image') {
                steps {
                    script {                        
                        def funPush = new com.devops.docker()
                        funPush.pushimage( "${repo_name}" )
                    }
                }
             }*/
            
            stage('Docker run') {
                steps {
                    script {                        
                        def funDeploy = new com.devops.docker()
                        funDeploy.deployimage( "${repo_name}" )
                    }
                }
            }

            /*stage('Scan OWASP') {
                steps {
                    script {                        
                        def funOwasp = new com.devops.owasp()
                        funOwasp.scanOwasp( "${repo_name}" )
                    }
                }
            }*/
        }
    }
}
