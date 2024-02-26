import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ContactView from '../views/ContactView.vue'
import ProductsListView from '../views/ProductsListView.vue'
import ConnexionView from '../views/ConnexionView.vue'
import CreationView from '../views/CreationView.vue'
import DetailProductView from '../views/DetailProductView.vue'
import ForgotPassView from '../views/ForgotPassView.vue'
import SearchResultView from '../views/SearchResultView.vue'
import LegalView from '../views/LegalView.vue'
import RGPDView from '../views/RGPDView.vue'
import WhoAreYou from '../views/WhoAreYou.vue'
import ShoppingCartView from '../views/ShoppingCartView.vue'
import MyAccountView from '../views/MyAccountView.vue'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: "/allproducts",
      name: 'allproducts',
      component: ProductsListView
    },
    {
      path: "/contact",
      name: "contact",
      component: ContactView
    },
    {
      path: "/qui-sommes-nous",
      name: "qui sommes nous",
      component: WhoAreYou
    },
    {
      path: "/connexion",
      name: "connexion",
      component: ConnexionView
    },
    {
      path: "/creationdecompte",
      name: "creation de compte",
      component: CreationView
    },
    {
      path: "/produits/:id",
      name: "produit-details",
      component: DetailProductView
    },
    {
      path: "/motdepasse",
      name: 'mot-de-passe',
      component: ForgotPassView
    },
    {
      path: '/search-results/:searchTerm',
      name: 'SearchResultView',
      component: SearchResultView
    },
    {
      path: '/mentionslegales',
      name: 'LegalView',
      component: LegalView
    },
    {
      path: '/RGPD',
      name: 'RGPDView',
      component: RGPDView
    },
    {
      path: '/panier',
      name: 'Panier',
      component: ShoppingCartView
    },
    {
      path: "/MyAccount/:personne_id?",
      name: "MyAccount",
      component: MyAccountView
    }
  ]
})

export default router
