import axios from 'axios';

const PERSONNES_API_BASE_URL = "http://localhost:29200/api/v1/personnes";
let loggedInUserId = null;

export function setLoggedInUserId(personne_id) {
    loggedInUserId = personne_id;
}

export function getLoggedInUserId() {
    return loggedInUserId;
}

class PersonnesService {

    createPersonnes(userData) {
        return axios.post(PERSONNES_API_BASE_URL, userData);
    }

    getPersonnesById(personne_id) {
        const url = `${PERSONNES_API_BASE_URL}/${personne_id}`;
        return axios.get(url);
    }

    async loginUser(mail, password) {
        try {
            // Construire l'URL avec les paramètres
            const url = `${PERSONNES_API_BASE_URL}/login?mail=${encodeURIComponent(mail)}&password=${encodeURIComponent(password)}`;
            
            // Envoyer la requête GET à l'API
            const response = await axios.get(url);

            // Gérer la réponse de l'API
            const { personne_id, token } = response.data;
            console.log('ID:', personne_id);
            console.log('Token:', token);

            // Gérer l'authentification réussie (par exemple, rediriger l'utilisateur vers une page sécurisée)
            return { personne_id, token };
        } catch (error) {
            // Gérer les erreurs (par exemple, afficher un message d'erreur à l'utilisateur)
            console.error('Erreur de connexion:', error.message);
            throw error;
        }
    }

}

export default new PersonnesService();
