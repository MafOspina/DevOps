def prueba (Map params){
    pipeline {
        agent any

        stages {
            stage('Hello World-prueba') {
                steps {
                    script {
                        //sonarqube.hello(msn: "Mafe la más linda")
                        echo "Hello ${params.msn}"
                    }
                }
            }
        }
    }
}
