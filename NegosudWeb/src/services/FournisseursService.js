import axios from "axios";

const FOURNISSEURS_API_BASE_URL = "http://localhost:29200/api/v1/fournisseurs";

class FournisseursService {
  getFournisseurs() {
    return axios.get(FOURNISSEURS_API_BASE_URL);
  }
}

export default new FournisseursService();