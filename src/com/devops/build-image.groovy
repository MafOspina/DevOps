package com.devops

def image(){
    sh 'node -v'
    sh 'npm install'
    sh 'npm run build'
}

