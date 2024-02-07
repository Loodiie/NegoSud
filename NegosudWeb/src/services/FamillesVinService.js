import axios from "axios";

const FAMILLES_API_BASE_URL = "http://localhost:29200/api/v1/familles";

class FamillesService {
  getArticles() {
    return axios.get(FAMILLES_API_BASE_URL);
  }
}

export default new FamillesService();
