/* eslint-disable no-unused-vars */
import React from "react";
import ReactDOM from "react-dom/client";
import SearchParams from "./SearchParams";
import { RouterProvider, createBrowserRouter } from "react-router-dom";
import RootLayout from "./RootLayout";
import NotFound from "./component/error/ErrorPage";
import PetDetails from "./component/pet/PetDetails";

// React Query
import {
  QueryClient,
  QueryClientProvider,
} from "@tanstack/react-query";
import { ReactQueryDevtools } from "@tanstack/react-query-devtools";

const queryClient = new QueryClient();

const App = () => {
  const appRouter = createBrowserRouter([
    {
      path: "/",
      element: <RootLayout />,
      children: [
        { path: "", element: <SearchParams /> },
        {
          path: "pets",
          element: <SearchParams />,
        },
        {
          path: "pets/:id",
          element: <PetDetails />,
        },
      ],
      errorElement: <NotFound />,
    },
  ]);

  return <RouterProvider router={appRouter} />;
};

const container = document.getElementById("root");
const root = ReactDOM.createRoot(container);

root.render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
      <App />
      <ReactQueryDevtools initialIsOpen={false} />
    </QueryClientProvider>
  </React.StrictMode>
);
