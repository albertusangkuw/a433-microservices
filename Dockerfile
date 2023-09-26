# Submission Dicoding - Proyek Deploy Aplikasi Item App dengan Docker Compose
# Albertus Septian Angkuw

# Menggunakan base image Node.js versi 14.
FROM node:14

# Working directory untuk container
WORKDIR /app

# Menyalin semua file ke working directory
COPY . .

# Konfigurasi Environment Aplikasi
ENV NODE_ENV=production DB_HOST=item-db

# Menginstal dependencies untuk production dan kemudian build aplikasi
RUN npm install --production --unsafe-perm && npm run build

# Post yang digunakan 
EXPOSE 8080

# Untuk menjalankan server
CMD [ "npm", "start" ]