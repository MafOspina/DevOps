package com.devops

def build(){
    sh 'node -v'
    sh 'npm install'
    sh 'npm start'
}

