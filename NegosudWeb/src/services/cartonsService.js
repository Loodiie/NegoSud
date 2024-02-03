import axios from "axios";

const cartonsAPI = "http://localhost:29200/api/v1/cartons";

class CartonsServices {
  getCartons() {
    return axios.get(cartonsAPI);
  }
}

export default new CartonsServices();
