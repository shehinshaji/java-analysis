pipeline {
    
    agent {
        label 'mavenTwo'
    }

    environment {
       REPORT = "target/reports"
    }	
    
    stages {
        
              
        stage("BUILD") {
            steps {

		echo """environment variable : ${env.REPORT} 
 			PATH : ${env.PATH}"""


                sh 'mvn clean package'
            }
        }
        
    }
    
}


