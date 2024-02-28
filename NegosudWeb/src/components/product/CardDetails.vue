<template>
    <div class="container mt-5 mb-5 ">
        <div class="row custom-border-bottom">
            <div class="col-md-6">
                <img src="/src/assets/img/card_product.jpeg" alt="Bouteille de vin" class="img-fluid rounded">
            </div>
            <div class="col-md-6">
                <h2 class="mb-4">{{ famille.libelle }}</h2>
                <p class="mb-4">{{ famille.description }}</p>
                <p class="mb-4">{{ famille.prix_unit }}€</p>
                <p class="mb-4">Disponibilité : En stock</p>
                <form>
                    <div class="form-group mb-4">
                        <label for="quantity">Quantité :</label>
                        <input v-model="quantity" type="number" id="quantity" class="form-control" value="1" min="1">
                    </div>
                    <button type="button" @click="cartNego.addToCart(famille, quantity)" class="btn btn-primary btn-block">Ajouter au panier</button>
                </form>
            </div>
        </div>
        <div class="row mt-5">
            <div class="col-md-6 custom-border-right">
                <h2 class="text-center mb-4">{{ famille.fournisseur.nom }}</h2>
                <div class="text-center m-4">
                    <img src="/src/assets/img/vignoble_card.jpg" alt="Image en mode paysage" class="img-fluid" width="300" height="300">
                </div>
                <div class="mb-4">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla felis justo, ultricies eu turpis sit amet, suscipit luctus justo.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla felis justo, ultricies eu turpis sit amet, suscipit luctus justo.</p>
                </div>
            </div>
            <div class="col-md-6">
                <h2 class="text-center mb-4">{{ famille.typeVin.libelle }}</h2>
                <div class="text-center m-4">
                    <img src="/src/assets/img/vignoble_card_2.jpg" alt="Image en mode paysage" class="img-fluid" width="200" height="200">
                </div>
            </div>
        </div> 
    </div> 
</template>

<script>
import FamillesService from '@/services/FamillesService';
import { useCartStore } from '@/stores/cart';

export default {
    name: 'DetailFamillesView',
    data() {
        return {
            famille: {
                fournisseur: {
                    nom: ""
                },
                typeVin: {
                    libelle: ""
                }
            },
            cartNego: useCartStore(),
            quantity: 1
        };
    },
    created() {
        this.fetchFamilleDetails();
    },
    methods: {
        fetchFamilleDetails() {
            const famille_id = this.$route.params.id;
            FamillesService.getFamillesById(famille_id)
            .then(response => {
                this.famille = response.data;
                console.log(this.famille);
            })
            .catch(error => {
                console.error('Erreur lors de la récupération des détails du produit : ', error);
            });
        }
    }
};
</script>
