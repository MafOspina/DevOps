package com.devops

def build(){
    sh 'npm install'
    sh 'npm start'
}

