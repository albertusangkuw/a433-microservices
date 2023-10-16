# Submission Dicoding - Proyek Implementasi Asynchronous Communication pada Aplikasi E-Commerce App
# Albertus Septian Angkuw 

# Menggunakan node v18
FROM node:18-alpine 

# Set working directory di /src
WORKDIR /src
# Copy semua package json untuk keperluan npm package
COPY package*.json ./
# Set NODE ENV di production
ENV NODE_ENV=production
# Melakukan clean install di npm
RUN npm ci
# Copy semua file js ke workdir
COPY ./*.js ./
# Command menjalankan consumer.js
CMD ["node", "consumer.js"]