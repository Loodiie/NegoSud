import { ref, watch, onMounted } from 'vue'
import { defineStore } from 'pinia'

export const useCartStore = defineStore('cart', () => {

  const cart = ref([])

  onMounted(() => {
    const itemCart = localStorage.getItem('itemCart')
    if(itemCart) cart.value = JSON.parse(itemCart);
  } )

  const addToCart = (item, quantity) => {
    const famille = cart.value.find((art)=> art.famille_id === item.famille_id)
    item.quantity = quantity
    if (!famille) cart.value.push(item)
    else {
      famille.quantity += quantity
    }
    alert('Article ajouté au panier !')
  }

  const deleteFromCart = (item)=>{
    console.log(item.famille_id, cart.value)
    cart.value = cart.value.filter((famille)=>famille.famille_id !== item.famille_id)
    alert('Article enlevé du panier !')
  }

  const clearCart = ()=> {
    cart.value = []
    alert('Le panier a été vidé !')
  }

  watch(() => cart.value, () => {
    localStorage.setItem('itemCart', JSON.stringify(cart.value))
  })

  return { cart, addToCart, deleteFromCart, clearCart }
})