def call (Map params){
    pipeline {
        agent any

        stages {
            stage('Hello World-prueba') {
                steps {
                    script {
                        //sonarqube.hello(msn: "Mafe la más linda")
                        
                        def z = new com.devops.sonarqube()
                        z.hello(par1:params.msn, par2:params.msn2)
                        
                        //cho "Hello ${params.msn}"
                    }
                }
            }
        }
    }
}
