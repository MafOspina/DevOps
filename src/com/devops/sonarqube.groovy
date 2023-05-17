package com.devops

def scanner(Map params){

    def scannerHome = tool "${params.scannerHome}" 

    sh "${scannerHome}/bin/sonar-scanner \
        -Dsonar.projectKey=${params.key} \
        -Dsonar.projectName=${params.name} \
        -Dsonar.projectVersion=${params.version} \
        -Dsonar.sources=/var/jenkins_home/workspace/Reto_1 \
        -Dsonar.host.url=http://sonarqube:9000\
        -Dsonar.login=admin \
        -Dsonar.password=admin1 "
}