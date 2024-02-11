<script setup>
import HeadersWeb from "../components/layouts/HeadersWeb.vue";
</script>

<template>
  <q-layout view="hHh Lpr lFf">
    <HeadersWeb />

    <!-- Content -->
    <q-page-container>
      <h2 class="text-center p-4" id="fournisseur">
        Retrouvez tous nos fournisseurs
      </h2>
      <q-page-section class="container-fluid p-4">
        <q-container>
          <q-row>
            <q-col
              cols="12"
              md="4"
              v-for="fournisseur in fournisseurs"
              :key="fournisseur.id"
            >
              <q-card>
                <q-img
                  src="/src/assets/img/vignoble.png"
                  class="card-img-top"
                  alt="Fournisseur"
                />
                <q-card-section>
                  <h5 class="card-title">{{ fournisseur.nom }}</h5>
                  <p class="card-text">
                    Découvrez une sélection exclusive de vins proposée par
                    {{ fournisseur.nom }}.
                  </p>
                  <p class="card-text">
                    Contactez-les directement au {{ fournisseur.telephone }}.
                  </p>
                  <q-btn
                    color="primary"
                    label="Découvrez leurs produits"
                    class="mx-auto"
                  />
                </q-card-section>
              </q-card>
            </q-col>
          </q-row>
        </q-container>
      </q-page-section>
    </q-page-container>

    <!-- Footer -->
    <q-footer>
      <FooterWeb />
    </q-footer>
  </q-layout>
</template>

<script>
import FournisseursService from "../services/FournisseursService";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "fournisseurs",
  data() {
    return {
      fournisseurs: [],
    };
  },
  methods: {
    getFournisseurs() {
      FournisseursService.getFournisseurs().then((response) => {
        this.fournisseurs = response.data;
      });
    },
  },
  created() {
    this.getFournisseurs();
  },
};
</script>

<style scoped>
.hero-section {
  padding-top: 100px;
  padding-bottom: 100px;
}

.hero-content {
  padding: 20px;
}

.hero-content h1 {
  font-family: "Playfair Display", serif;
}

.hero-content p {
  font-size: 18px;
}

.card-title {
  font-size: 20px;
  font-weight: bold;
}

.card-text {
  font-size: 16px;
}
</style>
