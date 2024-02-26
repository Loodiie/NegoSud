import axios from "axios";

const TYPEVIN_API_BASE_URL = "http://localhost:29200/api/v1/typeVin";

class TypeVinService {
  getTypeVin() {
    return axios.get(TYPEVIN_API_BASE_URL);
  }
  getTypeVinById(typeVin_id) {
    const url = `${TYPEVIN_API_BASE_URL}/${typeVin_id}`;
    return axios.get(url);
  }
}


export default new TypeVinService();
