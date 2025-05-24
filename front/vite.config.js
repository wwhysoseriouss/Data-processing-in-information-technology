import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'


// https://vite.dev/config/
export default defineConfig({
  plugins: [vue()],
  build: {
    outDir: 'dist',
    emptyOutDir: true
  },
  base: '/Lab_2_Shoes-1.0-SNAPSHOT/',
  server: {
    proxy: {
      '/shoes': {
        target: 'http://localhost:8080/Lab_2_Shoes-1.0-SNAPSHOT/',
        changeOrigin: true,
        secure: false
      }
    }
  }
})
