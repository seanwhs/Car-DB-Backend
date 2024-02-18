import { describe, expect, test } from 'vitest';
import { render, screen, waitFor } from '@testing-library/react';
import '@testing-library/jest-dom/vitest';
import CarList from "./CarList";
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';

const queryClient = new QueryClient({
    defaultOptions: {
        queries: {
            retry: false,
        },
    },
});

const wrapper = ({
    children }: { children: React.ReactNode }) => (
    <QueryClientProvider client={
        queryClient}>{children}
    </QueryClientProvider>);

describe("Carlist tests", () => {

    test("component renders", () => {
        render(<CarList />, {wrapper});
        expect(screen.getByText(/Loading/i)).toBeInTheDocument();
    })

    test("Cars are fetched", async () => {
        render(<CarList />, { wrapper });
        await waitFor(() => screen.getByText(/New Car/i));
        expect(screen.getByText(/Ford/i)).toBeInTheDocument();
    })

});