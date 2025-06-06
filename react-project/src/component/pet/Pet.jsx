/* eslint-disable no-unused-vars */
import { Link } from "react-router-dom";
import "./pet.css";

const Pet = (props) => {
  const {
    name = "Unknown",
    animal = "Unknown",
    breed = "Unknown",
    images = [],
    state = "Unknown",
    city = "Unknown",
    id = 0,
    description = "No description available.",
  } = props ?? {};
  
  return (
    <Link to={`/pets/${id ?? 0}`} className="pet">
      <div className="image-container" style={{ float: "left" }}>
        <img
          src={images?.[0] ?? "https://via.placeholder.com/100"}
          alt={name ?? "Pet Image"}
        />
      </div>
      <div className="info">
        <h1>{name ?? "Unknown"}</h1>
        <h2>{`${animal ?? "Unknown"} — ${breed ?? "Unknown"}`}</h2>
        <h2>{`${city ?? "Unknown"}, ${state ?? "Unknown"}`}</h2>
        <p style={{ marginTop: "10px", fontSize: "14px", lineHeight: "1.3" }}>
          {description?.length > 100
            ? description.substring(0, 100) + "..."
            : description}
        </p>
        <div className="carousel-smaller">
          {Array.isArray(images) && images.length > 0 ? (
            images.map((img, index) => (
              <img
                key={index}
                src={img ?? "https://via.placeholder.com/75"}
                alt={`${name ?? "Pet"} ${index + 1}`}
                title={`Image ${index + 1}`}
                className="pet-image"
              />
            ))
          ) : (
            <p>No additional images available.</p>
          )}
        </div>
      </div>
    </Link>
  );
};

export default Pet;
