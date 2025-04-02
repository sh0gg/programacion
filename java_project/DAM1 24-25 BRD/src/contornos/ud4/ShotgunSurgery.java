package contornos.ud4;

// Autor: David Besada
// Bad Smell: Ciruxía a tiros (Shotgun surgery)

/* Este problema ocorre cando un pequeno cambio no sistema
require modificar moitas clases diferentes ao mesmo tempo.
Isto dificulta o mantemento, aumenta o risco de erros e fai que o código sexa fráxil.
Isto normalmente é un síntoma de que unha responsabilidade
está mal distribuída ou duplicada en moitos lugares. */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ShotgunSurgery {

    // Versión con mal cheiro (duplicación da lóxica de formato en varias clases,
    // se cambio un formato, teño que cambialo en todas as partes na que aparece.)

    public class Order {
        private LocalDate orderDate;

        public String getFormattedDate() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return orderDate.format(formatter);
        }
    }

    public class Invoice {
        private LocalDate invoiceDate;

        public String getFormattedDate() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return invoiceDate.format(formatter);
        }
    }

    public class Notification {
        private LocalDate sentDate;

        public String getFormattedDate() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            return sentDate.format(formatter);
        }
    }

    // 💡 Solución: Centralizar a lóxica nunha clase DateFormatter

    public static class DateFormatter {
        private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        public static String format(LocalDate date) {
            return date.format(FORMATTER);
        }
    }

    // Versión refactorizada das clases

    public class OrderRefactored {
        private LocalDate orderDate;

        public String getFormattedDate() {
            return DateFormatter.format(orderDate);
        }
    }

    public class InvoiceRefactored {
        private LocalDate invoiceDate;

        public String getFormattedDate() {
            return DateFormatter.format(invoiceDate);
        }
    }

    public class NotificationRefactored {
        private LocalDate sentDate;

        public String getFormattedDate() {
            return DateFormatter.format(sentDate);
        }

    }
}
