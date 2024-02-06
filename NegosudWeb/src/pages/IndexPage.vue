<template>
  <q-page>
    <HeaderWeb />

    <q-page-section class="container-fluid hero-section p-4">
      <q-container>
        <q-row class="items-center">
          <q-col cols="12" md="5">
            <q-img
              src="/src/assets/img/wine_wallpaper.jpg"
              alt="Image héroïque"
              class="img-fluid rounded"
            />
          </q-col>
          <q-col cols="12" md="6">
            <div class="hero-content text-center">
              <h1>Nego'Sud vous accompagne</h1>
              <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum
                necessitatibus, reprehenderit fugit sapiente eius nostrum ut,
                consectetur velit est doloremque ex molestiae labore deserunt
                asperiores recusandae! Tempore, voluptatem officiis.
                Repudiandae.
              </p>
              <q-btn color="primary" label="Découvrez tous nos produits" />
            </div>
          </q-col>
        </q-row>
      </q-container>
    </q-page-section>

    <h2 class="text-center p-4">Nos meilleurs produits</h2>

    <BestProduct />

    <h2 class="text-center p-4" id="supplier">
      Retrouvez tous nos fournisseurs
    </h2>
    <q-page-section class="container-fluid p-4">
      <q-container>
        <q-row>
          <q-col
            cols="12"
            md="4"
            v-for="supplier in suppliers"
            :key="supplier.id"
          >
            <q-card>
              <q-img
                src="/src/assets/img/vignoble_card.jpg"
                class="card-img-top"
                alt="..."
              />
              <q-card-section>
                <h5 class="card-title">{{ supplier.supplierName }}</h5>
                <p class="card-text">
                  Lorem ipsum, dolor sit amet consectetur adipisicing elit. Sunt
                  voluptatibus dignissimos saepe a doloribus dolorem facilis
                  nesciunt officiis harum itaque maxime unde pariatur modi,
                  accusamus, cum, voluptates tempora possimus. Minus.
                </p>
                <p class="card-text">
                  <small class="text-muted"
                    >Contactez les directement au
                    {{ supplier.supplierPhone }}</small
                  >
                </p>
                <q-btn
                  color="primary"
                  label="Découvrez leurs produits"
                  class="mx-auto"
                />
              </q-card-section>
            </q-card>
          </q-col>
        </q-row>
      </q-container>
    </q-page-section>

    <FooterWeb />
  </q-page>
</template>

<script>
import fournisseurs from "../services/FournisseursListe";
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "fournisseurs",
  data() {
    return {
      fournisseurs: [],
    };
  },
  methods: {
    getFournisseurs() {
      fournisseursService.getFournisseurs().then((response) => {
        this.fournisseurs = response.data;
      });
    },
  },
  created() {
    this.getFournisseurs();
  },
};
</script>
