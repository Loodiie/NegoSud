<script setup>
    import HeaderWeb from '../components/layout/HeaderWeb.vue'
    import FooterWeb from '../components/layout/FooterWeb.vue'
    import AllFournisseurs from '../components/suppliers/AllFournisseurs.vue'
</script>

<template>
    <HeaderWeb />

    <h2 class = "text-center">Qui sommes-nous ?</h2><br>
    <div class = "m-4">Lorem ipsum dolor sit amet consectetur adipisicing elit. Reiciendis cupiditate ducimus veniam quasi quos iusto, ipsam harum quas laboriosam commodi consequuntur blanditiis veritatis totam dolorum dignissimos perferendis, nemo eius aperiam. Lorem ipsum dolor sit amet consectetur adipisicing elit. Minus expedita iste sit illum ad natus numquam assumenda tenetur quidem quia ab reiciendis accusantium ducimus nam similique, facere culpa ea consectetur? Lorem ipsum dolor, sit amet consectetur adipisicing elit. Animi voluptate esse blanditiis officiis delectus soluta eaque aliquam quia, officia, hic nulla autem ullam tempore distinctio architecto unde repellat ut placeat! Lorem ipsum, dolor sit amet consectetur adipisicing elit. Perferendis, similique sequi quae, optio consectetur voluptate sit quo corporis voluptates ullam neque repellendus deleniti cum repellat rerum at consequuntur maxime nisi. Lorem ipsum dolor sit amet consectetur adipisicing elit. Molestias numquam consequatur fuga corrupti quam ea magnam, aut dicta enim beatae tempore incidunt hic, fugiat tempora. Odit voluptas possimus deserunt voluptatibus.</div>

    <h2 class = "text-center">Tous nos partenaires</h2>
    <AllFournisseurs />

    <FooterWeb />
</template>

<script>
import FournisseursService from '@/services/FournisseursService';
    export default {
        name: 'fournisseursList',
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