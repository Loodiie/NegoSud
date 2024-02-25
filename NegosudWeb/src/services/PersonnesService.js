import axios from "axios";

const PERSONNES_API_BASE_URL = "http://localhost:29200/api/v1/personnes";

class PersonnesService {
  getPersonnes(config) {
    return axios.get(PERSONNES_API_BASE_URL, config);
  }
}

export default new PersonnesService();
