<script setup>
import HeadersWeb from "src/components/layouts/HeadersWeb.vue";
import CarteFamilles from "../components/CarteFamilles.vue";
</script>

<template>
  <q-layout view="hHh Lpr lFf">
    <HeadersWeb />
    <q-page-container>
      <q-page-section>
        <!-- <q-page-section :style="{ minWidth: '200px' }">
            <h2 class="text-center mb-4">Filtres</h2>
          </q-page-section> -->

        <q-page-section>
          <div class="d-flex flex-column align-items-center">
            <h2 class="text-center mb-4">Tous nos produits</h2>
            <CarteFamilles />
          </div>
        </q-page-section>
      </q-page-section>
    </q-page-container>
  </q-layout>
</template>
