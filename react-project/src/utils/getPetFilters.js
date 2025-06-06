export const getPetFilters = async () => {
  try {
    const response = await fetch("http://pets-v2.dev-apis.com/pets");
    if (!response.ok) {
      throw new Error("Failed to fetch pet data");
    }

    const data = await response.json();
    const pets = data?.pets || [];

    const locationSet = new Set();
    const breedSet = new Set();
    const animalSet = new Set();

    pets.forEach((pet) => {
      if (pet?.city && pet?.state) {
        locationSet.add(`${pet.city}, ${pet.state}`);
      }
      if (pet?.breed) {
        breedSet.add(pet.breed);
      }
      if (pet?.animal) {
        animalSet.add(pet.animal);
      }
    });

    return {
      locations: Array.from(locationSet),
      breeds: Array.from(breedSet),
      animals: Array.from(animalSet),
    };
  } catch (error) {
    console.error("Error fetching pet filters:", error);
    return {
      locations: [],
      breeds: [],
      animals: [],
    };
  }
};
