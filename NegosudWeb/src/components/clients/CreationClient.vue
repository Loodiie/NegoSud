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
  
                  <form>

                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Créez votre compte</h5>

                    <div class="pt-1 mb-4 d-flex justify-content-between align-items-center">
                        <div class="form-outline">
                            <label class="form-label" for="nomCreation">Nom</label>
                            <input type="nom" id="nomCreation" class="form-control form-control-lg"/>
                        </div>
                        <div class="form-outline">
                            <label class="form-label" for="prenomCreation">Prénom</label>
                            <input type="prenom" id="prenomCreation" class="form-control form-control-lg"/>
                        </div>
                    </div>
  
                    <div class="form-outline mb-4">
                      <label class="form-label" for="mailCreation">Adresse e-mail</label>
                      <input type="mail" id="mailCreation" class="form-control form-control-lg"/>
                    </div>

                    <div class="form-outline mb-4">
                      <label class="form-label" for="telephoneCreation">Téléphone</label>
                      <input type="telephone" id="telephoneCreation" class="form-control form-control-lg"/>
                    </div>
  
                    <div class="form-outline mb-4">
                      <label class="form-label" for="passwordCreation">Mot de passe</label>
                      <input type="mdp" id="passwordCreation" class="form-control form-control-lg mb-4"/>
                    </div>
  
                    <div class="pt-1 mb-4 d-flex justify-content-around align-items-center">
                      <button id = "btnCreateAccount" class="btn btn-outline-danger" type="button">Créer votre compte</button>
                      <a type="button" class="btn btn-outline-danger" href = "/connexion" style="letter-spacing: 1px;">J'ai déjà un compte</a>
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
import PersonnesService from '@/services/PersonnesService';

export default {
  mounted() {
    document.getElementById('btnCreateAccount').addEventListener('click', this.createUser);
  },
  methods: {
    createPersonnes() {
      const nom = document.getElementById('nomCreation').value;
      const prenom = document.getElementById('prenomCreation').value;
      const telephone = document.getElementById('telephoneCreation').value;
      const mail = document.getElementById('mailCreation').value;
      const mdp = document.getElementById('passwordCreation').value;
      const employees = false;
      
      const userData = {
        nom: nom,
        prenom: prenom,
        telephone: telephone,
        mail: mail,
        mdp: mdp,
        employees: employees,
      };

      PersonnesService.createPersonnes(userData)
        .then(response => {
          console.log('Nouvel utilisateur créé avec succès :', response.data);
          alert('Votre compte a été créé avec succès !');
        })
        .catch(error => {
          console.error('Erreur lors de la création de l\'utilisateur :', error);
          alert('Une erreur est survenue lors de la création de votre compte. Veuillez réessayer plus tard.');
        });
    }
  }
}
</script>