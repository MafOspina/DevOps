def call (Map params){
    pipeline {
        agent any

        stages {
            stage('Verificación rama') {
                steps {
                    echo "${BUILD_NUMBER}"
                    echo "${GIT_BRANCH}"

                    script {
                        def rama = "${GIT_BRANCH}"
                        echo "La rama es ${rama}" 
                        
                        if (rama == 'origin/feature') {
                            echo 'Estás en la rama feature'
                        } else {
                            echo 'No estás en la rama feature'
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
