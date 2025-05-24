<template>
  <div class="container">
    <div v-if="shoes" class="card" v-for="item in shoes">
        <img :src="shoes.imageUrl" alt="Shoe image" class="shoe-image" />
        <h2>{{ item.name }}</h2>
        <p><strong>Бренд:</strong> {{ item.brand }}</p>
        <p><strong>Модель:</strong> {{ item.model }}</p>
        <p><strong>Ціна:</strong> {{ item.price }} $</p>
        <p><strong>Розмір:</strong> {{ item.size }}</p>
    </div>
    <p v-else>Завантаження даних...♥</p>
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