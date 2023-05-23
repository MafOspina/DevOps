package com.devops

def scanner(Map params){

    def scannerHome = tool "${params.sonarHome}" 

    sh "${scannerHome}/bin/sonar-scanner \
        -Dsonar.projectKey=${params.key} \
        -Dsonar.projectName=${params.name} \
        -Dsonar.projectVersion=${params.version} \
        -Dsonar.sources=/var/jenkins_home/workspace/Reto_2 \
        -Dsonar.host.url=http://sonarqube:9000\
        -Dsonar.login=admin \
        -Dsonar.password=admin1 "
}

