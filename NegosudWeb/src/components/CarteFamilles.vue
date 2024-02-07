<template>
  <q-row cols="1" cols-md="4" class="q-gutter-md">
    <q-col v-for="famille in familles" :key="famille.id">
      <q-card class="full-height">
        <q-img
          src="../assets/img/bouteille_vin.jpg"
          class="q-pa-md"
          alt="Vin"
        />
        <q-badge color="negative" class="absolute-top-right">{{
          famille.annee
        }}</q-badge>
        <q-card-section class="q-pa-md">
          <q-card-title>{{ famille.libelle }}</q-card-title>
          <q-card-subtitle>{{
            this.getFournisseurLibelle(famille.fournisseurId)
          }}</q-card-subtitle>
          <q-card-subtitle class="text-center"
            ><em>{{
              this.getTypeVinLibelle(famille.typeVinId)
            }}</em></q-card-subtitle
          >
        </q-card-section>
        <q-card-actions align="around">
          <span class="text-h6">{{ famille.prix_unit.toFixed(2) }}€</span>
          <q-btn color="primary" label="Voir le produit" />
        </q-card-actions>
      </q-card>
    </q-col>
  </q-row>
</template>

<script>
import FamillesService from "src/services/FamillesService";
import FournisseursService from "src/services/FournisseursService";
import TypeVinService from "src/services/TypeVinService";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "familles",
  name: "fournisseurs",
  name: "typeVin",
  data() {
    return {
      familles: [],
      fournisseur: [],
      typeVin: [],
    };
  },
  methods: {
    getFamilles() {
      FamillesService.getFamilles().then((response) => {
        this.familles = response.data;
      });
    },
    getFournisseurs() {
      FournisseursService.getFournisseurs().then((response) => {
        this.fournisseur = response.data;
      });
    },
    getTypeVin() {
      TypeVinService.getTypeVin().then((response) => {
        this.typeVin = response.data;
      });
    },
    getFournisseurLibelle(fournisseurId) {
      var four = this.fournisseur.find(
        (element) => element.id === fournisseurId
      );
      return four?.nom;
    },
    getTypeVinLibelle(typeVinId) {
      var vin = this.typeVin.find((element) => element.id === typeVinId);
      return vin?.libelle;
    },
  },
  created() {
    this.getFamilles();
    this.getFournisseurs();
    this.getTypeVin();
  },
};
</script>
