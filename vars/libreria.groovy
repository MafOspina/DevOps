def call (Map params){
    pipeline {
        agent any

        stages {
            stage('Scan SonarQube') {
                steps {
                    script {                        
                        def funScan = new com.devops.sonarqube()
                        funScan.scanner(key:params.projectKey, name:params.projectName, sonarHome:params.sonarHome, version:params.projectVersion)
                        //funScan.scanner(name: params.projectName)
                    }
                }
            }
        }
    }
}
