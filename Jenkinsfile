pipeline {
    
    agent {
        label 'mavenTwo'
    }
  
    options {
  	timestamps
    }

    environment {
       REPORT = "target/reports"
    }	
    
    stages {
        
              
        stage("BUILD") {
            steps {

		echo """environment variable : ${env.REPORT}"""


                sh 'mvn clean compile'
            }
        }

       stage('TEST') {
	environment {
		REPORT = "target/test"
	}	
	/*
	input {
	  message 'Press OK to continue'
	  submitter 'umesh, mahesh, murali'
	  submitterParameter 'serverInfo'
	  parameters {
	    choice choices: ['DEV', 'QA', 'PROD'], description: 'server to deploy application', name: 'server'
	  }
	}*/
	steps {
		echo """environment variable : ${env.REPORT}"""
		//echo "server : ${server}"

	}

	}
        
    }
    
}


