<template>
    <div  class="row row-cols-1 row-cols-md-3 g-4 p-4" >
        <div v-for = "fournisseur in fournisseurs" v-bind:key = "fournisseur.id" class="col">
            <div class="card">
                <img src="/src/assets/img/vignoble_card.jpg" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title">{{ fournisseur.nom }}</h5>
                    <p class="card-text">Lorem ipsum, dolor sit amet consectetur adipisicing elit. Sunt voluptatibus dignissimos saepe a doloribus dolorem facilis nesciunt officiis harum itaque maxime unde pariatur modi, accusamus, cum, voluptates tempora possimus. Minus.</p>
                    <p class="card-text"><small class="text-muted">Contactez les directement au {{  fournisseur.telephone }}</small></p>
                    <p class="card-text"><small class="text-muted">Ou envoyez leur un mail à {{  fournisseur.mail }}</small></p>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import FournisseursService from '@/services/FournisseursService';
    export default {
        name: 'FournisseursList',
        data() {
            return {
                fournisseurs : []
            }
        },
        methods: {
            getFournisseurs() {
                FournisseursService.getFournisseurs().then((response) => {
                    this.fournisseurs = response.data;
                });
            }
        },
        created() {
            this.getFournisseurs()

        }
    }
</script>