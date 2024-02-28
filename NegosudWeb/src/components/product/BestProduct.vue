<template>
    <div>
        <div class="row row-cols-1 row-cols-md-5 g-4 p-4">
            <div v-for="famille in randomFamilles" :key="famille.id" class="col">
                <div class="card h-100">
                    <img src="/src/assets/img/card_product.jpeg" class="card-img-top" alt="Article Image">
                    <span class="position-absolute top-0 start-100 translate-middle badge rounded bg-danger">{{ famille.annee }}</span>
                    <div class="card-body">
                        <h5 class="card-title">{{ famille && famille.libelle }}</h5>
                        <p class="card-text">{{ famille && famille.typeVin && famille.typeVin.libelle }}</p>
                        <p class="card-text" v-if="famille && famille.fournisseur">Fournisseur {{ famille.fournisseur.nom }}</p>
                    </div>
                    <div class="card-footer d-flex justify-content-end">
                        <router-link v-if="famille && famille.famille_id" :to="{ name: 'produit-details', params: { id: famille.famille_id }}" class="btn btn-primary">Voir le produit</router-link>
                    </div>
                </div>
            </div>
        </div>
        <div v-if="familles.length === 0">Aucun article disponible.</div>
    </div>
</template>

<script>
import FamillesService from '@/services/FamillesService';

export default {
    name: 'FamilleList',
    data() {
        return {
            familles: [],
        }
    },
    methods: {
        getFamilles() {
            FamillesService.getFamilles().then((response) => {
                console.log('Données d\'articles reçues :', this.familles);
                this.familles = response.data;
            });
        },

        shuffleArray(array) {
            let currentIndex = array.length,
                randomIndex;

            while (currentIndex !== 0) {
                randomIndex = Math.floor(Math.random() * currentIndex);
                currentIndex--;

                [array[currentIndex], array[randomIndex]] = [
                    array[randomIndex],
                    array[currentIndex],
                ];
            }

            return array;
        },
    },
    created() {
        this.getFamilles()
    },
    computed: {
        randomFamilles() {
            const shuffledFamilles = this.shuffleArray(this.familles);
            return shuffledFamilles.slice(0, 5);
        },
    }
}
</script>
