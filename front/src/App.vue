<template>
  <div class="container">
    <div v-if="shoes" class="card">
      <img :src="shoes.imageUrl" alt="Shoe image" class="shoe-image" />
      <h2>{{ shoes.name }}</h2>
      <p><strong>Бренд:</strong> {{ shoes.brand }}</p>
      <p><strong>Модель:</strong> {{ shoes.model }}</p>
      <p><strong>Ціна:</strong> {{ shoes.price }} $</p>
      <p><strong>Розмір:</strong> {{ shoes.size }}</p>
    </div>
    <p v-else>Завантаження даних...</p>
  </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
const shoes = ref(null);
onMounted(async () => {
    const response = await fetch('/shoes');
    shoes.value = await response.json();
});
</script>
