import { createRouter, createWebHistory } from "vue-router";
import IndexPage from "../pages/IndexPage.vue";
import ListeProduits from "../pages/ListeProduits.vue";

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
  ],
});

export default router;
