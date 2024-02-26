<script setup>
import HeaderWeb from '../components/layout/HeaderWeb.vue'
import FooterWeb from '../components/layout/FooterWeb.vue'
import BestProduct from '../components/product/BestProduct.vue'
import AllFournisseurs from '../components/suppliers/AllFournisseurs.vue'
</script>

<template>

    <HeaderWeb />
    
    <div class="container-fluid hero-section p-4">
      <div class="row">
        <div class="col-md-5">
          <img src="/src/assets/img/wine_wallpaper.jpg" alt="Image héroïque" class="img-fluid rounded">
        </div>
        <div class="col-md-6 d-flex align-items-center justify-content-center">
          <div class="hero-content text-center">
            <h1>Nego'Sud vous accompagne</h1>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum necessitatibus, reprehenderit fugit sapiente eius nostrum ut, consectetur velit est doloremque ex molestiae labore deserunt asperiores recusandae! Tempore, voluptatem officiis. Repudiandae.</p>
            <a href = "/allproducts" class = "btn btn-primary">Découvrez tous nos produits</a>
          </div>
        </div>
      </div>
    </div>

    <h2 class="text-center p-4">Nos meilleurs produits</h2>

    <BestProduct />

    <AllFournisseurs />

    <FooterWeb />

</template>
