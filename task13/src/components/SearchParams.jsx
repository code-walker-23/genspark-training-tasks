import { useState, useEffect } from "react";
import Pet from "./Pet";
import useBreedList from "../hooks/useBreedList.js";

const ANIMALS = ["dog", "cat", "bird", "rabbit", "reptile"];

const SearchParams = () => {
  console.log("My Search Params Component Rendered ");
  const [location, setLocation] = useState("");
  const [animal,setAnimal]  =  useState("");
  const [breed,setBreed] = useState("");
  const [breeds, status] = useBreedList(animal);  
  console.log(breeds);
  
  return (
    <div className="search-params">
      <form>
        <label htmlFor="location">
          Location
          <input
            type="text"
            id="location"
            value={location}
            onChange={(event) => setLocation(event.target.value)}
          />
        </label>
        <label htmlFor="animal">
          Animal
          <select name="animal" id="animal" value={animal} onChange={(event) => setAnimal(event.target.value)}>
            <option />
            {ANIMALS.map((animal) => {
                return (
                    <option key={animal} value={animal}>
                    {animal}
                    </option>
                );
            })}
          </select>
        </label>
        <label htmlFor="breed">
          Breed
          <select name="breed" id="breed" value={breed} onChange={(event) => setBreed(event.target.value)} disabled={!breeds.length}>
            <option />
            {breeds.map((breed) => {
                return (
                    <option key={breed} value={breed}>
                    {breed}
                    </option>
                );
            })}
          </select>
        </label>
        <button onClick={(e) => handleLocation(e)}>Submit</button>
      </form>
    </div>
  );
};
export default SearchParams;