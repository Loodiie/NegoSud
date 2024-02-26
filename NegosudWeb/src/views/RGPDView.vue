<script setup>
import HeaderWeb from '../components/layout/HeaderWeb.vue'
import FooterWeb from '../components/layout/FooterWeb.vue'
</script>


<template>
    <HeaderWeb />

    <div class="container py-5 h-100 min-vh-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col mx-auto">
          <div class="card" style="border-radius: 1rem;">
            <div class="row g-0">
              <div class="col-md-6 col-lg-5 d-flex justify-content-center align-items-center">
                <img src="/src/assets/img/draw_wine.webp"
                  alt="login form" class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
              </div>
              <div class="col-md-6 col-lg-7 d-flex align-items-center">
                <div class="card-body p-4 p-lg-5 text-black">
                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">1. Collecte des données personnelles :</h5>
                    <section>
                        <p>
                            Nous collectons les données personnelles suivantes : [liste des données collectées].
                        </p>
                        <p>
                            Ces données sont collectées lorsque : [indiquez les circonstances de la collecte des données].
                        </p>
                        <p>
                            Les données personnelles sont collectées par le biais de : [précisez les moyens de collecte].
                        </p>
                        <p>
                            Lors de l'utilisation du site, peuvent être recueillies : [liste des données collectées].
                        </p>
                    </section>
                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">2. Utilisation des données :</h5>
                    <section>
                        <p>
                            Les données personnelles collectées sont utilisées pour : [précisez les finalités de l'utilisation des données].
                        </p>
                    </section>
                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">3. Confidentialité :</h5>
                    <section>
                        <p>
                            Les données personnelles ne seront ni échangées, ni vendues, ni louées à des tiers.
                        </p>
                    </section>
                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">4. Droit d'accès, de rectification et de suppression :</h5>
                    <section>
                        <p>
                            Conformément à la loi "Informatique et Libertés" du 6 janvier 1978 modifiée et au Règlement Général sur la Protection des Données (RGPD), vous disposez d'un droit d'accès, de rectification et de suppression des données vous concernant. Pour exercer ce droit, veuillez nous contacter à l'adresse suivante : [adresse de contact].
                        </p>
                    </section>
                    <section>
                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">5. Cookies :</h5>
                        <p>
                            Ce site utilise des cookies à des fins de mesure d'audience et d'amélioration de l'expérience utilisateur. En continuant à naviguer sur ce site, vous acceptez notre politique d'utilisation des cookies.
                        </p>
                    </section>

                    <section>
                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">6. Sécurité :</h5>
                        <p>
                            Les données personnelles sont conservées dans un environnement sécurisé. Les mesures de sécurité comprennent [décrivez les mesures de sécurité mises en place].
                        </p>
                    </section>

                    <section>
                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">7. Modification de la politique de confidentialité :</h5>
                        <p>
                            La présente politique de confidentialité peut être amenée à changer ou être modifiée à tout moment. Nous vous invitons donc à la consulter régulièrement.
                        </p>
                    </section>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <FooterWeb />
</template>

  