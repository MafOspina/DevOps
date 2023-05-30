package com.devops

def scanOwasp(repo_name){
    //sh 'docker run -dt --name owasp -v owasp_data:/zap/reports --user root -t owasp/zap2docker-stable /bin/bash'
    sh 'docker exec owasp mkdir /zap/wrk'
    sh 'docker exec owasp zap-full-scan.py -t http://localhost:8888/ -r report.html -I'
    sh 'docker cp owasp:/zap/wrk/report.html report.html'
    sh 'docker cp report.html jenkins:/var/jenkins_home/workspace/owasp/'
}

