<template>
  <q-header elevated class="bg-white text-primary">
    <q-toolbar>
      <q-btn
        flat
        dense
        @click="leftDrawerOpen = !leftDrawerOpen"
        aria-label="Menu"
        icon="menu"
      />

      <q-toolbar-title>
        <q-avatar>
          <!-- <img src="/src/components/icons/logo_website.png" alt="Logo" /> -->
        </q-avatar>
        <span class="q-ml-sm">Negosud</span>
      </q-toolbar-title>

      <q-space />

      <q-input
        filled
        dense
        debounce="300"
        v-model="search"
        placeholder="Search"
      >
        <template v-slot:append>
          <q-icon name="search" />
        </template>
      </q-input>

      <q-btn class="q-ml-md" dense color="primary" icon="shopping_cart" />
      <q-btn class="q-ml-md" dense color="primary" icon="notifications" />
      <q-btn
        class="q-ml-md"
        dense
        color="primary"
        label="Sign in"
        @click="openLoginDialog"
      />
      <q-btn
        class="q-ml-md"
        dense
        color="primary"
        label="Sign up"
        @click="openLoginDialog"
      />
    </q-toolbar>
  </q-header>

  <q-drawer v-model="leftDrawerOpen" show-if-above bordered>
    <q-list>
      <q-item-label header class="text-weight-bold">Menu</q-item-label>
      <q-item clickable exact to="/home">
        <q-item-section avatar>
          <q-icon name="home" />
        </q-item-section>
        <q-item-section>Accueil</q-item-section>
      </q-item>
      <q-item clickable to="/allproducts">
        <q-item-section avatar>
          <q-icon name="list" />
        </q-item-section>
        <q-item-section>Nos produits</q-item-section>
      </q-item>
      <q-item clickable to="/home/#supplier">
        <q-item-section avatar>
          <q-icon name="store" />
        </q-item-section>
        <q-item-section>Nos partenaires</q-item-section>
      </q-item>
      <q-item clickable exact to="/home/#wines">
        <q-item-section avatar>
          <q-icon name="local_drink" />
        </q-item-section>
        <q-item-section>Nos familles de vin</q-item-section>
      </q-item>
    </q-list>
  </q-drawer>
</template>

<script>
export default {
  data() {
    return {
      leftDrawerOpen: false,
      search: "",
    };
  },
  methods: {
    openLoginDialog() {
      // Doit être fait l'appel au coponent de la dialogue de connexion
    },
  },
};
</script>
