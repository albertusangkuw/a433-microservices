# Submission Dicoding - Proyek Deploy Aplikasi Karsa Jobs dengan Kubernetes
# Albertus Septian Angkuw 

IMAGE_NAME="karsajobs"

docker login ghcr.io -u="${GITHUB_USERNAME}" -p="${GITHUB_TOKEN}"

docker build -t $IMAGE_NAME:latest .

docker push ghcr.io/albertusangkuw/$IMAGE_NAME:latest


docker logout