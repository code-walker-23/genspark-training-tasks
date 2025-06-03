import { useState, useEffect } from "react";

const useBreedList = (animal) => {
    const [breedList, setBreedList] = useState([]);
    const [status,setStatus] = useState("unloaded");
    
    useEffect(() => {
        if(!animal) {
            setBreedList([]);
        }
        else {
            
            fetchBreedsBasedOnAnimal();
        }
    },[animal])
    async function fetchBreedsBasedOnAnimal() {

     setBreedList([]);
     setStatus("loading");

    const res = await fetch(
      `http://pets-v2.dev-apis.com/breeds?animal=${animal}`
    );
    const json = await res.json();
    console.log(json);
    setBreedList(json.breeds || [])
    setStatus("loaded");
    }

    return [breedList, status];
}

export default useBreedList;