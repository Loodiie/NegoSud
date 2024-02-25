import { createRouter, createWebHistory } from "vue-router";
import IndexPage from "../pages/IndexPage.vue";
import ListeProduits from "../pages/ListeProduits.vue";
import ListePartenaires from "../pages/ListePartenaires.vue";
import MonCompte from "../pages/MonCompte.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/home",
      name: "home",
      component: IndexPage,
    },
    {
      path: "/allproducts",
      name: "allproducts",
      component: ListeProduits,
    },
    {
      path: "/partners",
      name: "partners",
      component: ListePartenaires,
    },
    {
      path: "/myAccount",
      name: "myAccount",
      component: MonCompte,
    },
  ],
});

export default router;
