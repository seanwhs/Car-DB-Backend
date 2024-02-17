// carapi.ts
import { CarResponse, Car, CarEntry } from "../types";
import axios from "axios";

// List All Cars
export const getCars = async (): Promise<CarResponse[]> => {
  const response = await axios.get(`${import.meta.env.VITE_API_URL}/api/cars`);
  return response.data._embedded.cars;
};

//Delete ONE Car
export const deleteCar = async (link: string): Promise<CarResponse> => {
  const response = await axios.delete(link);
  return response.data;
};

// Add a new car
export const addCar = async (car: Car): Promise<CarResponse> => {
  const response = await axios.post(
    `${import.meta.env.VITE_API_URL}/api/cars`,
    car,
    {
      headers: {
        "Content-Type": "application/json",
      },
    }
  );

  return response.data;
};

//  Update Car
export const updateCar = async (carEntry: CarEntry): Promise<CarResponse> => {
  const response = await axios.put(carEntry.url, carEntry.car, {
    headers: {
      "Content-Type": "application/json",
    },
  });
  return response.data;
};
