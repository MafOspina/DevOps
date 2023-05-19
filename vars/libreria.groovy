def call (Map params){
    pipeline {
        agent any

        stages {
            stage('Verificación rama') {
                steps {
                    echo "${BUILD_NUMBER}"
                    //echo "${GIT_BRANCH}"

                    def rama = ${GIT_BRANCH}

                    echo "${GIT_BRANCH}"

                    
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
