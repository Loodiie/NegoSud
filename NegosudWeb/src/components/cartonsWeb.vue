<template>
  <div class="container">
    <h1 class="text-center">Cartons list</h1>
    <table class="table table-striped">
      <thead>
        <th>Cartin Id</th>
        <th>Carton description</th>
      </thead>

      <tbody>
        <tr v-for="carton in cartons" v-bind:key="carton.id">
          <td>{{ carton.carton_id }}</td>
          <td>{{ carton.description }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import CartonsServices from "../services/cartonsService";
export default {
  name: "CartonsApi",
  data() {
    return {
      cartons: [],
    };
  },
  methods: {
    getCartons() {
      CartonsServices.getCartons().then((response) => {
        this.cartons = response.data;
      });
    },
  },
  created() {
    this.getCartons();
  },
};
</script>
