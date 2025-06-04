import { useEffect, useState } from "react";

export const App = () => {
  const [count, setCount] = useState(0);
  const [inputValue, setInputValue] = useState("");

  function decrementHandler() {
    setCount((prev) => prev - 1);
  }

  function incrementHandler() {
    setCount((prev) => prev + 1);
  }

  useEffect(() => {
    setInputValue(count);
    console.log(count);
  }, [count]);

  function resetHandler() {
    setCount(0);
  }

  function userInputHandler(event) {
    const value = event.target.value;
    setInputValue(value);
  }
  function submitHandler(e) {
    e.preventDefault();
    if (inputValue != "") setCount(+inputValue);
  }

  return (
    <section className="counter-container">
      <h1>Days Since the Last Accident</h1>
      <p className="count">{count}</p>
      <div className="button-group">
        <button onClick={decrementHandler}>➖ Decrement</button>
        <button onClick={resetHandler}>🔁 Reset</button>
        <button onClick={incrementHandler}>➕ Increment</button>
      </div>
      <form onSubmit={submitHandler} className="counter-form">
        <input type="number" value={inputValue} onChange={userInputHandler} />
        <button type="submit">Update Counter</button>
      </form>
    </section>
  );
};
