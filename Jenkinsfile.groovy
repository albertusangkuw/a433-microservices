// Submission Dicoding - Proyek Deploy Aplikasi Karsa Jobs dengan Kubernetes
// Albertus Septian Angkuw 
pipeline{
    agent any
    stages{
        stage("lint-dockerfile"){
            agent {
                docker {
                    image 'hadolint/hadolint:latest-alpine'
                }
            }
            steps{
                sh 'hadolint -v'
                sh 'hadolint Dockerfile'
            }
        }
        stage("test-app"){
            agent{
                docker {
                    image 'golang:alpine'
                }
            }
            steps{
                sh 'go version'
                sh 'go test -v -short --count=1 $(go list ./...)'
            }
        }
        stage("build-app-karsajobs"){
             steps {
                withCredentials([usernamePassword(credentialsId: 'd4ef32a9-8bb4-4e57-a8d7-0a080dd7c5d4', 
                                                    passwordVariable: 'GITHUB_TOKEN',   
                                                    usernameVariable: 'GITHUB_USERNAME')]) {
                    sh 'build_push_image_karsajobs.sh'
                }
            }
        }
    }
}