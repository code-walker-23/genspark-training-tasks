import "./shimmer.css"

const PetShimmer = () => {
  return (
    <div className="pet shimmer">
      <div className="image-container shimmer-img" />
      <div className="info shimmer-text">
        <div className="shimmer-line shimmer-line-lg" />
        <div className="shimmer-line shimmer-line-md" />
        <div className="shimmer-line shimmer-line-md" />
        <div className="shimmer-line shimmer-line-sm" />
        <div className="carousel-smaller shimmer-carousel">
          {[...Array(5)].map((_, i) => (
            <div key={i} className="shimmer-circle" />
          ))}
        </div>
      </div>
    </div>
  );
};

export default PetShimmer;
