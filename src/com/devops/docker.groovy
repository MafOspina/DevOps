package com.devops

def build_image(repo_name){
    def customImage = docker.build("${repo_name}:${env.BUILD_ID}")
}



