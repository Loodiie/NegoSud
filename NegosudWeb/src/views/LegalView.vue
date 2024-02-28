<template>
  <div>
    <HeaderWeb />
    <div class="container py-5 h-100 min-vh-100">
      <div class="row d-flex justify-content-center align-items-center h-100">
        <div class="col mx-auto">
          <div class="card" style="border-radius: 1rem">
            <div class="row g-0">
              <div class="container">
                <h1>Mentions Légales - Negosud.com</h1>
                <h2><strong>Éditeur du Site :</strong></h2>
                <p>
                  Le site Negosud est édité par La Cave d'Élégance SARL, une
                  société à responsabilité limitée au capital de 100 000 euros,
                  immatriculée au registre du commerce et des sociétés de
                  Bordeaux sous le numéro 123456789, dont le siège social est
                  situé 25 Rue des Vignobles, 29450 Sizun.
                </p>
                <p>
                  Téléphone : +33 5 12 34 56 78<br />E-mail :
                  <a href="mailto:contact@negosud.com">contact@negosud.com</a
                  ><br />Directeur de la publication : Le Gouyen Elody
                </p>

                <h2><strong>2. Hébergeur du Site :</strong></h2>
                <p>
                  Le site est hébergé par VinoHosting SAS, société par actions
                  simplifiée, domiciliée 15 Rue du Vin, 75001 Paris,
                  immatriculée au registre du commerce et des sociétés de Paris
                  sous le numéro 987654321.
                </p>

                <h2><strong>3. Propriété Intellectuelle :</strong></h2>
                <p>
                  Tous les éléments constituant le site negosud.com, notamment
                  les textes, images, vidéos, logos, marques, etc., sont
                  protégés par le droit de la propriété intellectuelle. Toute
                  reproduction, représentation, modification, publication,
                  transmission ou adaptation, totale ou partielle, du contenu du
                  site est interdite, sauf autorisation écrite préalable de La
                  Cave d'Élégance SARL.
                </p>

                <h2>
                  <strong>4. Protection des Données Personnelles :</strong>
                </h2>
                <p>
                  Les informations collectées par le biais du site font l'objet
                  d'un traitement informatique destiné à gérer les commandes et
                  à améliorer l'expérience utilisateur. Conformément à la loi
                  "Informatique et Libertés" du 6 janvier 1978 et au Règlement
                  Général sur la Protection des Données (RGPD), vous disposez
                  d'un droit d'accès, de rectification et de suppression des
                  données vous concernant. Pour exercer ce droit, vous pouvez
                  contacter La Cave d'Élégance SARL à l'adresse suivante : 25
                  Rue des Vignobles, 33000 Bordeaux.
                </p>

                <h2><strong>5. Cookies :</strong></h2>
                <p>
                  Le site utilise des cookies pour améliorer votre expérience de
                  navigation. En poursuivant votre navigation sur ce site, vous
                  acceptez l'utilisation de cookies. Vous pouvez néanmoins
                  désactiver les cookies dans les paramètres de votre
                  navigateur.
                </p>

                <h2><strong>6. Liens Externes :</strong></h2>
                <p>
                  Le site peut contenir des liens hypertextes vers des sites
                  tiers. La Cave d'Élégance SARL ne saurait être tenu
                  responsable du contenu de ces sites tiers ni des éventuels
                  dommages pouvant résulter de leur utilisation.
                </p>

                <h2>
                  <strong>7. Loi Applicable et Juridiction Compétente :</strong>
                </h2>
                <p>
                  Les présentes mentions légales sont régies par le droit
                  français. En cas de litige, les tribunaux compétents seront
                  ceux du ressort du siège social de La Cave d'Élégance SARL.
                </p>

                <p>Fait à Sizun, le 27 février 2024.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <FooterWeb />
  </div>
</template>

<script setup>
import HeaderWeb from "../components/layout/HeaderWeb.vue";
import FooterWeb from "../components/layout/FooterWeb.vue";
</script>

<style scoped>
/* Ajoutez vos styles personnalisés ici */
.container {
  font-family: Arial, sans-serif;
}
.card {
  background-color: #f9f9f9;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}
h1 {
  text-align: center;
  margin-bottom: 30px;
}
h2 {
  margin-top: 30px;
}
p {
  line-height: 1.6;
}
</style>
