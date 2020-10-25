pipeline {
    
    agent {
        label 'mavenTwo'
    }
  
    options {
  	   timestamps()
  	   skipDefaultCheckout true
    }

    environment {
       REPORT = "target/reports"
    }	
    
    stages {
        
        stage('SCM') {
            steps {
                git 'https://github.com/cicd25/demo.git'
            }
        }
    
              
        stage("BUILD") {
            steps {
             script {
		        echo """environment variable : ${env.REPORT}"""
                sh 'mvn clean compile'
                
                currentBuild.result = 'UNSTABLE'
                //currentBuild.result = 'FAILURE'
             }
            }
        }

       stage('TEST') {
	    environment {
		    REPORT = "target/test"
	    }
	   
    	steps {
    		echo """environment variable : ${env.REPORT}"""
    		//echo "server : ${server}"
    	
    	}

	}
        
    }
    
}



