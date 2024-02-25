<template>
  <q-layout view="hHh Lpr lFf">
    <HeadersWeb />
    <div>
      <h1>Mon compte</h1>

      <!-- Informations personnelles -->
      <div>
        <h2>Informations personnelles</h2>
        <p>Nom: {{ personne.nom }}</p>
        <p>Prénom: {{ personne.prenom }}</p>
        <p>Email: {{ personne.mail }}</p>
      </div>

      <!-- Historique des commandes -->
      <div>
        <h2>Historique des commandes</h2>
        <ul>
          <li v-for="commande in historiqueCommandes" :key="commande.id">
            <!-- Affiche les détails de la commande ici -->
          </li>
        </ul>
      </div>

      <!-- Options de gestion du compte -->
      <div>
        <h2>Gestion du compte</h2>
        <p>
          <router-link to="/modifier-informations"
            >Modifier mes informations</router-link
          >
        </p>
        <p>
          <router-link to="/modifier-mot-de-passe"
            >Modifier mon mot de passe</router-link
          >
        </p>
      </div>

      <!-- Déconnexion -->
      <div>
        <button @click="deconnexion">Se déconnecter</button>
      </div>
    </div>
  </q-layout>
</template>

<script>
import HeadersWeb from "src/components/layouts/HeadersWeb.vue";
import PersonnesService from "src/services/PersonnesService";
import axios from "axios";

export default {
  components: {
    HeadersWeb,
  },
  data() {
    return {
      personne: {},
    };
  },
  async mounted() {
    await this.getPersonnesDetails();
  },
  methods: {
    async getPersonnesDetails() {
      try {
        // Récupére le token depuis le local storage
        const token = localStorage.getItem("token");

        // Configurez les en-têtes pour inclure le token d'authentification
        const config = {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        };

        // Utilise le service pour récupérer les détails du compte de l'utilisateur
        const response = await axios.get(
          "http://localhost:29200/api/v1/personnes/connect",
          config
        );

        // Met à jour les données du composant avec les détails du compte
        this.personne = response.data;
      } catch (error) {
        console.error(
          "Erreur lors de la récupération des détails du compte:",
          error
        );
      }
    },

    deconnexion() {
      // Logique de déconnexion
      localStorage.removeItem("token"); // Supprime le token
      localStorage.removeItem("isLoggedIn"); // Supprime l'état de connexion

      // Redirige l'utilisateur vers la page de connexion
      this.$router.push("/home");
    },
  },
};
</script>

<style scoped>
/* Ajoutez vos styles CSS ici si nécessaire */
</style>
