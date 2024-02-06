const routes = [
  {
    path: "/",
    component: () => import("layouts/MainLayout.vue"),
    children: [{ path: "", component: () => import("pages/IndexPage.vue") }],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: "/:catchAll(.*)*",
    component: () => import("pages/ErrorNotFound.vue"),
  },
];

// export default routes

// import { createApp } from "vue";
// import VueRouter from "vue-router";
// import IndexPage from "../pages/IndexPage.vue";

// createApp.use(VueRouter);

// const router = createRouter({
//   history: createWebHistory(import.meta.env.BASE_URL),
//   routes: [
//     {
//       path: "/home",
//       name: "home",
//       component: IndexPage,
//     },
//   ],
// });

// export default router;
