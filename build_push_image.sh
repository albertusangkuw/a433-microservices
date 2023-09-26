#!/bin/bash
# Albertus Septian Angkuw - Submission Proyek Deploy Aplikasi Item App dengan Docker Compose

echo "Submission Proyek Deploy Aplikasi Item App dengan Docker Compose"
echo "-Albertus Septian Angkuw-"

# 1. Membuat Docker image dari Dockerfile
docker build -t proyek-pertama . 
echo " "

# 2. Melihat daftar image di lokal
docker images
echo " "

# 3. Mengubah nama image
docker tag proyek-pertama albertushub/proyek-pertama:v1
echo " "

# Mengunggah Image ke Hub
# Docker Hub Login
echo $PASSWORD_DOCKER_HUB | docker login -u albertushub --password-stdin

# Upload image ke Docker Hub 
docker image push albertushub/proyek-pertama:v1