/* eslint-disable no-unused-vars */
import { useParams } from "react-router-dom";
import Pet from "./Pet";
import useFetchPetWithId from "../../hooks/useFetchPet";
import PetShimmer from "../shimmer/PetShimmer";

const PetDetails = () => {
  const { id } = useParams();

  const {
    data: pets = [],
    isLoading,
    isError,
    error,
  } = useFetchPetWithId(id);

  if (!id) return <p>Invalid pet ID.</p>;
  if (isLoading) {
    return (
      <div>
        {[...Array(2)].map((_, i) => (
          <PetShimmer key={i} />
        ))}
      </div>
    );
  }
  if (isError) return <div>Error: {error.message}</div>;

  return (
    <div>
      <h2>
        You clicked pet with ID: <strong>{id}</strong>
      </h2>
      {pets.length > 0 ? (
        pets.map((pet) => {
          const {
            id,
            name = "Unknown",
            images = [],
            breed = "Unknown",
            animal = "Unknown",
            city = "Unknown",
            state = "Unknown",
            description = "No description available.",
          } = pet;

          return (
            <Pet
              key={id}
              id={id}
              name={name}
              images={images}
              breed={breed}
              animal={animal}
              city={city}
              state={state}
              description={description}
            />
          );
        })
      ) : (
        <p>No pet details found.</p>
      )}
    </div>
  );
};

export default PetDetails;
