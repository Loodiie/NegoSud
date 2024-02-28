<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <RouterLink class="navbar-brand" to="/">
        <img
          src="/src/assets/icons/duck.png"
          alt="Logo"
          width="50"
          height="50"
          class="d-inline-block align-text-top"
        />
        Negosud
      </RouterLink>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarNavDropdown"
        aria-controls="navbarNavDropdown"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <RouterLink class="nav-link" to="/">Accueil</RouterLink>
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/allproducts"
              >Nos Produits</RouterLink
            >
          </li>
          <li class="nav-item">
            <RouterLink class="nav-link" to="/qui-sommes-nous"
              >À Propos</RouterLink
            >
          </li>
        </ul>
        <form class="d-flex">
          <input
            class="form-control me-2"
            type="search"
            placeholder="Rechercher un produit"
            aria-label="Search"
            v-model="searchTerm"
          />
          <button class="btn btn-outline-light" type="submit">
            Rechercher
          </button>
        </form>
      </div>
      <div>
        <RouterLink to="#" class="btn btn-outline-light me-2">
          <img
            src="/src/assets/icons/listeEnvie.png"
            alt="My Account"
            width="30"
            height="30"
          />
        </RouterLink>
        <RouterLink to="/cart" class="btn btn-outline-light me-2">
          <img
            src="/src/assets/icons/cart.png"
            alt="My Account"
            width="30"
            height="30"
          />
        </RouterLink>
        <RouterLink
          v-if="!isLoggedIn"
          to="/login"
          class="btn btn-outline-light"
        >
          Se Connecter
        </RouterLink>
        <RouterLink v-else to="/myaccount" class="btn btn-outline-light">
          <img
            src="/src/assets/icons/account.png"
            alt="My Account"
            width="30"
            height="30"
          />
          Mon Compte
        </RouterLink>
      </div>
    </div>
  </nav>
</template>

<script>
import { getLoggedInUserId } from "@/services/PersonnesService";

export default {
  computed: {
    isLoggedIn() {
      // Vérifie si un utilisateur est connecté en utilisant l'ID stocké
      return !!getLoggedInUserId();
    },
  },
};
</script>

<style scoped>
.navbar-brand {
  display: flex;
  align-items: center;
  color: #fff;
  text-decoration: none;
  font-size: 1.5rem;
}

.navbar-brand img {
  margin-right: 10px;
}

.navbar-nav .nav-link {
  color: #fff !important;
}

.form-control {
  background-color: #343a40 !important;
  color: #fff !important;
  border: 1px solid #fff !important;
}

/* Couleur du placeholder */
.form-control::placeholder {
  color: #fff !important;
}

.btn-outline-light {
  color: #fff !important;
  border-color: #fff !important;
}

.btn-outline-light:hover {
  background-color: #fff !important;
  color: #343a40 !important;
}

@media (max-width: 991.98px) {
  .navbar-collapse {
    background-color: #343a40;
  }
}
</style>
