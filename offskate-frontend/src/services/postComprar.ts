import axios from 'axios';

export const createCompra = async (formData: any) => {
    try{
        const response= await axios.post('http://54.198.100.184:8080/compras', formData, {
            headers: {
                'Content-Type': 'application/json'
            }
        });
        return response.data;

    } catch (error) {
        console.log("Erro ao criar produtos");
        throw error;
    }
}

