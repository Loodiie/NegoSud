<template>
  <div class="row row-cols-1 row-cols-md-4 g-4">
    <div v-for="famille in familles" :key="famille.id" class="col">
      <div class="card h-100">
        <img
          src="/src/assets/img/card_product.jpeg"
          class="card-img-top"
          alt="..."
        />
        <span
          class="position-absolute top-0 start-100 translate-middle badge rounded bg-danger"
          >{{ famille.annee }}</span
        >
        <div class="card-body">
          <h5 class="card-title">
            {{ famille.libelle }} - {{ famille.famille_id }}
          </h5>
          <p class="card-text">{{ famille.fournisseur.nom }}</p>
          <p class="card-text text-center">
            <em>{{ famille.typeVin.libelle }}</em>
          </p>
        </div>
        <div
          class="card-footer d-flex justify-content-around align-items-center"
        >
          <h5 class="">{{ famille.articlePrice.toFixed(2) }}€</h5>
          <router-link
            :to="{
              name: 'produit-details',
              params: { id: famille.famille_id },
            }"
            class="btn btn-primary"
            >Voir le produit</router-link
          >
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FamillesService from "@/services/FamillesService";

export default {
  name: "ProductCard",
  props: {
    selectedFilters: Object,
  },
  data() {
    return {
      familles: [],
    };
  },
  computed: {
    filteredFamilles() {
      let filteredFamilles = this.familles;
      if (this.selectedFilters) {
        if (
          this.selectedFilters.fournisseurs &&
          this.selectedFilters.fournisseurs.length > 0
        ) {
          filteredFamilles = filteredFamilles.filter((famille) =>
            this.selectedFilters.fournisseurs.includes(famille.fournisseurs.nom)
          );
        }
      }
      return filteredFamilles;
    },
  },
  methods: {
    getFamilles() {
      FamillesService.getFamilles().then((response) => {
        this.familles = response.data;
      });
    },
  },
  created() {
    this.getFamilles();
  },
};
</script>
