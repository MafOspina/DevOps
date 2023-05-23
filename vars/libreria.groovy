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
                    sh 'sudo docker build -t prueba .'
                }
            }
        }
    }
}
