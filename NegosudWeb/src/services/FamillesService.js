import axios from 'axios'

const FAMILLES_API_BASE_URL = "http://localhost:29200/api/v1/familles";

class FamillesService {

    getFamilles() {
        return axios.get(FAMILLES_API_BASE_URL);
    }

    getFamillesById(famille_id) {
        const url = `${FAMILLES_API_BASE_URL}/${famille_id}`;
        return axios.get(url);
    }
}

export default new FamillesService()