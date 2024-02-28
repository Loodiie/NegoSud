<template>
      <div class="container mt-5 min-vh-100">
            <h2>Votre Panier</h2>
            <div v-if="lengthCart === 0">
                <p>Votre panier est vide.</p>
            </div>
            <div v-else>
                <div class="card mb-3" v-for="(item, index) in cart" :key="index">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img class="img-fluid rounded-start" src="/src/assets/img/card_product.jpeg" alt="...">
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">{{ item.libelle }}</h5>
                                <p class="card-text">{{ item.description }}</p>
                                <p class="card-text"><small class="text-muted">{{ item.prix_unit }}€</small></p>
                                <p class="card-text">Quantité: {{ item.quantity }}  </p>
                                <p class="card-text">Total: {{ getTotalPrice(item).toFixed(2) }}€</p>
                                <button @click="deleteFromCart(item)" class="btn btn-danger">Supprimer</button> 
                            </div>
                        </div>
                    </div>
                </div>
                <div class="text-end mb-5">
                    <button @click="clearCart()" class="btn btn-secondary ">Vider le panier</button>
                </div>
            </div>
        </div>
</template>

<script setup>
import { useCartStore } from '@/stores/cart';
import { watch, ref } from 'vue';

    //Objet destructuré
    const {cart, deleteFromCart, clearCart} = useCartStore()
    
    const lengthCart = ref(cart.length)
    watch(cart, ()=>{
        lengthCart.value = cart.length
    })

    const getTotalPrice = (item) => {
        return item.prix_unit * item.quantity;
    };
    
</script>