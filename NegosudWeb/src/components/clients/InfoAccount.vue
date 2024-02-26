<template>
    <div class="container py-5 h-100 min-vh-100">
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
                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Vos informations de compte</h5>
                    <div v-if="personne">
                        <div class="pt-1 mb-4 flex justify-content-start align-items-center">
                            <div>
                                <div class="m-2">
                                    <label class="form-label">Nom</label>
                                    <div class="form-control form-control-lg">{{ personne.nom }}</div>
                                </div>
                                <div class="m-2">
                                    <label class="form-label">Prénom</label>
                                    <div class="form-control form-control-lg">{{ personne.prenom }}</div>
                                </div>
                            </div>
                            <div>
                                <div class="m-2">
                                    <label class="form-label">Téléphone</label>
                                    <div class="form-control form-control-lg">{{ personne.telephone }}</div>
                                </div>
                                <div class="m-2">
                                    <label class="form-label">Mail</label>
                                    <div class="form-control form-control-lg">{{ personne.mail }}</div>
                                </div>
                            </div>
                        </div>
                    </div>
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
    data() {
      return {
        personne: null
      };
    },
    mounted() {
      this.getPersonne();
    },
    methods: {
      async getPersonne() {
        try {
          const personne_id = this.$route.params.personne_id;
          console.log('PersonneID stocké:', personne_id);
          const response = await PersonnesService.getUserById(personne_id);
          this.personne = response.data; // Mettez ici la structure de votre objet utilisateur
        } catch (error) {
          console.error('Erreur lors de la récupération des informations de l\'utilisateur:', error.message);
        }
      }
    }
  };
  </script>