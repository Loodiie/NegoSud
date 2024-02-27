<template>
  <div class="accordion" id="accordionPanelsStayOpenExample">
    <div class="accordion-item">
      <h2 class="accordion-header" id="panelsStayOpen-headingOne">
        <button
          class="accordion-button"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#panelsStayOpen-collapseOne"
          aria-expanded="true"
          aria-controls="panelsStayOpen-collapseOne"
        >
          Domaines
        </button>
      </h2>
      <div
        id="panelsStayOpen-collapseOne"
        class="accordion-collapse collapse show"
        aria-labelledby="panelsStayOpen-headingOne"
      >
        <div class="accordion-body">
          <ul>
            <li
              v-for="fournisseur in fournisseurs"
              v-bind:key="fournisseur.id"
              class="list-group-item"
            >
              <input
                class="form-check-input me-1"
                type="checkbox"
                v-model="selectedFournisseurs"
                :value="fournisseur.nom"
                @change="selectedFournisseurs"
              />
              {{ fournisseur.nom }}
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="accordion-item">
      <h2 class="accordion-header" id="panelsStayOpen-headingTwo">
        <button
          class="accordion-button"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#panelsStayOpen-collapseTwo"
          aria-expanded="true"
          aria-controls="panelsStayOpen-collapseTwo"
        >
          Famille
        </button>
      </h2>
      <div
        id="panelsStayOpen-collapseTwo"
        class="accordion-collapse collapse show"
        aria-labelledby="panelsStayOpen-headingTwo"
      >
        <div class="accordion-body">
          <ul>
            <li
              v-for="typeVin in uniqueTypeVin"
              v-bind:key="typeVin"
              class="list-group-item"
            >
              <input
                class="form-check-input me-1"
                type="checkbox"
                value=""
                aria-label="..."
              />
              {{ typeVin }}
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="accordion-item">
      <h2 class="accordion-header" id="panelsStayOpen-headingThree">
        <button
          class="accordion-button"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#panelsStayOpen-collapseThree"
          aria-expanded="true"
          aria-controls="panelsStayOpen-collapseThree"
        >
          Année
        </button>
      </h2>
      <div
        id="panelsStayOpen-collapseThree"
        class="accordion-collapse collapse show"
        aria-labelledby="panelsStayOpen-headingThree"
      >
        <div class="accordion-body">
          <ul>
            <li
              v-for="annees in uniqueAnnee"
              v-bind:key="annees"
              class="list-group-item"
            >
              <input
                class="form-check-input me-1"
                type="checkbox"
                value=""
                aria-label="..."
              />
              {{ annees }}
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FamillesServices from "@/services/FamillesService";
import FournisseursService from "@/services/FournisseursService";

export default {
  name: "AllFilters",
  props: {
    selectedFilters: Object,
    applyFilters: Function,
  },
  data() {
    return {
      familles: [],
      fournisseurs: [],
      selectedFournisseurs: [],
      uniqueAnnee: [],
      uniqueTypeVin: [],
      minPrince: null,
      maxPrice: null,
    };
  },
  methods: {
    getFamilles() {
      FamillesServices.getFamilles().then((response) => {
        this.familles = response.data;
        this.getUniqueAnnee();
        this.getUniqueTypeVin();
      });
    },
    getFournisseurs() {
      FournisseursService.getFournisseurs().then((response) => {
        this.fournisseurs = response.data;
      });
    },
    getUniqueAnnee() {
      const annees = new Set();
      for (let famille of this.familles) {
        annees.add(famille.annee);
      }
      this.uniqueAnnee = Array.from(annees);
      this.uniqueAnnee.sort((a, b) => a - b);
    },
    getUniqueTypeVin() {
      const typeVin = new Set();
      for (let famille of this.familles) {
        typeVin.add(famille.typeVin.libelle);
      }
      this.uniqueTypeVin = Array.from(typeVin);
      this.uniqueTypeVin.sort();
    },
    filterFournisseurs() {
      this.familles = this.familles.filter((famille) => {
        console.log(this.selectedFournisseurs);
        return this.selectedFournisseurs.includes(famille.fournisseur.nom);
      });
    },
  },
  created() {
    this.getFamilles(),
      this.getFournisseurs(),
      this.getUniqueAnnee(),
      this.getUniqueTypeVin();
    this.filterFournisseurs();
  },
};
</script>
