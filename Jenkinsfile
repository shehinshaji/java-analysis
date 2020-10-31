pipeline {
    
    agent {
        label 'mavenTwo'
    }
  
    options {
  	   timestamps()
  	   skipDefaultCheckout true
	   skipStagesAfterUnstable()
    }

    environment {
       REPORT = "target/reports"
    }	

    parameters {
  	string defaultValue: 'master', description: 'specify the git branch to execute build', name: 'branchName', trim: true
	choice choices: ['DEV', 'QA', 'PROD'], description: 'server info....', name: 'server'
    }

    
    stages {
        
        stage('SCM') {
            steps {
                git branch: "${env.branchName}", credentialsId: 'git-credentials', url: 'https://github.com/cicd25/demo.git'
            }
        }
    
              
        stage("BUILD") {
	    tools {
  		maven 'maven363'
	    }

            steps {
		     script {
			
			echo """environment variable : ${env.REPORT}"""
		        sh 'mvn --version'
		        sh 'mvn clean compile'
		        
		        //currentBuild.result = 'FAILURE'
		     }
            }
        }

       stage('TEST') {
	    environment {
		    REPORT = "target/test"
	    }
	   
    	steps {
    		
		echo """ environment variable : ${env.REPORT}
			server : ${params.server}
		"""
		sh 'mvn test'
    	
    	}

      }
        
    }
    post {
	  success {
   		echo "publish junit reports............."
	  }
	  failure {
	   	echo "trigger a mail to developer!......"
	  }
	}
    
}



