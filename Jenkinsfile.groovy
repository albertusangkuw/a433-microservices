// Submission Dicoding - Proyek Deploy Aplikasi Karsa Jobs dengan Kubernetes
// Albertus Septian Angkuw 
pipeline{
    agent any
    stages{
        stage("lint-dockerfile"){
            // lint-dockerfile berisi proses untuk menginstal hadolint dan menjalankannya terhadap berkas Dockerfile
            agent {
                docker {
                    image 'hadolint/hadolint:latest-alpine'
                }
            }
            steps{
                sh 'hadolint -v'
                sh 'hadolint Dockerfile -V'
            }
        }
        stage("build-app-karsajobs"){
            // Build dan push image ke github package
             steps {
                withCredentials([usernamePassword(credentialsId: 'd4ef32a9-8bb4-4e57-a8d7-0a080dd7c5d4', 
                                                    passwordVariable: 'GITHUB_TOKEN',   
                                                    usernameVariable: 'GITHUB_USERNAME')]) {
                    sh 'chmod +x build_push_image_karsajobs_ui.sh'
                    sh './build_push_image_karsajobs_ui.sh'
                }
            }
        }
    }
}