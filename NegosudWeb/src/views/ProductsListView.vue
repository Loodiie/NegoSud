<script setup>
import HeaderWeb from '../components/layout/HeaderWeb.vue'
import FooterWeb from '../components/layout/FooterWeb.vue'
</script>
<template>
    <div>
      <HeaderWeb />
      <div class="container-fluid">
        <div class="row">
          <!-- Sidebar with filters -->
          <div class="col-3">
            <h2 class="text-center mb-4">Filtres</h2>
            <!-- Boutons pour trier par nom et par prix -->
            <div class="d-flex flex-column flex-md-row justify-content-between">
              <div class="mb-3 mb-md-0">
                  <button class="btn btn-outline-danger w-100" @click="sortByNameAsc">Trier par nom croissant</button>
                  <button class="btn btn-outline-danger w-100" @click="sortByNameDesc">Trier par nom décroissant</button>
              </div>
              <div>
                  <button class="btn btn-outline-danger w-100" @click="sortByPriceAsc">Trier par prix croissant</button>
                  <button class="btn btn-outline-danger w-100" @click="sortByPriceDesc">Trier par prix décroissant</button>
              </div>
            </div>
            <div class="accordion" id="accordionPanelsStayOpenExample">
              <!-- Supplier filter -->
              <div class="accordion-item">
                <h2 class="accordion-header" id="panelsStayOpen-headingOne">
                  <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseOne" aria-expanded="true" aria-controls="panelsStayOpen-collapseOne">
                    Domaines
                  </button>
                </h2>
                <div id="panelsStayOpen-collapseOne" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingOne">
                  <div class="accordion-body">
                    <ul>
                      <li v-for="fournisseur in fournisseurs" :key="fournisseur.id" class="list-group-item">
                        <input class="form-check-input me-1" type="checkbox" v-model="selectedfournisseur" :value="fournisseur.nom" @change="filterFamilles">
                        {{ fournisseur.nom }}
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <!-- Families filter -->
              <div class="accordion-item">
                <h2 class="accordion-header" id="panelsStayOpen-headingFive">
                  <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseFive" aria-expanded="true" aria-controls="panelsStayOpen-collapseFive">
                    Type vin
                  </button>
                </h2>
                <div id="panelsStayOpen-collapseFive" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingFive">
                  <div class="accordion-body">
                    <ul>
                      <li v-for="typeVin in uniqueTypeVin" :key="typeVin" class="list-group-item">
                        <input class="form-check-input me-1" type="checkbox" v-model="selectedTypeVin" :value="typeVin.libelle" @change="filterFamilles">
                        {{ typeVin.libelle }}
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <!-- Year filter -->
              <div class="accordion-item">
                <h2 class="accordion-header" id="panelsStayOpen-headingTwo">
                  <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseTwo" aria-expanded="true" aria-controls="panelsStayOpen-collapseTwo">
                    Année
                  </button>
                </h2>
                <div id="panelsStayOpen-collapseTwo" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingTwo">
                  <div class="accordion-body">
                    <ul>
                      <li v-for="annee in uniqueAnnee" :key="annee" class="list-group-item">
                        <input class="form-check-input me-1" type="checkbox" v-model="selectedAnnee" :value="annee" @change="filterFamilles">
                        {{ annee }}
                      </li>
                    </ul>
                  </div>
                </div>
              </div>
              <!-- Price filter -->
              <div class="accordion-item">
                <h2 class="accordion-header" id="panelsStayOpen-headingFour">
                  <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#panelsStayOpen-collapseFour" aria-expanded="true" aria-controls="panelsStayOpen-collapseFour">
                    Prix de la bouteille
                  </button>
                </h2>
                <div id="panelsStayOpen-collapseFour" class="accordion-collapse collapse show" aria-labelledby="panelsStayOpen-headingFour">
                  <div class="accordion-body">
                    <div class="input-group mb-3">
                      <span class="input-group-text">Prix min</span>
                      <input type="number" class="form-control" v-model="minPrice">
                    </div>
                    <div class="input-group mb-3">
                      <span class="input-group-text">Prix max</span>
                      <input type="number" class="form-control" v-model="maxPrice">
                    </div>
                    <button class="btn btn-primary" @click="filterFamilles">OK</button>
                  </div>
                </div>
              </div>
            </div>
          </div>


          <div class="col-9">
            <div class="d-flex flex-column align-items-center container-fluid">
              <h2 class="text-center mb-4">Tous nos produits</h2>
              <div class="row row-cols-1 row-cols-md-4 g-4">
                <div v-for="famille in familles && typeVin in uniqueTypeVin && fournisseur in uniqueFournisseurs" :key="famille.id && typeVin && fournisseur" class="col">
                  <div class="card h-100">
                    <img src="/src/assets/img/card_product.jpeg" class="card-img-top" alt="...">
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded bg-danger">{{ famille.annee }}</span>
                    <div class="card-body">
                      <h5 class="card-title"> {{ famille && famille.libelle }} - {{ famille && famille.famille_id }} </h5>
                      <p class="card-text">{{ famille && famille.fournisseur && famille.fournisseur.nom }}</p>
                      <p class="card-text text-center"><em>{{ famille.typeVin.libelle }}</em></p>
                    </div>
                    <div class="card-footer d-flex justify-content-around align-items-center">
                      <h5 class="">{{ famille.articlePrice.toFixed(2) }}€</h5>
                      <router-link :to="{ name: 'produit-details', params: { id: famille.famille_id }}" class="btn btn-primary">Voir le produit</router-link>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <FooterWeb />
    </div>
  </template>
  
  <script>
  import FamillesService from '@/services/FamillesService';
  import FournisseursService from '@/services/FournisseursService';
  import TypeVinService from '@/services/TypeVinService';
  
  export default {
    name: 'ProductListView',
    components: {
      HeaderWeb,
      FooterWeb
    },
    data() {
      return {
        familles: [],
        fournisseurs: [],
        uniqueAnnee: [],
        uniqueTypeVin: [],
        uniqueFournisseurs: [],
        selectedFournisseurs: [],
        selectedAnnee: [],
        selectedTypeVin: [],
        minPrice: 0,
        maxPrice: 150,
        filteredAndSortedFamilles: []
      }
    },
    computed: {
      filteredFamilles() {
        let filteredFamilles = this.familles;
  
        if (
          (this.minPrice !== null && this.maxPrice !== null) ||
          (this.selectedFournisseurs.length > 0) ||
          (this.selectedAnnee.length > 0) ||
          (this.selectedTypeVin.length > 0)
        ) {
          console.log("coucou")
          filteredFamilles = filteredFamilles.filter(famille => {
            let priceCondition = true;
            if (this.minPrice !== null && this.maxPrice !== null) {
              priceCondition = famille.prix_unit >= this.minPrice && famille.prix_unit <= this.maxPrice;
            }
  
            let fournisseursCondition = true;
            if (this.selectedFournisseurs.length > 0) {
              fournisseursCondition = this.selectedFournisseurs.includes(famille.fournisseur.nom);
            }
  
            let anneeCondition = true;
            if (this.selectedAnnee.length > 0) {
              anneeCondition = this.selectedAnnee.includes(famille.annee);
            }
  
            let typeVinCondition = true;
            if (this.selectedTypeVin.length > 0) {
              typeVinCondition = this.selectedTypeVin.includes(famille.typeVin.libelle);
            }
  
            return priceCondition && fournisseursCondition && anneeCondition  && typeVinCondition;
          });
        }
  
        this.filteredAndSortedFamilles = filteredFamilles;
        return this.filteredAndSortedFamilles;
      }
    },
    methods: {
      getFamilles() {
        FamillesService.getFamilles().then((response) => {
          this.familles = response.data;
          console.log('type:',  response.data)
          this.getUniqueAnnee();
          this.getUniqueTypeVin();
          this.getUniqueFournisseurs();
        });
      },
      getFournisseurs() {
        FournisseursService.getFournisseurs().then((response) => {
          this.fournisseurs = response.data;
        });
      },
      getUniqueAnnee() {
        const annee = new Set();
        for (let famille of this.familles) {
          annee.add(famille.annee);
        }
        this.uniqueAnnee = Array.from(annee);
        this.uniqueAnnee.sort((a, b) => a - b);
      },
      async getUniqueTypeVin() {
        this.uniqueTypeVin = (await TypeVinService.getTypeVin()).data;
        this.uniqueTypeVin.sort((a, b) => a.libelle - b.libelle);
      },
      async getUniqueFournisseurs(){
        console.log("ici:", (await FournisseursService.getFournisseurs()))
        this.uniqueFournisseurs = (await FournisseursService.getFournisseurs()).data
      },
      filterFamilles() {
        console.log("po:", this.filteredFamilles)
        return this.filteredFamilles;
      },
      sortByNameAsc() {
        console.log("Méthode sortByNameAsc() appelée.");
        this.filteredFamilles.sort((a, b) => a.libelle.localeCompare(b.libelle));
        this.filteredFamilles = [...this.filteredFamilles]; // Mettre à jour la liste des articles filtrés
      },
      sortByNameDesc() {
        console.log("Méthode sortByNameDesc() appelée.");
        this.filteredFamilles.sort((a, b) => b.libelle.localeCompare(a.libelle));
        this.filteredFamilles = [...this.filteredFamilles]; // Mettre à jour la liste des articles filtrés
      },
      sortByPriceAsc() {
        console.log("Méthode sortByPriceAsc() appelée.");
        this.filteredFamilles.sort((a, b) => a.prix_unit - b.prix_unit);
        this.filteredFamilles = [...this.filteredFamilles]; // Mettre à jour la liste des articles filtrés
      },
      sortByPriceDesc() {
        console.log("Méthode sortByPriceDesc() appelée.");
        this.filteredFamilles.sort((a, b) => b.prix_unit - a.prix_unit);
        this.filteredFamilles = [...this.filteredFamilles]; // Mettre à jour la liste des articles filtrés
      },
    },
    created() {
      this.getFamilles();
      this.getFournisseurs();
    }
  }
  </script>
  