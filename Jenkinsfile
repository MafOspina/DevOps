@Library('Library1') _

pipeline {
    agent any
    stages {
        stage('Hello World-prueba') {
            steps {
                script {
                    sonarqube.hello(msn: "Mafe la más linda")
                }
            }
        }

        stage('Recibir Parámetros') {
            steps {
                script {
                    // Accede a los parámetros enviados desde el repositorio A
                    echo "El valor del parámetro 1 es ${params.parametro1}"
                    echo "El valor del parámetro 2 es ${params.parametro2}"
                }
            }
        }
    }
}