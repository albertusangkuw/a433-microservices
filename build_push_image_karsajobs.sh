# Submission Dicoding - Proyek Deploy Aplikasi Karsa Jobs dengan Kubernetes
# Albertus Septian Angkuw 

docker login ghcr.io -u="${GITHUB_USERNAME}" -p="${GITHUB_TOKEN}"

docker build -t albertushub/karsajobs:latest

docker push albertushub/karsajobs:latest

docker logout