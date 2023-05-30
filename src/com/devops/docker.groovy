package com.devops

def build_image(repo_name){
    def customImage = docker.build("${build_image}:${env.BUILD_ID}")
}



