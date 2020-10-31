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
	    when {
	       anyOf {
		    branch 'master', branch 'development'
		}
	    }	    
            steps {
		echo "code compilation"	     
            }
        }

       stage('TEST') {
    		steps {
			
		    parallel 'unitTest' : {
			echo "executing unit test cases......"	
			sleep 10
			
		    },
		    'systemTest' : {
			echo "executing system test cases......"
			error "SYSTEM TEST FAILED......"
		    },
                    'securityTest' : {
			echo "executing security test cases......"
			sleep 20
		    },
		    'failFast': false		   	
	    	}
      }
        
    }       
}




