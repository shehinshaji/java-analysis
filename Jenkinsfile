pipeline {
    
    agent {
        label 'mavenTwo'
    }
    
    stages {
        
        stage('SCM') {
            steps {
                git branch: "${branchName}", credentialsId: 'git-credentials', url: 'https://github.com/cicd25/demo.git'
            }
        }
        
        stage("BUILD") {
            steps {
                sh 'mvn clean package'
            }
        }
        
    }
    
}


