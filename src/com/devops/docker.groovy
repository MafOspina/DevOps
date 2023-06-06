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
    
    def validacion_cont = sh(returnStdout: true, script: 'echo "$(docker ps -q --filter name=${repo_name})"').trim()
                        
    if (validacion_cont != '') {  
        /*sh "docker stop ${repo_name}"
        sh "docker rm ${repo_name}"*/
        echo "el contenido es: ${validacion_cont}"
    } 

    //sh "docker run -d --name ${repo_name} -p 8888:8888 mafe2/${repo_name}:${env.BUILD_ID}"


    def containerExists = "docker ps -a --format '{{.Names}}' | grep $repo_name"

    if (containerExists.execute().text.contains(repo_name)) {
        println "El contenedor $repo_name existe."
    } else {
        println "El contenedor $containerExists no existe."
    }
}

