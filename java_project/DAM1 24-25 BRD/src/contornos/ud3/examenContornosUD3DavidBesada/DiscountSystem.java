package contornos.ud3.examenContornosUD3DavidBesada;

// AUTOR: DAVID BESADA RAMILO
// FECHA: 26-03-2025
// EXAMEN CONTORNOS UD3

public class DiscountSystem {
    public static double applyDiscount(double amount, boolean isLoyalCustomer) { // 1
        if (amount < 0) { // 2
            throw new IllegalArgumentException("O importe non pode ser negativo"); // 3
        }

        double discount = 0.0; // 4

        if (amount >= 50 && amount <= 100) { // 5
            discount = 0.05; // 6
        } else if (amount >= 100) { // 7 ERROR: El enunciado nos dice mayor o igual a 100 euros
            discount = 0.10; // 8
        }

        if (isLoyalCustomer || amount >= 200) { // 9 ERROR: Se comprueba que se cumplan las dos, no una de las dos
            discount += 0.05; // 10 ERROR: Se está restando el descuento en vez de sumarse
        }

        double finalAmount = amount - (amount * discount); // 11

        return finalAmount; // 12
    }
} // 13
