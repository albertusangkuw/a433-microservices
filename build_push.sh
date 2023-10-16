# Submission Dicoding - Proyek Implementasi Asynchronous Communication pada Aplikasi E-Commerce App
# Albertus Septian Angkuw 

# Set nama image
IMAGE_NAME="order-service"

# Login untuk push image ke github package dengan token
docker login ghcr.io -u="${GITHUB_USERNAME}" -p="${GITHUB_TOKEN}"

# Build image
docker build -t $IMAGE_NAME:latest .

# Memberikan nama tag sesuai dengan format github package
docker tag $IMAGE_NAME:latest  ghcr.io/albertusangkuw/$IMAGE_NAME:latest 

# Push image ke github server
docker push ghcr.io/albertusangkuw/$IMAGE_NAME:latest

# Logout sesi github user
docker logout ghcr.io