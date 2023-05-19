def call (Map params){
    pipeline {
        agent any

        stages {
            stage('Verificación de la rama'){
                script {
                    def rama = "${GIT_BRANCH}"
                    echo "La rama es ${rama}" 
                    
                    if (rama == "origin/feature") {

                        stage('Verificación rama') {
                            steps {
                                echo "${BUILD_NUMBER}"
                                echo "${GIT_BRANCH}"
                        
                            }
                        }
                    }
                }
            }
        }
    }
}
