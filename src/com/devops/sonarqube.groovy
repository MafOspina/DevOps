package com.devops

def scanner(repo_name){

    def scannerHome = tool 'sonarqube'
    
    withSonarQubeEnv('Sonarqube_server'){
     sh "${scannerHome}/bin/sonar-scanner \
        -Dsonar.projectKey='${repo_name}'\
        -Dsonar.projectName='${repo_name}' \
        -Dsonar.sources=/var/jenkins_home/workspace/Aplicacion "
    }
}

