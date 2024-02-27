<script setup>
import HeaderWeb from "../components/layout/HeaderWeb.vue";
import FooterWeb from "../components/layout/FooterWeb.vue";
import BestProduct from "../components/product/BestProduct.vue";
import AllFournisseurs from "../components/suppliers/AllFournisseurs.vue";
</script>

<template>
  <HeaderWeb />

  <div
    class="container-fluid hero-section p-4 text-center"
    style="background-color: #2c3e50; color: #ffffff"
  >
    <div class="row">
      <div class="col"></div>
      <div class="col">
        <div class="hero-content">
          <h1 class="display-4">Nego'Sud</h1>
        </div>
      </div>
      <div class="col"></div>
    </div>
  </div>

  <div class="container mt-5">
    <h2 class="text-center mb-4">Nos fournisseurs</h2>
    <div class="row justify-content-center">
      <AllFournisseurs />
    </div>
  </div>

  <h2 class="text-center mt-5 mb-4">Nos meilleurs produits</h2>

  <BestProduct />

  <div class="text-center mt-4">
    <a href="/allproducts" class="btn btn-primary"
      >Découvrez tous nos produits</a
    >
  </div>

  <FooterWeb />
</template>

<style scoped>
.display-4 {
  font-size: 2.5rem;
}

/* Ajoutez d'autres styles selon vos préférences */
</style>
