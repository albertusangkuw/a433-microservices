// Submission Dicoding - Proyek Deploy Aplikasi Karsa Jobs dengan Kubernetes
// Albertus Septian Angkuw 
pipeline{
    agent any
    stages{
        // stage("lint-dockerfile"){
        //     agent {
        //         docker {
        //             image 'hadolint/hadolint:latest-alpine'
        //         }
        //     }
        //     steps{
        //         sh 'hadolint -v'
        //         sh 'hadolint Dockerfile -V'
        //     }
        // }
        stage("test-app"){
            agent{
                docker {
                    image 'golang:1.15-alpine'
                }
            }
            environment {
        		GOBIN = '/tmp/go-bin'
        		GOCACHE = '/tmp/go-build'
        		CGO_ENABLED=0
        		HOME = '/tmp'
        	}
            steps{
                script{
                    sh 'go version'
                    sh 'env'
                    sh 'ls'
                    sh 'go mod download'
                    sh 'go test -v -short --count=1 $(go list ./...)'
                }
            }
        }
        stage("build-app-karsajobs"){
             steps {
                withCredentials([usernamePassword(credentialsId: 'd4ef32a9-8bb4-4e57-a8d7-0a080dd7c5d4', 
                                                    passwordVariable: 'GITHUB_TOKEN',   
                                                    usernameVariable: 'GITHUB_USERNAME')]) {
                    sh 'chmod +x build_push_image_karsajobs.sh'
                    sh './build_push_image_karsajobs.sh'
                }
            }
        }
    }
}