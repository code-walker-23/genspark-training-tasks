/* eslint-disable no-unused-vars */
import { useState, useEffect } from "react";
import Pets from "./component/pet/Pets";
import { getPetFilters } from "./utils/getPetFilters";
import useFetchPetWithId from "./hooks/useFetchPet";
import { getBreeds } from "./utils/getBreeds";

const SearchParams = () => {
  const [location, setLocation] = useState("");
  const [animal, setAnimal] = useState("");
  const [breed, setBreed] = useState("");
  const [locations, setLocations] = useState([]);
  const [breeds, setBreeds] = useState([]);
  const [animals, setAnimals] = useState([]);

  const {
    data: pets = [],
    isLoading,
    isError,
    error,
  } = useFetchPetWithId("", location, breed, animal);

  useEffect(() => {
    const fetchFilters = async () => {
      const { locations, animals } = await getPetFilters();
      setLocations(locations);
      setAnimals(animals);
    };

    fetchFilters();
  }, []);

  useEffect(() => {
    const fetchBreeds = async () => {
      setBreed(""); // clear previous breed
      const breeds = await getBreeds(animal);
      setBreeds(breeds);
    };

    fetchBreeds();
  }, [animal]);

  return (
    <div className="search-params">
      <form>
        <label htmlFor="location">
          Location
          <select
            id="location"
            value={location}
            onChange={(event) => setLocation(event.target.value)}
          >
            <option />
            {locations.map((loc) => (
              <option key={loc} value={loc}>
                {loc}
              </option>
            ))}
          </select>
        </label>

        <label htmlFor="animal">
          Animal
          <select
            name="animal"
            id="animal"
            value={animal}
            onChange={(event) => setAnimal(event.target.value)}
          >
            <option />
            {animals.map((animal) => (
              <option key={animal} value={animal}>
                {animal}
              </option>
            ))}
          </select>
        </label>

        <label htmlFor="breed">
          Breed
          <select
            name="breed"
            id="breed"
            value={breed}
            onChange={(event) => setBreed(event.target.value)}
            disabled={!breeds.length}
          >
            <option />
            {breeds.map((breed) => (
              <option key={breed} value={breed}>
                {breed}
              </option>
            ))}
          </select>
        </label>

        <button type="submit">Submit</button>
      </form>

      {isLoading ? (
        <h2>Loading pets...</h2>
      ) : isError ? (
        <h2>Error: {error.message}</h2>
      ) : (
        <Pets pets={pets} />
      )}
    </div>
  );
};

export default SearchParams;
