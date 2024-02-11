<template>
  <q-layout view="hHh Lpr lFf">
    <HeadersWeb />

    <!-- Content -->
    <q-page-container class="q-pa-md">
      <div class="q-gutter-md">
        <h1 class="text-h4">Bienvenue sur notre site de vente de vin</h1>
        <p>
          Découvrez notre sélection de vins de qualité et trouvez celui qui
          correspond à vos goûts.
        </p>
        <q-card-group>
          <q-card
            v-for="famille in randomWines"
            :key="famille.id"
            class="col-md-4"
          >
            <q-card-section>
              <!-- <img :src="wine.image" class="full-width" /> -->
            </q-card-section>
            <q-card-section>
              <q-card-title>{{
                getTypeVinLibelle(famille.typeVinId)
              }}</q-card-title>
              <q-card-subtitle>{{ famille.libelle }}</q-card-subtitle>
              <q-card-main>{{ famille.description }}</q-card-main>
            </q-card-section>
            <q-card-actions align="right">
              <q-btn
                color="primary"
                label="Acheter"
                @click="addToCart(famille)"
              />
            </q-card-actions>
          </q-card>
        </q-card-group>
      </div>
    </q-page-container>
    <!-- Footer -->
    <q-footer>
      <FooterWeb />
    </q-footer>
  </q-layout>
</template>

<script setup>
import { ref, computed, onMounted } from "vue";
import HeadersWeb from "../components/layouts/HeadersWeb.vue";
import FamillesService from "src/services/FamillesService";
import TypeVinService from "src/services/TypeVinService";

const familles = ref([]);
const typeVin = ref([]);

const getFamilles = () => {
  FamillesService.getFamilles().then((response) => {
    familles.value = response.data;
  });
};

const getTypeVin = () => {
  TypeVinService.getTypeVin().then((response) => {
    typeVin.value = response.data;
  });
};

const getTypeVinLibelle = (typeVinId) => {
  const vin = typeVin.value.find((element) => element.id === typeVinId);
  return vin?.libelle;
};

// Fonction pour sélectionner aléatoirement 5 vins
const selectRandomWines = () => {
  const shuffledWines = [...familles.value].sort(() => Math.random() - 0.5);
  return shuffledWines.slice(0, 5);
};

onMounted(() => {
  getFamilles();
  getTypeVin();
});

const randomWines = computed(() => selectRandomWines());
</script>

<style scoped>
/* Styles pour la section héroïque */
.hero-section {
  padding-top: 100px; /* Ajustez l'espacement en fonction de vos besoins */
  padding-bottom: 100px;
}

/* Styles pour le contenu héroïque */
.hero-content {
  padding: 20px;
}

/* Styles pour la typographie héroïque */
.hero-content h1 {
  font-family: "Playfair Display", serif;
}

.hero-content p {
  font-size: 18px;
}

/* Styles pour la section des fournisseurs */
.card-title {
  font-size: 20px;
  font-weight: bold;
}

.card-text {
  font-size: 16px;
}
</style>
