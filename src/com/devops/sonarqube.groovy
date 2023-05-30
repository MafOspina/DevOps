package com.devops

def scanner(Map params){

    def scannerHome = tool 'sonarqube'
    
    withSonarQubeEnv('Sonarqube_server'){
     sh "${scannerHome}/bin/sonar-scanner \
        -Dsonar.projectKey='prueba'\
        -Dsonar.projectName='prueba' \
        -Dsonar.sources=/var/jenkins_home/workspace/Aplicacion "
    }
}

