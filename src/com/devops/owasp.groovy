package com.devops

def scanOwasp(repo_name){
    def validacion_cont = sh(returnStdout: true, script: 'echo "$(docker ps -a -q --filter name=owasp)"').trim()    

    if (validacion_cont == '') {  
        sh 'docker run -dt --name owasp --user root --network=scanowasp -v owasp_data:/zap/reports -t owasp/zap2docker-stable /bin/bash'
        sh 'docker exec owasp mkdir /zap/wrk'
    } else {
        sh 'docker start owasp'
    }
    
    sh 'docker exec owasp zap-full-scan.py -t http://app2:8888/ -r report.html -I'
    sh 'docker cp owasp:/zap/wrk/report.html report.html'
    sh "docker cp report.html jenkins:${env.WORKSPACE}"
}

