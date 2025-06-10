import { useQuery } from "@tanstack/react-query";

const fetchPets = async ({ queryKey }) => {
  const [_key, { petId, location, breed, animal }] = queryKey;

  const params = new URLSearchParams();
  if (animal) params.append("animal", animal);
  if (location) params.append("location", location);
  if (breed) params.append("breed", breed);
  if (petId) params.append("id", petId);

  const response = await fetch(
    `https://pets-v2.dev-apis.com/pets?${params.toString()}`
  );

  if (!response.ok) {
    throw new Error("Failed to fetch pet data");
  }

  const data = await response.json();
  return data?.pets || [];
};

const useFetchPetWithId = (petId, location = "", breed = "", animal = "") => {
  return useQuery({
    queryKey: ["pets", { petId, location, breed, animal }],
    queryFn: fetchPets,
    enabled: true,
    staleTime: 1000 * 6, 
  });
};

export default useFetchPetWithId;
