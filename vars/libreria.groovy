def call (Map params){
    pipeline {
        agent any

        stages {
            script {
                def rama = "${GIT_BRANCH}"
                echo "La rama es ${rama}" 
                
                if (rama == 'origin/feature') {
                    
                    stage('Verificación rama') {
                        steps {
                            echo "${BUILD_NUMBER}"
                            echo "${GIT_BRANCH}"
                    
                        }
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
        }
    }
}
