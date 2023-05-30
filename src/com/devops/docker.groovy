package com.devops

def buildimage(repo_name){
    sh "docker build -t ${repo_name}:${env.BUILD_ID} ."
}

def pushimage(repo_name){
    withDockerRegistry([ credentialsId: "dockerhub", url: "https://index.docker.io/v1/" ]) {
        sh "docker push ${repo_name}:${env.BUILD_ID}"
    }
}

