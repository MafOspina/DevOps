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
                        sh 'node -v'
                                           
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
        }
    }
}
