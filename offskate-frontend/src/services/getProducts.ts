import axios from 'axios';

export const getProducts = async () => {
    try{
        // Await the AxiosIstance() function call
        const response= await axios.get('http://54.198.100.184:8080/produtos');
        return response.data;

    } catch (error) {
        console.log("Erro ao buscar produtos");
        throw error;
    }
}

