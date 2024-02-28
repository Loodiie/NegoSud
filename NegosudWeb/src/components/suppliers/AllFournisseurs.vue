<template>
  <div class="row row-cols-1 row-cols-md-3 g-4 p-4">
    <div v-for="fournisseur in fournisseurs" :key="fournisseur.id" class="col">
      <div class="card border-0 shadow">
        <img
          src="/src/assets/img/vignoble_card.jpg"
          class="card-img-top"
          alt="..."
        />
        <div class="card-body">
          <h5 class="card-title">{{ fournisseur.nom }}</h5>
          <p class="card-text">{{ fournisseur.description }}</p>
        </div>
        <div class="card-footer bg-transparent border-0">
          <small class="text-muted"
            >Contactez-les directement au {{ fournisseur.telephone }}</small
          ><br />
          <small class="text-muted"
            >Ou envoyez-leur un mail à
            <a :href="'mailto:' + fournisseur.mail">{{
              fournisseur.mail
            }}</a></small
          >
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FournisseursService from "@/services/FournisseursService";

export default {
  name: "FournisseursList",
  data() {
    return {
      fournisseurs: [],
    };
  },
  methods: {
    async getFournisseurs() {
      try {
        const response = await FournisseursService.getFournisseurs();
        this.fournisseurs = response.data;
      } catch (error) {
        console.error(error);
      }
    },
  },
  created() {
    this.getFournisseurs();
  },
};
</script>

<style scoped>
.card {
  transition: transform 0.2s;
}

.card:hover {
  transform: translateY(-5px);
}
</style>
