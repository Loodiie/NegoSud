<template>
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col col-xl-10">
        <div class="card" style="border-radius: 1rem;">
          <div class="row g-0">
            <div class="col-md-6 col-lg-5 d-flex justify-content-center align-items-center">
              <img src="/src/assets/img/draw_wine.webp"
                alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
            </div>
            <div class="col-md-6 col-lg-7 d-flex align-items-center">
              <div class="card-body p-4 p-lg-5 text-black">

                <form @submit.prevent="login">

                  <div class="d-flex align-items-center mb-3 pb-1">
                    <a class="navbar-brand" href="/home">                
                        <img src="/src/assets/icons/logo_website.png" alt="" width="90" height="90" class="d-inline-block align-text-top">
                    </a>
                  </div>

                  <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Connectez-vous à votre compte</h5>
                  <p v-if="error" style="color: red;">{{ error }}</p>

                  <div class="d-flex align-items-center justify-content-center pb-4 fw-normal mb-3 pb-3">
                    <p class="mb-0 me-2" style="letter-spacing: 1px;" >Vous n'avez pas de compte ?</p>
                    <a href = "/creationdecompte" type="button" class="btn btn-outline-danger" style="letter-spacing: 1px;">Créer un compte</a>
                  </div>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="email">Adresse e-mail</label>
                    <input type="email" id="email" v-model="mail" required class="form-control form-control-lg"/>
                  </div>

                  <div class="form-outline mb-4">
                    <label class="form-label" for="password">Mot de passe</label>
                    <input type="password" id="password" v-model="password" required class="form-control form-control-lg mb-4"/>
                    <label class="form-label" for="passwordForgot">Mot de passe <a href = "/motdepasse">oublié ?</a></label>
                  </div>

                  <div class="pt-1 mb-4">
                    <button class="btn btn-dark btn-lg btn-block" type="submit">Se connecter</button>
                  </div>

                </form>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import PersonnesServices from '@/services/PersonnesService';
import { setLoggedInUserId } from '@/services/PersonnesService';

export default {
  data() {
    return {
      mail: '',
      mdp: '',
      error: null
    };
  },
  methods: {
    async login() {
      try {
        const { personne_id, token } = await PersonnesServices.loginUser(this.mail, this.mdp);
        
        // Stocker les informations de l'utilisateur dans le stockage local
        localStorage.setItem('personne_id', personne_id);
        localStorage.setItem('token', token);

        setLoggedInUserId(personne_id);
        console.log(personne_id);
        
        // Afficher une alerte pour indiquer une connexion réussie
        window.alert('Connexion réussie!');
        
        // Rediriger vers la page d'accueil
        this.$router.push({ name: 'MyAccount', params: { personne_id } });
      } catch (error) {
        // Gérer les erreurs (par exemple, afficher un message d'erreur à l'utilisateur)
        this.error = 'Adresse e-mail ou mot de passe incorrect';
        console.error('Erreur de connexion:', error.message);
      }
    }
  }
};
</script>
