def call(body) {
    pipeline {
    agent any
    
    //environment { 
     //}
     stages {
        stage('Add') {
            steps {
                script {
                    if (env.JOB_NAME == 'Project-A') {
                        add()
                    }
                }
            }
        } 
        stage('Subtract') {
            steps {
                subtract()
            }
        }
        stage('test') {
            steps {
                script {
                    if (env.GIT_BRANCH == 'origin/main') {
                        sh 'hello'
                    }
		}
            }
        }
        
    }
}
}
