import axios from 'axios';

export const deleteProduct = async (id_produto: number) => {
    try{
        // Await the AxiosIstance() function call
        const response= await axios.delete(`http://54.198.100.184:8080/produtos/${id_produto}`);
        return response.data;

    } catch (error) {
        console.log("Erro ao buscar produtos");
        throw error;
    }
}

