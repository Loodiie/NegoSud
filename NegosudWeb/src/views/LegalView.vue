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
                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">1. Mentions légales :</h5>
                    <section>
                      <p>
                        <strong>Nom de la société :</strong> {{ nomSociete }}<br>
                        <strong>Forme juridique :</strong> {{ formeJuridique }}<br>
                        <strong>Adresse du siège social :</strong> {{ adresseSiegeSocial }}<br>
                        <strong>Numéro de téléphone :</strong> {{ numeroTelephone }}<br>
                        <strong>Adresse e-mail :</strong> {{ adresseEmail }}<br>
                        <strong>Capital social :</strong> {{ capitalSocial }}<br>
                        <strong>Immatriculée au Registre du Commerce et des Sociétés de :</strong> {{ villeImmatriculation }} sous le numéro {{ numeroImmatriculation }}<br>
                        <strong>Numéro de TVA intracommunautaire :</strong> {{ numeroTVA }}<br>
                        <strong>Directeur de la publication :</strong> {{ directeurPublication }}
                      </p>
                    </section>
                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">2. Hébergeur du site :</h5>
                    <section>
                      <p>
                        <strong>Nom de l'hébergeur :</strong> {{ nomHebergeur }}<br>
                        <strong>Adresse :</strong> {{ adresseHebergeur }}<br>
                        <strong>Numéro de téléphone :</strong> {{ telephoneHebergeur }}
                      </p>
                    </section>
                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">3. Propriété intellectuelle :</h5>
                    <section>
                      <p>
                        Le présent site web et son contenu (textes, images, vidéos, etc.) sont la propriété exclusive de {{ nomSociete }} et/ou de ses partenaires. Toute reproduction, représentation, modification, publication, transmission ou dénaturation, totale ou partielle, du site ou de son contenu, par quelque procédé que ce soit, et sur quelque support que ce soit, est interdite.
                      </p>
                    </section>
                    <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">4. Données personnelles :</h5>
                    <section>
                      <p>
                        Les informations collectées sur ce site sont destinées à {{ nomSociete }}. Conformément à la loi "Informatique et Libertés" du 6 janvier 1978 modifiée, vous disposez d'un droit d'accès, de rectification et de suppression des données vous concernant. Pour exercer ce droit, veuillez nous contacter à l'adresse suivante : {{ adresseContact }}.
                      </p>
                    </section>
                    <section>
                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">5. Cookies :</h5>
                        <p>
                            Ce site utilise des cookies à des fins de mesure d'audience et d'amélioration de l'expérience utilisateur. En continuant à naviguer sur ce site, vous acceptez notre politique d'utilisation des cookies.
                        </p>
                    </section>

                    <section>
                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">6. Liens hypertextes :</h5>
                        <p>
                          Les liens hypertextes présents sur ce site renvoient vers d'autres sites internet et la responsabilité de {{ nomSociete }} ne saurait être engagée quant au contenu de ces sites.
                        </p>
                    </section>

                    <section>
                        <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">7. Loi applicable et juridiction compétente :</h5>
                        <p>
                          Les présentes mentions légales sont régies par la loi française. En cas de litige, les tribunaux français seront seuls compétents.
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
  
  <script>
  export default {
    data() {
      return {
        nomSociete: "NegoSud",
        formeJuridique: "Groupe étudiant",
        adresseSiegeSocial: "CESI Brest",
        numeroTelephone: "0606060606",
        adresseEmail: "negosud@gmail.com",
        capitalSocial: "10 000€",
        villeImmatriculation: "Brest",
        numeroImmatriculation: "26061995",
        numeroTVA: "08021991",
        directeurPublication: "Maewenn Porgeon",
        nomHebergeur: "CESI",
        adresseHebergeur: "Paris",
        telephoneHebergeur: "0606060607",
        adresseContact: "negosud@gmail.com"
      };
    }
  };
  </script>
  
  