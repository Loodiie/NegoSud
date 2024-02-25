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

      <img
        src="/src/assets/img/duck.png"
        alt="Logo"
        style="height: 40px; margin-right: 10px"
      />

      <q-toolbar-title class="q-ml-sm">
        <span class="title">Negosud</span>
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

      <q-btn class="q-ml-md" dense color="primary" icon="shopping_basket" />

      <q-btn
        class="q-ml-md"
        dense
        color="primary"
        icon="notifications_active"
      />
      <q-btn
        v-if="!isLoggedIn"
        class="q-ml-md"
        dense
        color="primary"
        label="Connection"
        @click="openLoginDialog()"
      />
      <q-btn
        v-if="!isLoggedIn"
        class="q-ml-md"
        dense
        color="primary"
        label="Inscription"
        @click="openInscriptionDialog()"
      />
      <q-btn
        v-if="isLoggedIn"
        class="q-ml-md"
        dense
        color="primary"
        label="Mon compte"
        to="/myAccount"
      />
      <q-btn
        v-if="isLoggedIn"
        class="q-ml-md"
        dense
        color="primary"
        label="Deconnexion"
        @click="deconnexion()"
        to="/home"
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
          <q-icon name="allproducts" />
        </q-item-section>
        <q-item-section>Nos produits</q-item-section>
      </q-item>
      <q-item clickable to="/partners">
        <q-item-section avatar>
          <q-icon name="partners" />
        </q-item-section>
        <q-item-section>Nos partenaires</q-item-section>
      </q-item>
    </q-list>
  </q-drawer>
  <q-dialog v-model="showLoginDialog">
    <q-card>
      <q-card-section class="text-center">
        <h4 class="text-primary">Connexion</h4>
      </q-card-section>

      <q-card-section>
        <!-- Formulaire de connexion -->
        <q-form @submit="login">
          <q-input outlined v-model="personne.mail" label="Email" />
          <q-input
            outlined
            v-model="personne.mdp"
            label="Mot de passe"
            type="password"
          />
          <q-btn color="primary" label="Se connecter" type="submit" />
          <q-btn
            color="primary"
            label="Annuler"
            type="button"
            @click="closeInscriptionDialog()"
          />
        </q-form>
      </q-card-section>
    </q-card>
  </q-dialog>

  <!-- Formulaire d'inscription -->
  <q-dialog v-model="showInscriptionDialog">
    <q-card>
      <q-card-section class="text-center">
        <h4 class="text-primary">Inscription</h4>
      </q-card-section>
      <q-card-section>
        <q-form @submit="register">
          <q-input outlined v-model="personne.nom" label="Nom" />
          <q-input outlined v-model="personne.prenom" label="Prénom" />
          <q-input outlined v-model="personne.mail" label="Email" />
          <q-input
            outlined
            v-model="personne.mdp"
            label="Mot de passe"
            type="password"
          />
          <q-input
            outlined
            v-model="personne.mdpConfirme"
            label="Mot de passe"
            type="password"
          />
          <q-btn color="primary" label="S'inscrire" type="submit" />
        </q-form>
      </q-card-section>
    </q-card>
  </q-dialog>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";
export default {
  components: {},
  data() {
    return {
      leftDrawerOpen: false,
      search: "",
      showLoginDialog: ref(false),
      showInscriptionDialog: ref(false),
      isLoggedIn: localStorage.getItem("isLoggedIn") === "true",
      personne: {
        nom: "",
        prenom: "",
        mail: "",
        mdp: "",
        mdpConfirme: "",
      },
    };
  },
  methods: {
    openLoginDialog() {
      this.showLoginDialog = true;
    },
    openInscriptionDialog() {
      this.showInscriptionDialog = true;
    },
    closeLoginDialog() {
      this.showLoginDialog = false;
    },
    closeInscriptionDialog() {
      this.showInscriptionDialog = false;
    },
    async login() {
      try {
        const response = await axios.post(
          "http://localhost:29200/api/v1/personnes/connect",
          this.personne
        );

        if (response.data && response.data.token) {
          // Connexion réussie, enregistrez le token dans le local storage
          localStorage.setItem("token", response.data.token);
          this.isLoggedIn = true;
          localStorage.setItem("isLoggedIn", "true");

          // Ferme la boîte de dialogue de connexion
          this.showLoginDialog = false;

          // Redirige l'utilisateur vers la page d'accueil
          this.$router.push("/home");
        } else {
          // Affiche un message d'erreur si aucun token n'est retourné
          alert("Email ou mot de passe incorrect.");
        }
      } catch (error) {
        console.error("Erreur de connexion:", error.response.data);
        alert("Erreur de connexion.");
      }
      console.log("personne:", localStorage);
    },
    async register() {
      // Vérifier si les mots de passe correspondent
      if (this.personne.mdp !== this.personne.mdpConfirme) {
        alert("Les mots de passe ne correspondent pas.");
        return; // Arrêter l'exécution de la méthode
      }

      try {
        const response = await axios.post(
          "http://localhost:29200/api/v1/personnes",
          {
            nom: this.personne.nom,
            prenom: this.personne.prenom,
            mail: this.personne.mail,
            mdp: this.personne.mdp,
          },
          {
            headers: {
              "Content-Type": "application/json",
            },
          }
        );
        // Inscription réussie
        console.log("Inscription réussie:", response.data);
        this.showInscriptionDialog = false; // Ferme la boîte de dialogue d'inscription
        this.isLoggedIn = true;
        localStorage.setItem("isLoggedIn", "true");
        // Affiche un message de succès à l'utilisateur
        alert("Inscription réussie !");
      } catch (error) {
        // Erreur lors de l'inscription
        console.error("Erreur lors de l'inscription:", error.response.data);
        alert("Erreur lors de l'inscription. Veuillez réessayer.");
      }
    },
    deconnexion() {
      // Logique de déconnexion
      localStorage.removeItem("isLoggedIn"); // Supprimez l'état de connexion
      localStorage.removeItem("user"); // Supprimez les détails de l'utilisateur
      isLoggedIn = false;
      // Redirigez l'utilisateur vers la page de connexion
      this.$router.push("/home");
    },
  },
};
</script>

<style scoped>
.title {
  font-family: "Helvetica Neue", sans-serif;
  font-size: 24px;
  font-weight: bold;
}

.q-btn {
  font-family: "Helvetica Neue", sans-serif;
}
</style>
