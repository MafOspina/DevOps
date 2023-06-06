package com.devops

def buildimage(repo_name){
    sh "docker build -t mafe2/${repo_name}:${env.BUILD_ID} ."
}

def pushimage(repo_name){
    withDockerRegistry([ credentialsId: "dockerhub", url: "https://index.docker.io/v1/" ]) {
        sh "docker push mafe2/${repo_name}:${env.BUILD_ID}"
    }
}

def deployimage(repo_name){
    
    def validacion_cont = sh(returnStdout: true, script: 'echo "$(docker ps -a -q --filter name=${repo_name})"').trim()

    echo "el contenedor es ${repo_name}"                        
    if (validacion_cont != '') {  
        sh "docker stop ${repo_name}"
        sh "docker rm ${repo_name}"
    } 

    sh "docker run -d --name ${repo_name} -p 8888:8888 mafe2/${repo_name}:${env.BUILD_ID}"
}

