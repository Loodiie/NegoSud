<template>

    <div class="container py-5 min-h-100">
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
  
                    <div class="d-flex align-items-center mb-3 pb-1">
                      <a class="navbar-brand" href="/home">                
                          <img src="/src/assets/icons/logo_website.png" alt="" width="90" height="90" class="d-inline-block align-text-top">
                      </a>
                    </div>
  
                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Mot de passe oublié ?</h5>
  

  
                    <div class="form-outline mb-4">
                      <label class="form-label" for="emailConnexion">Adresse e-mail</label>
                      <input type="email" id="emailConnexion" class="form-control form-control-lg"/>
                    </div>

                    <div class="d-flex align-items-center justify-content-center pb-4 fw-normal mb-3 pb-3">
                      <a href = "/creationdecompte" type="button" class="btn btn-outline-danger" style="letter-spacing: 1px;">Réinitialiser mon mot de passe</a>
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