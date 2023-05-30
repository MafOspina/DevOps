package com.devops

def buildimage(repo_name){
    def customImage = docker.build("${repo_name}:${env.BUILD_ID}")
}



