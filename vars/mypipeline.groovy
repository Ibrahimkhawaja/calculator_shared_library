def call(body) {
    pipeline {
    agent any
    
    environment {
        // This can be nexus3 or nexus2
        NEXUS_VERSION = "nexus3"
        // This can be http or https
        NEXUS_PROTOCOL = "https"
        // Where your Nexus is running
        NEXUS_URL = "nexus.mynisum.com:8443/"
        // Repository where we will upload the artifact
        NEXUS_REPOSITORY = "maven-snapshots"
        // Jenkins credential id to authenticate to Nexus OSS
        NEXUS_CREDENTIAL_ID = "nexus-registry-cred"
        // Build Dir where Build will be executed
        BUILD_DIRECTORY = "ms-config-server/"
		// Kubernetes namespace
		KUBERNETES_NAMESPACE = "development"
		// Kubeconfig path
		KUBECONFIG_PATH = "~/.kube/config"
		// Helm charts branch for development and qabgn
		HELM_CHARTS_BRANCH = "devops"
     }
     stages {
        stage('Initialize env') {
            steps {
                script {
                    if (env.JOB_NAME == 'msconfig-test') {
                        env.BUILD_VERSION = "test-version"
                        env.JOB_BUILD = 'msconfig'
                    }
                }
            }
        } 
        stage('Build and Publish image') {
            steps {
                sh 'echo build step'
            }
        }
        stage('Upload Artifact') {
            steps {
                script {
                    if (env.GIT_BRANCH == 'origin/release') {
                        NEXUS_REPOSITORY = "maven-releases"
						KUBERNETES_NAMESPACE = "qabgn"
						KUBECONFIG_PATH = "~/.kube/config.qa"
						HELM_CHARTS_BRANCH = "qabgn"
                    }
                }
                
            }
        }
        stage('Deploy') {
            steps {
                sh 'echo NEXUS-REPOSITORY = ${NEXUS_REPOSITORY} '
                sh 'echo BUILD-VERSION = ${BUILD_VERSION}'
                sh 'echo JOB-BUILD = ${JOB_BUILD}'
            }
        }
    }
}
}
