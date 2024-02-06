import { createApp } from "vue";
import VueRouter from "vue-router";
import IndexPage from "../pages/IndexPage.vue";

createApp.use(VueRouter);

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/home",
      name: "home",
      component: IndexPage,
    },
  ],
});

export default router;
