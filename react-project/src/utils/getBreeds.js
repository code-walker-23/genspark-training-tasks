export async function getBreeds(animal) {
  if (!animal) return [];

  const res = await fetch(`https://pets-v2.dev-apis.com/breeds?animal=${animal}`);
  const json = await res.json();
  return json.breeds ?? [];
}
