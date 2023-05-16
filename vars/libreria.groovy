def call (Map params){
    pipeline {
        agent any

        stages {
            stage('Hello World-prueba') {
                steps {
                    script {
                        //sonarqube.hello(msn: "Mafe la más linda")
                        
                        def z = new com.devops.sonarqube()
                        z.hello(params.msn)
                        
                        //cho "Hello ${params.msn}"
                    }
                }
            }
        }
    }
}
