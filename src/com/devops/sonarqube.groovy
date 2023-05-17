package com.devops

/*def hello(Map params){
    echo "Hello Laura cucos sucios y valentina cagona ${params.par1}"
    echo "Hello Laura cucos sucios y valentina cagona ${params.par2}"   
}*/

def scanner(Map params){

    def scannerHome = tool "${params.scannerHome}" 

    sh "${scannerHome}/bin/sonar-scanner \
        -Dsonar.projectKey=${params.key} \
        -Dsonar.projectName=${params.name} \
        -Dsonar.projectVersion=${params.version} \
        -Dsonar.sources=/var/jenkins_home/workspace/${params.name} \
        -Dsonar.host.url=http://sonarqube:9000\
        -Dsonar.login=admin \
        -Dsonar.password=admin1 "
}