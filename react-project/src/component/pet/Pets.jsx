// eslint-disable-next-line no-unused-vars
import Pet from "./Pet";

const Pets = ({ pets }) => {
  if (!pets.length) {
    return <div>No Pets Found</div>;
  }

  return (
    <div className="search">
      {pets.map((pet) => (
        <Pet
          key={pet.id}
          id={pet.id}
          name={pet.name}
          animal={pet.animal}
          breed={pet.breed}
          images={pet.images}
          city={pet.city}
          state={pet.state}
          description={pet.description}
        />
      ))}
    </div>
  );
};

export default Pets;
