package com.devops

def buildimage(repo_name){
    sh "docker build -t ${repo_name}:${env.BUILD_ID} ."
}




