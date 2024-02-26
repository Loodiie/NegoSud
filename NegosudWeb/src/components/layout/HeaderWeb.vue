<template>
    <nav class = "navbar navbar-expand-lg navbar-light bg-light mb-4">
        <div class="container-fluid">
            <div class="col-md-5 collapse navbar-collapse" id="navbarNavDropdown">
                <RouterLink class="navbar-brand" to="/">                
                    <img src="/src/assets/icons/duck.png" alt="" width="90" height="90" class="d-inline-block align-text-top">
                </RouterLink>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <RouterLink class="nav-link active" aria-current="page" to="/">Accueil</RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink class="nav-link" to="/allproducts">Nos produits</RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink class="nav-link" to="/qui-sommes-nous">Qui sommes-nous ?</RouterLink>
                    </li>
                </ul>
            </div>
            <div class="col-md-4">
                <form class="d-flex" @submit.prevent="search">
                    <input class="form-control me-2" type="search" placeholder="Rechercher un produit" aria-label="Search" v-model="searchTerm">
                    <button class="btn btn-outline-success" type="submit">Recherche</button>
                </form>
            </div>
            <div class="col-md-3 d-flex justify-content-around">
                <RouterLink v-if="isLoggedIn" to="/MyAccount">
                    <svg xmlns="http://www.w3.org/2000/svg" id="Layer_1" data-name="Layer 1" viewBox="0 0 24 24" width="25" height="25"><path d="M9,12c3.309,0,6-2.691,6-6S12.309,0,9,0,3,2.691,3,6s2.691,6,6,6Zm0-11c2.757,0,5,2.243,5,5s-2.243,5-5,5-5-2.243-5-5S6.243,1,9,1Zm3.767,14.94c-1.151-.615-2.454-.94-3.767-.94-4.411,0-8,3.589-8,8v.5c0,.276-.224,.5-.5,.5s-.5-.224-.5-.5v-.5c0-4.962,4.038-9,9-9,1.478,0,2.943,.366,4.239,1.059,.244,.13,.335,.433,.205,.677-.13,.244-.433,.334-.677,.205Zm10.5-4.208c-.943-.944-2.592-.944-3.535,0l-7.707,7.707c-.661,.661-1.025,1.54-1.025,2.475v1.586c0,.276,.224,.5,.5,.5h1.586c.935,0,1.814-.364,2.475-1.025l7.707-7.707c.472-.472,.732-1.1,.732-1.768s-.26-1.296-.732-1.768Zm-.707,2.828l-7.707,7.707c-.472,.472-1.1,.732-1.768,.732h-1.086v-1.086c0-.668,.26-1.295,.732-1.768l7.707-7.707c.566-.566,1.555-.566,2.121,0,.283,.283,.439,.66,.439,1.061s-.156,.777-.439,1.061Z"/></svg>
                </RouterLink>
                <RouterLink to = "#">
                <svg xmlns="http://www.w3.org/2000/svg" id="Layer_1" data-name="Layer 1" viewBox="0 0 24 24" width="25" height="25"><path d="m14.75,7c-1.199,0-2.189.551-2.75,1.434-.561-.883-1.551-1.434-2.75-1.434-1.792,0-3.25,1.57-3.25,3.5,0,3.363,5.479,7.246,5.713,7.409.086.061.187.091.287.091s.201-.03.287-.091c.233-.163,5.713-4.046,5.713-7.409,0-1.93-1.458-3.5-3.25-3.5Zm-2.75,9.883c-1.625-1.203-5-4.163-5-6.383,0-1.379,1.009-2.5,2.25-2.5,1.325,0,2.25.916,2.25,2.228v.272c0,.276.224.5.5.5s.5-.224.5-.5v-.272c0-1.312.925-2.228,2.25-2.228,1.241,0,2.25,1.121,2.25,2.5,0,2.22-3.375,5.18-5,6.383ZM12.837.028c-3.477-.236-6.876,1.036-9.329,3.492C1.057,5.977-.211,9.379.029,12.854c.441,6.354,6.074,11.146,13.104,11.146h6.367c2.481,0,4.5-2.019,4.5-4.5v-7.145C24,5.869,19.097.454,12.837.028Zm10.163,19.472c0,1.93-1.57,3.5-3.5,3.5h-6.367c-6.604,0-11.695-4.296-12.105-10.214-.221-3.188.941-6.308,3.188-8.559,2.071-2.073,4.878-3.227,7.8-3.227.25,0,.502.008.753.025,5.737.39,10.23,5.366,10.23,11.329v7.145Z"/></svg>
                </RouterLink>
                <RouterLink class="nav-link" to="/panier">
                <svg xmlns="http://www.w3.org/2000/svg" id="Layer_1" data-name="Layer 1" viewBox="0 0 24 24" width="25" height="25"><path d="M23.38,8.853c-.475-.542-1.16-.853-1.88-.853h-.566C20.433,3.479,16.603,0,12,0S3.567,3.479,3.066,8h-.566c-.72,0-1.405,.311-1.88,.853S-.073,10.116,.021,10.831l1.12,8.396c.363,2.721,2.707,4.772,5.452,4.772h10.812c2.745,0,5.089-2.052,5.451-4.772l1.121-8.397c.095-.714-.124-1.436-.599-1.978ZM12,1c4.054,0,7.434,3.035,7.93,7H4.07c.495-3.965,3.876-7,7.93-7Zm10.986,9.698l-1.12,8.396c-.296,2.227-2.214,3.905-4.46,3.905H6.594c-2.246,0-4.164-1.679-4.461-3.905L1.014,10.699c-.058-.43,.073-.862,.358-1.188s.696-.512,1.128-.512H21.5c.432,0,.843,.187,1.128,.512s.416,.758,.358,1.187Zm-10.486,1.802v7c0,.276-.224,.5-.5,.5s-.5-.224-.5-.5v-7c0-.276,.224-.5,.5-.5s.5,.224,.5,.5Zm5.5,0v7c0,.276-.224,.5-.5,.5s-.5-.224-.5-.5v-7c0-.276,.224-.5,.5-.5s.5,.224,.5,.5Zm-11,0v7c0,.276-.224,.5-.5,.5s-.5-.224-.5-.5v-7c0-.276,.224-.5,.5-.5s.5,.224,.5,.5Z"/></svg>
                </RouterLink>
                <RouterLink to = "/connexion" type="button" class="btn btn-outline-danger">Se connecter</RouterLink>
            </div>
        </div>
    </nav>
</template>

<script>
import { getLoggedInUserId } from '@/services/PersonnesService';

export default {
  computed: {
    isLoggedIn() {
      // Vérifie si un utilisateur est connecté en utilisant l'ID stocké
      return !!getLoggedInUserId();
    },
    loggedInUserId() {
      // Récupère l'ID de l'utilisateur connecté
      return getLoggedInUserId();
    }
  }
};
</script>