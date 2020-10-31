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
	    
            steps {
		echo "code compilation"	     
            }
        }

       stage('TEST') {
    		steps {
			
		    parallel 'unitTest' : {
			echo "executing unit test cases......"	
		    },
		    'systemTest' : {
			echo "executing system test cases......"
		    },
                    'securityTest' : {
			echo "executing security test cases......"
		    }	   	
	    	}
      }
        
    }       
}




