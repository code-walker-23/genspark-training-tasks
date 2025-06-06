import { useState, useEffect } from "react";

const useFetchPetWithId = (petId, setPets, location = "", breed = "", animal = "") => {
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const fetchDetail = async () => {
    setLoading(true);
    setError(null);
    try {
      const queryParams = new URLSearchParams();
      if (animal) queryParams.append("animal", animal);
      if (location) queryParams.append("location", location);
      if (breed) queryParams.append("breed", breed);
      if (petId) queryParams.append("id", petId);

      const response = await fetch(
        `https://pets-v2.dev-apis.com/pets?${queryParams.toString()}`
      );

      if (!response.ok) {
        throw new Error("Failed to fetch pet data");
      }

      const data = await response.json();
      setPets(data?.pets || []);
    } catch (error) {
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchDetail();
  }, [petId, location, breed, animal]);

  return { loading, error };
};

export default useFetchPetWithId;
